package labo4.vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import labo4.sort.AlgorithmeTrieur;

import java.io.IOException;
import java.util.List;


public class FenetrePrincipale extends Stage {

    public FenetrePrincipale(List<AlgorithmeTrieur> algorithmes) throws IOException {

        FXMLLoader chargeur = new FXMLLoader(
                getClass().getResource("/labo4/vue-principale.fxml")
        );
        BorderPane racine = chargeur.load();

        ControleurPrincipal controleur = chargeur.getController();
        controleur.initialiser(this, algorithmes);

        setTitle("Laboratoire 4 (LOG121)");
        setMinWidth(700);
        setMinHeight(480);
        setScene(new Scene(racine, 700, 480));
        setOnShown(e -> controleur.surParametres());
    }
}