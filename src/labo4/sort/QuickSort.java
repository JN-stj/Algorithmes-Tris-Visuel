package labo4.sort;

import java.util.ArrayList;
import java.util.List;


public class QuickSort extends AlgorithmeTrieur {

    @Override
    public String getNom() {

        return "Quick Sort";
    }

    @Override
    protected void doTrier(List<Integer> elements, ObservateurEtape observateur) {

        quickSort(elements, 0, elements.size() - 1, observateur);
    }

    private void quickSort(List<Integer> elements, int bas, int haut, ObservateurEtape observateur) {

        if (bas >= haut)
            return;

        int indicePivot = partitionner(elements, bas, haut, observateur);

        quickSort(elements, bas, indicePivot - 1, observateur);
        quickSort(elements, indicePivot + 1, haut, observateur);
    }

    private int partitionner(List<Integer> elements, int bas, int haut, ObservateurEtape observateur) {

        int pivot = elements.get(haut);
        int i = bas - 1;

        for (int j = bas; j < haut; j++) {

            observateur.surEtape(new ArrayList<>(elements), new int[]{j, haut});

            if (elements.get(j) <= pivot) {

                i++;
                echanger(elements, i, j);
                observateur.surEtape(new ArrayList<>(elements), new int[]{i, j});
            }
        }
        echanger(elements, i + 1, haut);
        observateur.surEtape(new ArrayList<>(elements), new int[]{i + 1});
        return i + 1;
    }

    private void echanger(List<Integer> elements, int a, int b) {

        int temp = elements.get(a);

        elements.set(a, elements.get(b));
        elements.set(b, temp);
    }
}