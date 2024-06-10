package controleur;

import javafx.application.Application;
import javafx.stage.Stage;

public final class Main extends Application {
    public void start(Stage stage) {
        System.out.println("Hello world!");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void quitter() {
    	System.exit(0);
    }

}
