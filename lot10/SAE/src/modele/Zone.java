package modele;

import java.util.HashMap;

public final class Zone {
	private String nom;
	
	private HashMap<Spectacle, Float>  tarifs;
	
	public Zone(String n) {
		nom = n;
		
		tarifs = new HashMap<Spectacle, Float>();
	}

	public void ajouterTarif(Spectacle s, Float f)throws IllegalArgumentException{
		if (!tarifs.containsKey(s)&&(s != null)) {
			putTarif(s, f);
			s.putTarif(this, f);
		}else{
			throw new IllegalArgumentException();
		}
	}


	// Tarifs
	public void retirerTarif(Spectacle s) throws IllegalArgumentException{
		if (tarifs.containsKey(s)&&(s != null)) {
			removeTarif(s);
			s.removeTarif(this);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	// pour utilisation externe (liaison bi-directionelle)
	public void putTarif(Spectacle s, Float f){
		tarifs.put(s, f);
	}
	
	public void removeTarif(Spectacle s){
		tarifs.remove(s);
	}



	public String toString() {
		return nom;
	}

	// Getterss et setters
	public String getNom() {
		return nom;
	}
	public HashMap<Spectacle, Float> getTarifs() {
		return tarifs;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setTarifs(HashMap<Spectacle, Float> tarifs) {
		this.tarifs = tarifs;
	}
}
