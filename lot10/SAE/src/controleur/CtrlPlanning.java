package controleur;

import java.util.List;
import java.util.stream.Stream;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.HashSet;
import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.*;

public class CtrlPlanning {

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

    private final HashSet<CategorieSpectacle> allowedCategories = new HashSet<>();
    private final HashSet<String> allowedGenres = new HashSet<>();
    
    private void onMbCategorieChecked(CategorieSpectacle cat, Boolean checked)
    {
        if (checked) {
            allowedCategories.add(cat);
        } else {
            allowedCategories.remove(cat);
        }
        
        updateFilter();
    }
    
    private void onMbGenreChecked(String genre, Boolean checked)
    {
        if (checked) {
            allowedGenres.add(genre);
        } else {
            allowedGenres.remove(genre);
        }
        
        updateFilter();
    }
    
    
    private static LocalDate getDate(Representation r) {
        return r.getDateHeure().toLocalDate();
    }
    
    public void initialize() {
        // Commencer avec toutes les représentations
        dpDe.setValue(representations.stream().map(CtrlPlanning::getDate).min(LocalDate::compareTo).orElse(null));
        dpA.setValue(representations.stream().map(CtrlPlanning::getDate).max(LocalDate::compareTo).orElse(null));
        
    	mbCategorie.getItems().addAll(Stream.of(CategorieSpectacle.values())
			.map((c) -> newCheckedMenuItem(c, this::onMbCategorieChecked)).toList());
    	
    	mbGenre.getItems().addAll(Donnees.getGenres().stream()
			.map((c) -> newCheckedMenuItem(c, this::onMbGenreChecked)).toList());
    	

    	lErreurDate.visibleProperty().bind(Bindings.createBooleanBinding(	
			() -> dpA.getValue() != null && dpDe.getValue() != null && dpA.getValue().compareTo(dpDe.getValue()) < 0,
			dpA.valueProperty(), dpDe.valueProperty()));
    	
    	tcDuree.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getDuree() + " min"));
    	tcCategorie.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getCategorie().name()));
    	tcCapacite.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getCapacite() + " pers."));
    	tcNom.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getNom()));
    	tcGenre.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getRepresente().getGenre()));
    	tcDate.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDateHeure().toString()));
        
        tvRepresentations.setItems(representations);
        
        updateFilter();
        
        dpDe.setOnAction(this::updateFilter);
        dpA.setOnAction(this::updateFilter);
        mbCategorie.setOnAction(this::updateFilter);
        mbGenre.setOnAction(this::updateFilter);
    }
    
    public void setRepresentations(List<Representation> representations) {
    	this.representations.clear();
    	this.representations.addAll(representations);
    }
    
    private void updateFilter(ActionEvent e) {
        updateFilter();
    }
    
    private void updateFilter() {
        representations.setPredicate(this::filter);
    }
    
    private boolean filter(Representation r) {
        var date = r.getDateHeure().toLocalDate();
        var min = dpDe.getValue();
        var max = dpA.getValue();
    	return min != null && max != null && min.isBefore(date) && max.isAfter(date)
    	       && allowedCategories.contains(r.getRepresente().getCategorie())
    	       && allowedGenres.contains(r.getRepresente().getGenre());
    }
    
    private <T> CheckMenuItem newCheckedMenuItem(T content, BiConsumer<T, Boolean> onChecked) {
    	var item = new CheckMenuItem(content.toString());
    	item.setSelected(true);
    	onChecked.accept(content, true);
    	item.setOnAction((e) -> onChecked.accept(content, item.isSelected()));
    	return item;
    }
}
