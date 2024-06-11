package vue;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenAccueil extends Stage {
	private controleur.Accueil ctrl;

	public FenAccueil() throws IOException {
		this.setTitle("Gestion Le Patio");
		this.setResizable(false);
		Scene scene = new Scene(creerSceneGraph());
		this.setScene(scene);
	}

	
	public controleur.Accueil ctrl() {
		return ctrl;
	}

	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("accueil.fxml"));
		Pane root = loader.load();
		ctrl = loader.getController();
		return root;
	}
}
