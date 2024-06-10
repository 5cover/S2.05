package controleur;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.CategorieSpectateur;
import vue.FenCreationCategorie;

public final class Main extends Application {
	private static FenCreationCategorie fCreationCategorie;
	
	
    public void start(Stage stage) throws IOException {
    	fCreationCategorie = new FenCreationCategorie();
    	fCreationCategorie.initModality(Modality.APPLICATION_MODAL);
    	
    	// test
    	System.out.println(afficherCreationCategorie(new CategorieSpectateur("Mafieux", "Les \"amis\" de Mr. Malraux", .99)));
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    	
    public static void quitter() {
    	System.exit(0);
    }
    
    /**
     * Créer une nouvelle catégorie avec la fenêtre modale de création de catégorie.
     * @param la catégorie à modifier, ou null pour créer une nouvelle catégorie
     * @return Une nouvelle instance de la classe {@link modele.CategorieSpectateur}, ou la catégorie actuelle si l'utilisateur a annulé la création/modifcation.
     */
    public static CategorieSpectateur afficherCreationCategorie(CategorieSpectateur actuel) {
    	if (actuel != null) {
    		fCreationCategorie.afficher(actuel);    		
    	}
    	fCreationCategorie.showAndWait();
		return fCreationCategorie.ctrl().actuel();
    }
    
    public static void fermerCreationCategorie() {
    	fCreationCategorie.close();
    }

}
