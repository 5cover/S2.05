package controleur;

import java.util.List;
import java.util.stream.Stream;

import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.CategorieSpectacle;
import modele.Representation;

public class CtrlPlanning {

    @FXML
    private DatePicker dpDe;

    @FXML
    private DatePicker dpA;

    @FXML
    private TableColumn<Representation, Integer> tcDuree;

    @FXML
    private TableView<Representation> tvRepresentations;

    @FXML
    private TableColumn<Representation, CategorieSpectacle> tcCategorie;

    @FXML
    private TableColumn<Representation, String> tcDate;

    @FXML
    private TableColumn<Representation, Integer> tcCapacite;

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
    
    private FilteredList<Representation> representations;

    public void initialize() {
    	representations = new FilteredList<Representation>(tvRepresentations.getItems());
    	
    	mbCategorie.getItems().addAll(Stream.of(CategorieSpectacle.values())
			.map((c) -> new CheckMenuItem(c.toString())).toList());
    	
    	

    	lErreurDate.visibleProperty().bind(Bindings.createBooleanBinding(
			() -> dpA.getValue() != null && dpDe.getValue() != null && dpA.getValue().compareTo(dpDe.getValue()) < 0,
			dpA.valueProperty(), dpDe.valueProperty()));
    }
    
    public void setRepresentations(List<Representation> representations) {
    	this.representations.clear();
    	this.representations.addAll(representations);
    }
}
