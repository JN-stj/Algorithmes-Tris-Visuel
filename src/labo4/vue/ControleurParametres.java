package labo4.vue;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import labo4.model.ParametresTri;
import labo4.model.VitesseSimulation;
import labo4.sort.AlgorithmeTrieur;
import labo4.util.AnalyseurNombres;

import java.util.List;
import java.util.function.Consumer;


public class ControleurParametres {

    @FXML private ComboBox<AlgorithmeTrieur> comboAlgorithme;
    @FXML private TextField champNombres;
    @FXML private ComboBox<VitesseSimulation> comboVitesse;

    private Consumer<ParametresTri> surAppliquer;
    private final AnalyseurNombres  analyseur = new AnalyseurNombres();

    @FXML
    public void initialize() {

        comboVitesse.getItems().addAll(VitesseSimulation.values());
        comboVitesse.getSelectionModel().select(VitesseSimulation.RAPIDE);
    }

    public void setAlgorithmes(List<AlgorithmeTrieur> algorithmes) {

        comboAlgorithme.getItems().addAll(algorithmes);
        comboAlgorithme.getSelectionModel().selectFirst();
    }

    public void setSurAppliquer(Consumer<ParametresTri> callback) {

        this.surAppliquer = callback;
    }

    @FXML private void surOk(){

        appliquer();
        fermer();
    }
    @FXML private void surAnnuler(){

        fermer();
    }
    @FXML private void surAppliquer() {

        appliquer();
    }

    private void appliquer() {

        try {

            List<Integer> nombres = analyseur.analyser(champNombres.getText());

            if (surAppliquer != null) {

                surAppliquer.accept(new ParametresTri(
                        comboAlgorithme.getValue(),
                        nombres,
                        comboVitesse.getValue()
                ));
            }
        }
        catch (IllegalArgumentException ex) {

            new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    private void fermer() {

        ((Stage) comboAlgorithme.getScene().getWindow()).close();
    }
}