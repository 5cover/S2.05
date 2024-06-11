package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnees {
	static private ObservableList<Zone> 					lesZones 	 = FXCollections.observableArrayList();
	static private ObservableList<CategorieSpectacle> 		lescategorieSpectacle = FXCollections.observableArrayList();
	static private ObservableList<CategorieSpectateur> 		lesCategorieSpectateur 	 = FXCollections.observableArrayList();
	static private ObservableList<Artiste> 					lesArtiste 	 = FXCollections.observableArrayList();
	static private ObservableList<Spectacle> 				lesSpectacle = FXCollections.observableArrayList();
	static private ObservableList<Representation> 			lesRepresentattion = FXCollections.observableArrayList();

	
	static public void chargementDonnees() { 
		
		
//		lesZones =================================================================================================================
		lesZones.add(new Zone("balcon"));
		lesZones.add(new Zone("orchestre"));
		lesZones.add(new Zone("droite"));
		lesZones.add(new Zone("gauche"));
		
//		lescategorieSpectacle ====================================================================================================
		lescategorieSpectacle.add(CategorieSpectacle.A);
		lescategorieSpectacle.add(CategorieSpectacle.B);
		lescategorieSpectacle.add(CategorieSpectacle.C);
		
//		lesCategorieSpectateur ===================================================================================================
		lesCategorieSpectateur.add(new CategorieSpectateur("Jeune", "Personne de moins de 25 ans", .3));
		lesCategorieSpectateur.add(new CategorieSpectateur("Sénior", "Perosnne de plus de 65 ans", .25));
		lesCategorieSpectateur.add(new CategorieSpectateur("Abonné", "Personne qui assiste à au moins 3 spectacles par an", .3));
		lesCategorieSpectateur.add(new CategorieSpectateur("Groupe", "Personne membre d'un groupe d'au moins 20 adultes", .15));
		lesCategorieSpectateur.add(new CategorieSpectateur("Adulte", "Personne n'appartenant à aucune autre catégorie", 0));
		
//		lesArtiste ===============================================================================================================
		lesArtiste.add(new Artiste("repar-auto"));
		lesArtiste.add(new Artiste("vito"));
		lesArtiste.add(new Artiste("scover"));
		lesArtiste.add(new Artiste("The great zetor's son Icelos"));
		lesArtiste.add(new Artiste("Sepultura"));
		lesArtiste.add(new Artiste("Roland Cristal"));
		
//		lesSpectacle =============================================================================================================
		lesSpectacle.add(new Spectacle("e", 120, 2_000, "chant grégorien", lesArtiste.get(0),CategorieSpectacle.B ));
		lesSpectacle.add(new Spectacle("Les empereurs du néant", 666, 666, "Metal gothique", lesArtiste.get(3),CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Les petits poisons dans l'eau", 20, 10000, "jazz", lesArtiste.get(2),CategorieSpectacle.C ));
		lesSpectacle.add(new Spectacle("Les petits cailloux", 3, 8_000_000, "révélation", lesArtiste.get(5),CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Moi lolita", 140, 20_400, "rap", lesArtiste.get(1),CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Roots", 3000, 50_000_000, "Groove Metal ", lesArtiste.get(4),CategorieSpectacle.A ));
		
//		lesRepresentattion =======================================================================================================
		lesRepresentattion.add(new Representation("16/06/2024", "08:00",lesSpectacle.get(0)));
		lesRepresentattion.add(new Representation("23/06/2024", "08:00",lesSpectacle.get(0)));
		lesRepresentattion.add(new Representation("30/06/2024", "08:00",lesSpectacle.get(0)));
		lesRepresentattion.add(new Representation("14/07/2024", "22:30",lesSpectacle.get(1)));
		lesRepresentattion.add(new Representation("25/06/2024", "05:00",lesSpectacle.get(2)));
		lesRepresentattion.add(new Representation("01/01/2026", "00:01",lesSpectacle.get(3)));
		lesRepresentattion.add(new Representation("12/06/2024", "12:30",lesSpectacle.get(4)));
		lesRepresentattion.add(new Representation("27/03/2024", "15:15",lesSpectacle.get(5)));
		
		
	}
	

}
