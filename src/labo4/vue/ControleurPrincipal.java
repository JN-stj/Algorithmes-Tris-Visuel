package labo4.vue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import labo4.controleur.ControleurSimulation;
import labo4.sort.AlgorithmeTrieur;

import java.util.List;


public class ControleurPrincipal {

    @FXML private VueVisualiseur vueVisualiseur;
    @FXML private Button         boutonParametres;
    @FXML private Button         boutonDemarrer;
    @FXML private Button         boutonArreter;

    private ControleurSimulation controleurSimulation;

    public void initialiser(Stage fenetre, List<AlgorithmeTrieur> algorithmes) {

        controleurSimulation = new ControleurSimulation(
                fenetre, vueVisualiseur, algorithmes,
                boutonParametres, boutonDemarrer, boutonArreter
        );
    }

    @FXML public void surParametres() {

        controleurSimulation.ouvrirParametres();
    }
    @FXML public void surDemarrer()   {

        controleurSimulation.demarrerSimulation();
    }
    @FXML public void surArreter()    {

        controleurSimulation.arreterSimulation();
    }
}