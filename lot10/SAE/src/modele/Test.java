package modele;


public class Test{
    public static void main(String[] args) {
    	// données pour test
    	ObservableList<Zone> lesZones = Donnees.getLesZones();
    	ObservableList<CategorieSpectacle> lescategorieSpectacle = Donnees.getLescategorieSpectacle();
    	ObservableList<CategorieSpectateur> lesCategorieSpectateur = Donnees.getlesCategorieSpectateur();
    	ObservableList<Artiste> lesArtiste = Donnees.getLesArtiste();
    	ObservableList<Spectacle> lesSpectacle = Donnees.getLesSpectacle();
    	ObservableList<Representation> lesRepresentattion = Donnees.getLesRepresentattion();
    	
    	////////// Test Zones
    	System.out.println("Test Zones");
    	// ajouterTarif
    	System.out.println("ajouterTarif");
    	try {
			Zone z1 = lesZones.get(0);
			z1.ajouterTarif(null, 0.1f);
		} catch (Exception e) {
			// doit donner null erreur
			System.out.println(e);
		}
    	try {
			Zone z1 = lesZones.get(0);
			z1.ajouterTarif(lesSpectacle.get(0), 0.1f);
			z1.ajouterTarif(lesSpectacle.get(0), 0.1f);
		} catch (Exception e) {
			// doit donner erreur spectacle déja dans hashmap
			System.out.println(e);
		}
    	System.out.println();
    	
    	// retirerTarif
    	System.out.println("retirerTarif");
    	try {
			Zone z1 = lesZones.get(0);
			z1.retirerTarif(null);
		} catch (Exception e) {
			// doit donner null erreur
			System.out.println(e);
		}
    	try {
			Zone z1 = lesZones.get(0);
			z1.retirerTarif(lesSpectacle.get(0));
			z1.retirerTarif(lesSpectacle.get(0));
		} catch (Exception e) {
			// doit donner erreur pas dans hashmap
			System.out.println(e);
		}
    	System.out.println();
    }
}