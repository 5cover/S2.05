package modele;

import java.util.HashMap;
import java.util.ArrayList;

public final class Zone {
	private String nom;
	
	private ArrayList<HashMap<Spectacle, Float>>  tarifs;
	
	public Zone(String n) {
		nom = n;
		
		tarifs = new ArrayList<HashMap<Spectacle, Float>>();
	}
	
	
}
