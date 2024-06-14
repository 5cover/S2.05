package controleur;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Donnees;
import modele.Spectacle;

public class CtrlListeSpectacles {

    @FXML
    private static  TextField txt_numSpectateur = new TextField() ;
    @FXML
    private static TextField num_prixOrchestre = new TextField();
    @FXML
    private static TextField num_prixLogesDroites = new TextField();
    @FXML
    private static TextField txt_duree = new TextField();
    @FXML
    private static TextField num_prixLogesGauches = new TextField();
    @FXML
    private static TextField num_prixBalcon = new TextField();
    @FXML
    private static TextField txt_nomSpectacle = new TextField();
    @FXML
    private static TextField txt_genreSpectacle = new TextField();
    @FXML
    private static TextField txt_categorieSpectacle = new TextField();
    @FXML
    private static TableView<Spectacle> tvListeSpectacle = new TableView<Spectacle>();

    @FXML
    private static TableColumn<Spectacle, Number> txt_colonneDuree/* = new TableColumn<Spectacle, Integer>()*/;
    @FXML
    private static TableColumn<Spectacle, Number> txt_colonneCapacite/* = new TableColumn<Spectacle, Integer>()*/;
    @FXML
    private static TableColumn<Spectacle, String> txt_colonneGenre/* = new TableColumn<Spectacle, String>()*/;
    @FXML
    private static TableColumn<Spectacle, String> txt_colonneCategorie/* = new TableColumn<Spectacle, String>()*/;
    @FXML
    private static TableColumn<Spectacle, String> txt_colonneNom/* = new TableColumn<Spectacle, String>()*/;

    public static Spectacle spectSelected;

//    Person person = taview.getSelectionModel().getSelectedItem();
    public static void actualiser() {
        spectSelected = tvListeSpectacle.getSelectionModel().getSelectedItem();
        if (spectSelected == null) {
            return;
        }
        txt_numSpectateur.setText(Integer.toString(spectSelected.getCapacite()));
        num_prixOrchestre.setText(Float.toString(spectSelected.tarifZone(Donnees.getTarifsZoneDroite())));
        num_prixLogesDroites.setText(Float.toString(spectSelected.tarifZone(Donnees.getTarifsZoneOcherstre())));
        txt_duree.setText(Integer.toString(spectSelected.getDuree()));
        num_prixLogesGauches.setText(Float.toString(spectSelected.tarifZone(Donnees.getTarifsZoneGauche())));
        num_prixBalcon.setText(Float.toString(spectSelected.tarifZone(Donnees.getTarifsZoneBalcon())));
        txt_nomSpectacle.setText(spectSelected.getNom());
        txt_genreSpectacle.setText(spectSelected.getGenre());
        txt_categorieSpectacle.setText(spectSelected.getCategorie().toString());

    }

    void initialize() {
//        TableColumn<Spectacle, String> colonne1 = new TableColumn<>("Nom");
//        colonne1.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        tvListeSpectacle.getColumns().set(0, colonne1);
        
        txt_colonneNom.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNom()));
        txt_colonneCategorie.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getCategorie().toString()));
        txt_colonneGenre.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getGenre()));
        txt_colonneCapacite.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getCapacite()));
        txt_colonneDuree.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getDuree()));
        
//        TableColumn<Spectacle, String> colonne2 = new TableColumn<>("Categorie");
//        colonne2.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        tvListeSpectacle.getColumns().set(1, colonne2);
//        TableColumn<Spectacle, Integer> colonne3 = new TableColumn<>("Capacite");
//        colonne3.setCellValueFactory(new PropertyValueFactory<>("capacite"));
//        tvListeSpectacle.getColumns().set(2, colonne3);
//        TableColumn<Spectacle, Integer> colonne4 = new TableColumn<>("Duree");
//        colonne4.setCellValueFactory(new PropertyValueFactory<>("duree"));
//        tvListeSpectacle.getColumns().set(3, colonne4);
//        TableColumn<Spectacle, String> colonne5 = new TableColumn<>("Genre");
//        colonne5.setCellValueFactory(new PropertyValueFactory<>("genre"));
//        tvListeSpectacle.getColumns().set(4, colonne5);

        tvListeSpectacle.setItems(Donnees.getLesSpectacle());
        tvListeSpectacle.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

}
