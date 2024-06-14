package modele;

import java.time.LocalDateTime;

public class Representation {
    LocalDateTime dateHeure;
    boolean annulee;
    Spectacle represente;

    public Representation(LocalDateTime dateHeure, Spectacle r){
        this.dateHeure = dateHeure;
        ajouterRepresente(r);
        annulee = false;
    }

    public void afficher(){
        System.out.println("Date/Heur : " + dateHeure);
        represente.afficher();
        System.out.println("Annulée ? " +annulee);
    }

    public void ajouterRepresente(Spectacle s) throws IllegalArgumentException{
        if (s!=null) {
            addRepresente(s);
            s.addRepresentation(null);
        } else{
			throw new IllegalArgumentException("Spectacle en entrée est null");
        }
        
    }
    public void retirerRepresente(Spectacle s) throws IllegalArgumentException{
        if (represente == s) {
            removeRepresente(s);
            s.removeRepresentation(this);
        }else{
		    throw new IllegalArgumentException("Spectacle en entrée est incorrect");
        }
    }

    public void removeRepresente(Spectacle s){
        represente=null;
    }
    public void addRepresente(Spectacle s){
        represente=s;
    }



    // Getters and setters
    public LocalDateTime getDateHeure() {
        return dateHeure;
    }
    public void setDateHeure(LocalDateTime valeur) {
        dateHeure = valeur;
    }
    public Spectacle getRepresente() {
        return represente;
    }
    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }
    public void setRepresente(Spectacle represente) {
        this.represente = represente;
    }
}
