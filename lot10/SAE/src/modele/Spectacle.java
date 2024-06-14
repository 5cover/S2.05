package modele;

import java.util.ArrayList;
import java.util.HashMap;

public final class Spectacle {
	private String nom;
	private int duree;
	private int capacite;
	private String genre;
	private ArrayList<Artiste> listeArtiste;
	private HashMap<Zone, Float>  tarifs; // Hashmap qui lie pour une ou plusieures Zones un tarif pour cette instance
	private CategorieSpectacle categorie;
	private ArrayList<Representation> listeRepresentations;

	public Spectacle(String n, int d, int nb, String g, CategorieSpectacle cat) {
		nom = n;
		duree =d;
		capacite = nb;
		genre = g;
		categorie = cat;

		listeArtiste = new ArrayList<Artiste>();
		
		tarifs = new HashMap<Zone, Float>();

		listeRepresentations = new ArrayList<Representation>();

	}

	public void afficher(){
		System.out.println("Nom spectacle : " + nom);
		System.out.println("Durée : " + duree);
		System.out.println("Nombre maximum de spectateurs : " + capacite);
		System.out.println("Genre du spectacle : " + genre);
		System.out.println("Catégorie de spectacle : " + categorie);
	}

	public String toString() {
		return nom;
	}

	public void listerArtistes(){
		for (Artiste art : listeArtiste) {
			art.afficher();
		}
	}

	public void listerTarifs() throws IllegalStateException{
		if (!tarifs.isEmpty()) {
			for (Zone z : tarifs.keySet()) {
				System.out.println(z);
				System.out.println(tarifs.get(z) + "\n");
			}
		}else{
			throw new IllegalStateException("Hashmap est vide");
		}
	}

	// Artiste
	public void ajouterArtiste(Artiste a) throws IllegalArgumentException{
		if (a!=null && !listeArtiste.contains(a)) {
			addArtiste(a);
			a.addSpectacle(this);
		}else{
			if (a==null) {
				throw new IllegalArgumentException("Artiste en entrée est null");
			}else{
				throw new IllegalArgumentException("Artiste déja dans la liste");
			}
		}
	}

	public void retirerArtiste(Artiste a) throws IllegalArgumentException{
		if (a!=null && listeArtiste.contains(a)) {
			removeArtiste(a);
			a.removeSpectacle(this);
		}else{
			if (a==null) {
				throw new IllegalArgumentException("Artiste en entrée est null");
			}else{
				throw new IllegalArgumentException("Artiste pas dans la liste");
			}
		}
	}

	public void addArtiste(Artiste a){
		listeArtiste.add(a);
	}
	public void removeArtiste(Artiste a){
		listeArtiste.remove(a);
	}

	// Representations
	public void ajouterRepresentation(Representation r) throws IllegalArgumentException{
		if (r!=null && !listeRepresentations.contains(r)) {
			addRepresentation(r);
			r.addRepresente(this);
		}else{
			if (r==null) {
				throw new IllegalArgumentException("Représentation en entrée est null");
			}else{
				throw new IllegalArgumentException("Représentation déja dans la liste");
			}
		}
	}

	public void retirerRepresentation(Representation r) throws IllegalArgumentException{
		if (r!=null && listeRepresentations.contains(r)) {
			removeRepresentation(r);
			r.removeRepresente(this);
		}else{
			if (r==null) {
				throw new IllegalArgumentException("Représentation en entrée est null");
			}else{
				throw new IllegalArgumentException("Représentation n'est pas dans la liste");
			}
		}
	}

	public void addRepresentation(Representation r){
		listeRepresentations.add(r);
	}

	public void removeRepresentation(Representation r){
		listeRepresentations.remove(r);
	}

	// Tarifs
	public void ajouterTarif(Zone z, Float f)throws IllegalArgumentException{
		if ((!tarifs.containsKey(z))&&(z != null)) {
			putTarif(z, f);
			z.putTarif(this, f);
		}else{
			if (z==null) {
				throw new IllegalArgumentException("Zioe en entrée est null");
			}else{
				throw new IllegalArgumentException("Zone est déja dans le HashMap");
			}
		}
	}

	public void retirerTarif(Zone z) throws IllegalArgumentException{
		if ((tarifs.containsKey(z))&&(z != null)) {
			removeTarif(z);
			z.removeTarif(this);
		}else{
			if (z==null) {
				throw new IllegalArgumentException("Zioe en entrée est null");
			}else{
				throw new IllegalArgumentException("Zone n'est pas dans le HashMap");
			}
		}
	}

	// pour utilisation externe (liaison bi-directionelle)
	public void putTarif(Zone z, Float f){
		tarifs.put(z, f);
	}
	
	public void removeTarif(Zone z){
		tarifs.remove(z);
	}

	// Consulter hashmap

	public float tarifZone(Zone z){
		return tarifs.get(z);
	}

	/////Getters and setters

	public CategorieSpectacle getCategorie() {
		return categorie;
	}
	public int getDuree() {
		return duree;
	}
	public String getGenre() {
		return genre;
	}
	public ArrayList<Artiste> getListeArtiste() {
		return listeArtiste;
	}
	public int getCapacite() {
		return capacite;
	}
	public String getNom() {
		return nom;
	}
	public HashMap<Zone, Float> getTarifs() {
		return tarifs;
	}
	public void setTarifs(HashMap<Zone, Float> tarifs) {
		this.tarifs = tarifs;
	}
	public void setCategorie(CategorieSpectacle categorie) {
		this.categorie = categorie;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setListeArtiste(ArrayList<Artiste> listeArtiste) {
		this.listeArtiste = listeArtiste;
	}
	public void setCapacite(int nbreMaxSpect) {
		this.capacite = nbreMaxSpect;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
