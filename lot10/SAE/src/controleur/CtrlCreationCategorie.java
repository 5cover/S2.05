package controleur;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modele.CategorieSpectateur;

public class CtrlCreationCategorie {
    @FXML
    private TextField tfReduction;

    @FXML
    private Button bnOk;

    @FXML
    private TextField tfNom;

    @FXML
    private Button bnAnnuler;

    @FXML
    private TextArea taDescription;

    private CategorieSpectateur actuel;
    
    private boolean modifier;
    
    public CategorieSpectateur actuel() {
    	return actuel;
    }
    
    public void initialize() {
    	bnOk.disableProperty().bind(tfNom.textProperty().isEmpty()
			.or(taDescription.textProperty().isEmpty())
			.or(Bindings.createBooleanBinding(() -> !estPourcentage(tfReduction.getText()), tfReduction.textProperty())));
    }
    
	public void afficher(CategorieSpectateur categorie) {
		actuel = categorie;
		
		if (categorie == null) {
			tfReduction.setText("");
			tfNom.setText("");
			taDescription.setText("");
			tfNom.setEditable(true);
			tfNom.setDisable(false);
			modifier = false;
		} else {			
			tfReduction.setText(String.valueOf(categorie.reduction() * 100));
			tfNom.setText(categorie.nom());
			tfNom.setEditable(false);
			tfNom.setDisable(true);
			taDescription.setText(categorie.description());
			modifier = true;
		}
	}
	
	@FXML
	private void valider() {
		actuel = new CategorieSpectateur(
				tfNom.getText(),
				taDescription.getText(),
				Double.parseDouble(tfReduction.getText()) / 100);
		System.out.println(modifier);
		Main.ajouterCategorie(actuel, modifier);
		Main.fermerCreationCategorie();
	}
	
	@FXML
	private void annuler() {
		Main.fermerCreationCategorie();
	}
	
	private boolean estPourcentage(String s) {
		try {
			double val = Double.parseDouble(s);
			return 0 <= val && val <= 100;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
