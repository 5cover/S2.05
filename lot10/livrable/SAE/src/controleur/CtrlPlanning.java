package controleur;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.CategorieSpectacle;
import modele.Donnees;
import modele.Representation;

public class CtrlPlanning {

    private static LocalDate getDate(Representation r) {
        return r.getDateHeure().toLocalDate();
    }

    @FXML
    private DatePicker dpDe;

    @FXML
    private DatePicker dpA;

    @FXML
    private TableColumn<Representation, String> tcDuree;

    @FXML
    private TableView<Representation> tvRepresentations;

    @FXML
    private TableColumn<Representation, String> tcCategorie;

    @FXML
    private TableColumn<Representation, String> tcDate;

    @FXML
    private TableColumn<Representation, String> tcCapacite;

    @FXML
    private TableColumn<Representation, String> tcNom;

    @FXML
    private MenuButton mbCategorie;

    @FXML
    private TableColumn<Representation, String> tcGenre;

    @FXML
    private Label lErreurDate;

    @FXML
    private MenuButton mbGenre;

    private final FilteredList<Representation> representations = new FilteredList<>(Donnees.getLesRepresentattion());
    private final HashSet<CategorieSpectacle> filteredCategories = new HashSet<>();

    private final HashSet<String> filteredGenres = new HashSet<>();

    private boolean filter(Representation r) {
        var date = getDate(r);
        var min = dpDe.getValue();
        var max = dpA.getValue();
        return min != null && max != null && min.compareTo(date) <= 0 && max.compareTo(date) >= 0
                && (filteredCategories.isEmpty() || filteredCategories.contains(r.getRepresente().getCategorie()))
                && (filteredGenres.isEmpty() || filteredGenres.contains(r.getRepresente().getGenre()));
    }

    public void initialize() {
        // Commencer avec toutes les représentations
        dpDe.setValue(representations.stream().map(CtrlPlanning::getDate).min(LocalDate::compareTo).orElse(null));
        dpA.setValue(representations.stream().map(CtrlPlanning::getDate).max(LocalDate::compareTo).orElse(null));

        mbCategorie.getItems().addAll(Stream.of(CategorieSpectacle.values())
                .map((c) -> newCheckedMenuItem(c, this::onMbCategorieChecked)).toList());

        mbGenre.getItems().addAll(
                Donnees.getGenres().stream().map((c) -> newCheckedMenuItem(c, this::onMbGenreChecked)).toList());

        lErreurDate.visibleProperty()
                .bind(Bindings.createBooleanBinding(
                        () -> dpA.getValue() != null && dpDe.getValue() != null
                                && dpA.getValue().isBefore(dpDe.getValue()),
                        dpA.valueProperty(), dpDe.valueProperty()));

        tcDuree.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getDuree() + " min"));
        tcCategorie
                .setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getCategorie().name()));
        tcCapacite.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getRepresente().getCapacite() + " pers."));
        tcNom.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getNom()));
        tcGenre.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getGenre()));
        tcDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDateHeure().toString()));

        tvRepresentations.setItems(representations);

        updateFilter();
    }

    private <T> CheckMenuItem newCheckedMenuItem(T content, BiConsumer<T, Boolean> onChecked) {
        var item = new CheckMenuItem(content.toString());
        item.setOnAction((e) -> onChecked.accept(content, item.isSelected()));
        return item;
    }

    private void onMbCategorieChecked(CategorieSpectacle cat, Boolean checked) {
        if (checked) {
            filteredCategories.add(cat);
        } else {
            filteredCategories.remove(cat);
        }

        updateFilter();
    }

    private void onMbGenreChecked(String genre, Boolean checked) {
        if (checked) {
            filteredGenres.add(genre);
        } else {
            filteredGenres.remove(genre);
        }

        updateFilter();
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations.clear();
        this.representations.addAll(representations);
    }

    private void updateFilter() {
        representations.setPredicate(this::filter);
    }

    @FXML
    private void updateFilter(ActionEvent e) {
        updateFilter();
    }
}
