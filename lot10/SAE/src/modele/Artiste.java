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

	public void ajouterSpectacle(Spectacle s) throws IllegalArgumentException{
		if (!listeSpectacle.contains(s) && s!=null) {
			addSpectacle(s);
			s.addArtiste(this);
		}else{
			throw new IllegalArgumentException();
		}
	}

	public void retirerSpectacle(Spectacle s) throws IllegalArgumentException{
		if (listeSpectacle.contains(s) && s!=null) {
			removeSpectacle(s);
			s.removeArtiste(this);
		}else{
			throw new IllegalArgumentException();
		}
	}

	public void addSpectacle(Spectacle s){
		listeSpectacle.add(s);
	}

	public void removeSpectacle(Spectacle s){
		listeSpectacle.remove(s);
	}
}
