/**
 * Application de gestion de la salle de spectacle Le Patio.
 * @author Mattéo Kervadec, Marius Chartier--Le Goff, Paolo Toé, Raphaël Bardini
 * @version 0.0.1-dev 
 */
module lePatio {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    opens controleur to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    //opens modele to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    //opens vue to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
}