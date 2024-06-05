package modele;

import java.util.ArrayList;

public class Artiste {
	private String nom;
	
	private ArrayList<Spectacle> listeSpectacle;
	
	public Artiste(String n, Spectacle s) {
		nom = n;
		
		listeSpectacle = new ArrayList<Spectacle>();
		listeSpectacle.add(s);
	}
}
