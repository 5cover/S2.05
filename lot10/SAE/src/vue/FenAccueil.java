package vue;

import java.io.IOException;

import controleur.CtrlAccueil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenAccueil extends Stage {
    private CtrlAccueil ctrl;

    public FenAccueil() throws IOException {
        this.setTitle("Gestion Le Patio");
        this.setResizable(false);
        Scene scene = new Scene(creerSceneGraph());
        this.setScene(scene);
    }

    private Pane creerSceneGraph() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("accueil.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
        return root;
    }

    public CtrlAccueil ctrl() {
        return ctrl;
    }
}
