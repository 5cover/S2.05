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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.CategorieSpectateur;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class ListeCategories {

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

        TableColumn<CategorieSpectateur,Integer> colonne1 = new TableColumn<CategorieSpectateur,Integer>("Nom");
		colonne1.setCellValueFactory(new PropertyValueFactory<CategorieSpectateur,Integer>("nom"));	
		tvListeCategorie.getColumns().set(0, colonne1);
		TableColumn<CategorieSpectateur, String> colonne2 = new TableColumn<CategorieSpectateur,String>("Description");
		colonne2.setCellValueFactory(new PropertyValueFactory<CategorieSpectateur, String>("description"));
		tvListeCategorie.getColumns().set(1, colonne2);
		TableColumn<CategorieSpectateur, String> colonne3 = new TableColumn<CategorieSpectateur,String>("Taux");
		colonne3.setCellValueFactory(new PropertyValueFactory<CategorieSpectateur, String>("taux"));
		tvListeCategorie.getColumns().set(2, colonne3);

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
