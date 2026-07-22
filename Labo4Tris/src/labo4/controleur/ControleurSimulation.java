package labo4.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import labo4.model.ParametresTri;
import labo4.sort.AlgorithmeTrieur;
import labo4.vue.FenetreParametres;
import labo4.vue.VueVisualiseur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleurSimulation {

    private final Stage                  fenetre;
    private final VueVisualiseur         vueVisualiseur;
    private final List<AlgorithmeTrieur> algorithmes;
    private final Button                 boutonParametres;
    private final Button                 boutonDemarrer;
    private final Button                 boutonArreter;

    private ParametresTri parametresActuels;
    private Timeline      animation;

    public ControleurSimulation(Stage fenetre,
                                VueVisualiseur vueVisualiseur,
                                List<AlgorithmeTrieur> algorithmes,
                                Button boutonParametres,
                                Button boutonDemarrer,
                                Button boutonArreter) {

        this.fenetre          = fenetre;
        this.vueVisualiseur   = vueVisualiseur;
        this.algorithmes      = algorithmes;
        this.boutonParametres = boutonParametres;
        this.boutonDemarrer   = boutonDemarrer;
        this.boutonArreter    = boutonArreter;
    }

    public void ouvrirParametres() {

        try {

            FenetreParametres dialogue = new FenetreParametres(fenetre, algorithmes, params -> {

                parametresActuels = params;
                vueVisualiseur.afficherInitial(new ArrayList<>(params.getNombres()));
                boutonDemarrer.setDisable(false);
            });
            dialogue.showAndWait();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void demarrerSimulation() {

        if (parametresActuels == null)
            return;

        List<List<Integer>> etats   = new ArrayList<>();
        List<int[]>         indices = new ArrayList<>();

        List<Integer> copie = new ArrayList<>(parametresActuels.getNombres());

        parametresActuels.getAlgorithme().trier(copie, (etat, indicesActifs) -> {

            etats.add(new ArrayList<>(etat));
            indices.add(indicesActifs);
        });

        int delaiMs = parametresActuels.getVitesse().getDelaiMs();
        final int[] etape = {0};

        animation = new Timeline(new KeyFrame(Duration.millis(delaiMs), e -> {

            if (etape[0] < etats.size()) {

                vueVisualiseur.mettreAJour(etats.get(etape[0]), indices.get(etape[0]));
                etape[0]++;
            }

            else {

                vueVisualiseur.mettreAJour(copie, new int[]{});
                setEtatBoutons(false);
                animation.stop();
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        setEtatBoutons(true);
    }

    public void arreterSimulation() {

        if (animation != null) {

            animation.stop();
        }
            setEtatBoutons(false);
    }

    private void setEtatBoutons(boolean enCours) {

        boutonDemarrer.setDisable(enCours);
        boutonArreter.setDisable(!enCours);
        boutonParametres.setDisable(enCours);
    }
}