package modele;

public class Representation {
    String jour;
    String heure;
    boolean annulee;
    Spectacle represente;

    public Representation(String j, String h, Spectacle r){
        jour = j;
        heure = h;
        represente = r;
        annulee = false;
    }

    public void afficher(){
        System.out.println("Date : " + jour + " Heure : " + heure);
        represente.afficher();
        System.out.println("Annulée ? " +annulee);
    }

    // Getters and setters
    public String getHeure() {
        return heure;
    }
    public String getJour() {
        return jour;
    }
    public Spectacle getRepresente() {
        return represente;
    }
    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public void setJour(String jour) {
        this.jour = jour;
    }
    public void setRepresente(Spectacle represente) {
        this.represente = represente;
    }
}
