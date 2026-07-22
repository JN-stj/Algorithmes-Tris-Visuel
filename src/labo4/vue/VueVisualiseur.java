package labo4.vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class VueVisualiseur extends Canvas {

    private static final Color COULEUR_BARRE  = Color.web("#7a7a8a");
    private static final Color COULEUR_ACTIVE = Color.web("#7c4dff");
    private static final Color COULEUR_FOND   = Color.web("#1e1e2e");
    private static final Color COULEUR_ETIQ   = Color.web("#cdd6f4");

    private List<Integer> elements      = List.of();
    private Set<Integer>  indicesActifs = Set.of();

    public VueVisualiseur() {

        super(660, 380);
    }

    public VueVisualiseur(double largeur, double hauteur) {

        super(largeur, hauteur);
    }

    public void mettreAJour(List<Integer> elements, int[] indicesActifs) {

        this.elements      = elements;
        this.indicesActifs = Arrays.stream(indicesActifs).boxed().collect(Collectors.toSet());
        dessiner();
    }

    public void afficherInitial(List<Integer> elements) {

        mettreAJour(elements, new int[]{});
    }

    private void dessiner() {

        GraphicsContext gc = getGraphicsContext2D();
        double l = getWidth();
        double h = getHeight();

        gc.setFill(COULEUR_FOND);
        gc.fillRect(0, 0, l, h);

        if (elements.isEmpty())
            return;

        int    valeurMax    = elements.stream().mapToInt(Integer::intValue).max().orElse(1);
        double marge        = 40;
        double hauteurEtiq  = 24;
        double hauteurDispo = h - marge - hauteurEtiq;
        double largeurBarre = (l - marge) / elements.size() - 4;

        for (int i = 0; i < elements.size(); i++) {

            double hauteurBarre = (elements.get(i) / (double) valeurMax) * hauteurDispo;
            double x = marge / 2 + i * ((l - marge) / elements.size());
            double y = marge + (hauteurDispo - hauteurBarre);

            gc.setFill(indicesActifs.contains(i) ? COULEUR_ACTIVE : COULEUR_BARRE);
            gc.fillRoundRect(x, y, largeurBarre, hauteurBarre, 4, 4);

            gc.setFill(COULEUR_ETIQ);
            gc.fillText(String.valueOf(elements.get(i)), x + largeurBarre / 4, h - 6);
        }
    }
}