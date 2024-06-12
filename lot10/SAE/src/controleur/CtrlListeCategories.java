package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableView;
import modele.CategorieSpectateur;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class CtrlListeCategories {

    @FXML
    private Button btnSupprimerCategorie;

    @FXML
    private Button btnModifieCategorie;

    @FXML
    private Button btnAjoutCategorie;

    @FXML
    private TableView<CategorieSpectateur> tvListeCategorie;

    static private ObservableList<CategorieSpectateur> 	lstCategorie = FXCollections.observableArrayList();

    private MenuItem optionAjouter = new MenuItem("Ajouter...");
    private MenuItem optionModifier = new MenuItem("Modifier...");
    private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
    private ContextMenu menu = new ContextMenu( optionAjouter,
    		 new SeparatorMenuItem(), 
    		optionModifier,
    		 new SeparatorMenuItem(),
    		 optionSupprimer);


    @FXML
    void ajouterCategorie(ActionEvent event) {
        Main.afficherCreationCategorie(null);
    }

    @FXML
    void modifierCategorie(ActionEvent event) {
        Main.afficherCreationCategorie(tvListeCategorie.getSelectionModel().getSelectedItem());
    }

    @FXML
    void supprimerCategorie(ActionEvent event) {
        Alert alert = new Alert(
		    		AlertType.CONFIRMATION,
		    		"Voulez-vous vraiment supprimer cette catégorie ?",
		    		ButtonType.YES,
		    		ButtonType.NO
		    	);
		    	alert.setTitle("Confirmation de suppression");
		    	alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                	lstCategorie.remove(tvListeCategorie.getSelectionModel().getSelectedItem());
		    	}
    }

    @FXML 
    void initialize() {
        lstCategorie.addAll(modele.CategorieSpectateur.getListDeBase());

        tvListeCategorie.setItems(lstCategorie);

        BooleanBinding rien = Bindings.equal(tvListeCategorie.getSelectionModel().selectedIndexProperty(), -1);
		btnModifieCategorie.disableProperty().bind(rien);
		btnSupprimerCategorie.disableProperty().bind(rien);
		
		tvListeCategorie.setContextMenu(menu);
		optionAjouter.setOnAction(event -> {
	        Main.afficherCreationCategorie(null);
	    });
	    optionModifier.setOnAction(event -> {
	        Main.afficherCreationCategorie(tvListeCategorie.getSelectionModel().getSelectedItem());
	    });
	    optionSupprimer.setOnAction(event -> {
	    	Alert alert = new Alert(
		    		AlertType.CONFIRMATION,
		    		"Voulez-vous vraiment supprimer cette catégorie ?",
		    		ButtonType.YES,
		    		ButtonType.NO
		    	);
		    	alert.setTitle("Confirmation de suppression");
		    	alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                	lstCategorie.remove(tvListeCategorie.getSelectionModel().getSelectedItem());
		    	}
	    });
    }
}
