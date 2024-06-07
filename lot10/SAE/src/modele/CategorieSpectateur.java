package modele;


public final record CategorieSpectateur( 
    String nom,
    String description,
    double reduction // todo: il faudrait utiliser un type rationnel pour éviter les erreurs d'arrondi
) {
 
}
