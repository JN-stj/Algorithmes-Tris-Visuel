package labo4.sort;

import java.util.ArrayList;
import java.util.List;


public class MergeSort extends AlgorithmeTrieur {

    @Override
    public String getNom() {

        return "Merge Sort";
    }

    @Override
    protected void doTrier(List<Integer> elements, ObservateurEtape observateur) {

        mergeSort(elements, 0, elements.size() - 1, observateur);
    }

    private void mergeSort(List<Integer> elements, int gauche, int droite, ObservateurEtape observateur) {

        if (gauche >= droite)
            return;


        int milieu = (gauche + droite) / 2;

        mergeSort(elements, gauche, milieu, observateur);
        mergeSort(elements, milieu + 1, droite, observateur);
        merge(elements, gauche, milieu, droite, observateur);
    }

    private void merge(List<Integer> elements, int gauche, int milieu, int droite, ObservateurEtape observateur) {

        List<Integer> partieGauche = new ArrayList<>(elements.subList(gauche, milieu + 1));
        List<Integer> partieDroite = new ArrayList<>(elements.subList(milieu + 1, droite + 1));

        int i = 0, j = 0, k = gauche;

        while (i < partieGauche.size() && j < partieDroite.size()) {

            if (partieGauche.get(i) <= partieDroite.get(j)) {

                elements.set(k, partieGauche.get(i++));
            }
            else {

                elements.set(k, partieDroite.get(j++));
            }
            observateur.surEtape(new ArrayList<>(elements), new int[]{gauche + i - 1, milieu + 1 + j - 1});
            k++;
        }

        while (i < partieGauche.size()) {

            elements.set(k++, partieGauche.get(i++));
            observateur.surEtape(new ArrayList<>(elements), new int[]{gauche + i - 1});
        }

        while (j < partieDroite.size()) {

            elements.set(k++, partieDroite.get(j++));
            observateur.surEtape(new ArrayList<>(elements), new int[]{milieu + 1 + j - 1});
        }
    }
}