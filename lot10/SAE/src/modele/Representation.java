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
