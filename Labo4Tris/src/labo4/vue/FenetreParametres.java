package labo4.vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import labo4.model.ParametresTri;
import labo4.sort.AlgorithmeTrieur;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;


public class FenetreParametres extends Stage {

    public FenetreParametres(Stage proprietaire,
                             List<AlgorithmeTrieur> algorithmes,
                             Consumer<ParametresTri> surAppliquer) throws IOException {

        FXMLLoader chargeur = new FXMLLoader(getClass().getResource("/labo4/vue-parametres.fxml"));
        VBox racine = chargeur.load();

        ControleurParametres controleur = chargeur.getController();
        controleur.setAlgorithmes(algorithmes);
        controleur.setSurAppliquer(surAppliquer);

        initOwner(proprietaire);
        initModality(Modality.APPLICATION_MODAL);

        setTitle("Paramètres de tri");
        setResizable(false);
        setScene(new Scene(racine));
    }
}