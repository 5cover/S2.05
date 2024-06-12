package modele;

import java.util.Collections;
import java.util.List;

/**
 * Une catégorie de spectateurs.
 */
public final record CategorieSpectateur( 
    String nom,
    String description,
    double reduction
) {
	// Modification par raport à la proposition de correction du diagramme de classe
	// Au lieu d'une hiérarchie de Tarification, on utilise des variables de classes pour représenter les catégories de base
	/**
	 * Liste non modifiable des catégories de base.
	 */
	public static final List<CategorieSpectateur> CATEGORIES_DE_BASE = Collections.unmodifiableList(List.of(
		new CategorieSpectateur("Jeune", "Personne de moins de 25 ans", .3),
		new CategorieSpectateur("Sénior", "Perosnne de plus de 65 ans", .25),
		new CategorieSpectateur("Abonné", "Personne qui assiste à au moins 3 spectacles par an", .3),
		new CategorieSpectateur("Groupe", "Personne membre d'un groupe d'au moins 20 adultes", .15),
		new CategorieSpectateur("Adulte", "Personne n'appartenant à aucune autre catégorie", 0)));
	
	public static List<CategorieSpectateur> getListDeBase() {
		return CATEGORIES_DE_BASE;
	}
	
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof CategorieSpectateur) {
			CategorieSpectateur otherObj = (CategorieSpectateur)obj;
			res = this.getNom() == otherObj.getNom();
		}
		return res;
	}
	
	public String getNom() {
		return nom;
	}
}
