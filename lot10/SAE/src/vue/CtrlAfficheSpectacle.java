package vue;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Spectacle;

public class CtrlAfficheSpectacle {
	
    @FXML
    private TextField 			txt_numSpectateur;
    @FXML
    private TextField 			num_prixOrchestre;
    @FXML
    private TextField 			num_prixLogesDroites;
    @FXML
    private TextField 			txt_duree;
    @FXML
    private TextField 			num_prixLogesGauches;
    @FXML
    private TextField 			num_prixBalcon;
    @FXML
    private TextField 			txt_nomSpectacle;
    @FXML
    private ComboBox<String> 	txt_genreSpectacle;
    @FXML
    private ComboBox<String> 	txt_categorieSpectacle;
    
    
    @FXML
    private TableColumn<Spectacle,Integer> txt_colonneDuree;
    @FXML
    private TableColumn<Spectacle,Integer> txt_colonneCapacite;
    @FXML
    private TableColumn<Spectacle,String> txt_colonneGenre;
    @FXML
    private TableColumn<Spectacle,String> txt_colonneCategorie;
    @FXML
    private TableColumn<Spectacle,String> txt_colonneNom;
    
    
    public Spectacle spectSelected;
    
//    Person person = taview.getSelectionModel().getSelectedItem();
    public void actualiser() {
    	spectSelected = tvListeEmployes.getSelectionModel().getSelectedItem();
    	txt_numSpectateur.setText( 			spectSelected.getNbSpect());
    	num_prixOrchestre.setText( 			spectSelected.getpPrixO());
        num_prixLogesDroites.setText( 		spectSelected.getPrixD());
        txt_duree.setText( 					spectSelected.getDuree());
        num_prixLogesGauches.setText( 		spectSelected.getPrixG());
        num_prixBalcon.setText( 			spectSelected.getPrixB());
        txt_nomSpectacle.setText( 			spectSelected.getNom());
        txt_genreSpectacle.setText( 		spectSelected.getGenre());
        txt_categorieSpectacle.setText( 	spectSelected.getCategorie());
    	
    	
    }
    
    @FXML void initialize() {
    	TableColumn<Spectacle,String> colonne1 = new TableColumn<Spectacle,String>("Nom");
		colonne1.setCellValueFactory(new PropertyValueFactory<Spectacle,String>("nom"));	
		tvListeEmployes.getColumns().set(0, colonne1);
		
		TableColumn<Spectacle, String> colonne2 = new TableColumn<Spectacle,String>("Categorie");
		colonne2.setCellValueFactory(new PropertyValueFactory<Spectacle, String>("categorie"));
		tvListeEmployes.getColumns().set(1, colonne2);
		TableColumn<Spectacle, Integer> colonne3 = new TableColumn<Spectacle,Integer>("Capacite");
		colonne3.setCellValueFactory(new PropertyValueFactory<Spectacle, Integer>("capacite"));
		tvListeEmployes.getColumns().set(2, colonne3);
		TableColumn<Spectacle,Integer> colonne4 = new TableColumn<Spectacle,Integer>("Duree");
		colonne4.setCellValueFactory(new PropertyValueFactory<Spectacle, Integer>("duree"));
		tvListeEmployes.getColumns().set(3, colonne4);
		TableColumn<Spectacle,String> colonne5 = new TableColumn<Spectacle,String>("Genre");
		colonne5.setCellValueFactory(new PropertyValueFactory<Spectacle, String>("genre"));
		tvListeEmployes.getColumns().set(4, colonne5);

		tvListeEmployes.setItems(Donnees.getLesEmployes());
		tvListeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		//griser les boutons Modifier et Supprimer quand aucune s�lection



				
		
    }
    
    
}
