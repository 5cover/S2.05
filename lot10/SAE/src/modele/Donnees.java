package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnees {
	static private ObservableList<Zone> 						lesZones 	 = FXCollections.observableArrayList();
	static private ObservableList<CategorieSpectacle> 		lescategorieSpectacle = FXCollections.observableArrayList();
	static private ObservableList<CategorieSpectateur> 		lesCategorieSpectateur 	 = FXCollections.observableArrayList();
	static private ObservableList<Artiste> 					lesArtiste 	 = FXCollections.observableArrayList();
	private static ObservableList<Spectacle> 				lesSpectacle = FXCollections.observableArrayList();
	static private ObservableList<Representation> 			lesRepresentattion = FXCollections.observableArrayList();

	
	static { 
		
		
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
		lesSpectacle.add(new Spectacle("e", 120, 2_000, "chant grégorien",CategorieSpectacle.B ));
		lesSpectacle.add(new Spectacle("Les empereurs du néant", 666, 666, "Metal gothique",CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Les petits poisons dans l'eau", 20, 10000, "jazz",CategorieSpectacle.C ));
		lesSpectacle.add(new Spectacle("Les petits cailloux", 3, 8_000_000, "révélation",CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Moi lolita", 140, 20_400, "rap",CategorieSpectacle.A ));
		lesSpectacle.add(new Spectacle("Roots", 3000, 50_000_000, "Groove Metal ",CategorieSpectacle.A ));
		
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
/////Getters and setters
	public static ObservableList<Zone> getLesZones() {
		return lesZones;
	}
	public static ObservableList<CategorieSpectacle> getLescategorieSpectacle() {
		return lescategorieSpectacle;
	}
	public static ObservableList<CategorieSpectateur> getLesCategorieSpectateur() {
		return lesCategorieSpectateur;
	}
	public static ObservableList<Artiste> getLesArtiste() {
		return lesArtiste;
	}
	public static ObservableList<Spectacle> getLesSpectacle() {
		return lesSpectacle;
	}
	public static ObservableList<Representation> getLesRepresentattion() {
		return lesRepresentattion;
	}
	
	
	
	
	public static Zone getTarifsZoneBalcon() {
		return lesZones.get(0);
	}
	public static Zone getTarifsZoneOcherstre() {
		return lesZones.get(1);
	}
	public static Zone getTarifsZoneDroite() {
		return lesZones.get(2);
	}
	public static Zone getTarifsZoneGauche() {
		return lesZones.get(3);
	}
	
	
	

}
