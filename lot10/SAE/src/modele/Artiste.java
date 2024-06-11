package modele;

import java.util.ArrayList;

public final class Artiste {
	private String nom;
	
	private ArrayList<Spectacle> listeSpectacle;
	
	public Artiste(String n) {
		nom = n;
		
		listeSpectacle = new ArrayList<Spectacle>();
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
			if (s==null) {
				throw new IllegalArgumentException("Spectacle en entrée est null");
			}else{
				throw new IllegalArgumentException("Spectacle est déja dans la liste");
			}
		}
	}

	public void retirerSpectacle(Spectacle s) throws IllegalArgumentException{
		if (listeSpectacle.contains(s) && s!=null) {
			removeSpectacle(s);
			s.removeArtiste(this);
		}else{
			if (s==null) {
				throw new IllegalArgumentException("Spectacle en entrée est null");
			}else{
				throw new IllegalArgumentException("Spectacle n'est pas dans la liste");
			}
		}
	}

	public void addSpectacle(Spectacle s){
		listeSpectacle.add(s);
	}

	public void removeSpectacle(Spectacle s){
		listeSpectacle.remove(s);
	}
}
