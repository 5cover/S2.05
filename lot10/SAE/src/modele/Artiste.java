package modele;

import java.util.ArrayList;

public final class Artiste {
	private String nom;
	
	private ArrayList<Spectacle> listeSpectacle;
	
	public Artiste(String n, Spectacle s) {
		nom = n;
		
		listeSpectacle = new ArrayList<Spectacle>();
		
		listeSpectacle.add(s);
	}

	public void afficher(){
		System.out.println("Nom Artiste : " + nom);
	}

	public String toString() {
		return nom;
	}
}
