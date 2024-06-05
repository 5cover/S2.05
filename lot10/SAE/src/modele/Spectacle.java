package modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Spectacle {
	private String nom;
	private int duree;
	private int nbreMaxSpect;
	private String genre;
	private ArrayList<Artiste> listeArtiste;
	private ArrayList<HashMap<Zone, Float>>  tarifs;
	
	public Spectacle(String n, int d, int nb, String g, Artiste art) {
		nom = n;
		duree =d;
		nbreMaxSpect = nb;
		genre = g;
		
		listeArtiste = new ArrayList<Artiste>();
		listeArtiste.add(art);
		
		tarifs = new ArrayList<HashMap<Zone, Float>>();
		
	}
}
