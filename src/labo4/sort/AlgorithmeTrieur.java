package labo4.sort;

import java.util.List;

//Classe définissant l'usage de patron Method Template pour le labo
public abstract class AlgorithmeTrieur {

    @Override
    public String toString() {

        return getNom();
    }

    public final void trier(List<Integer> elements, ObservateurEtape observateur) {

        doTrier(elements, observateur);
    }

    public abstract String getNom();

    protected abstract void doTrier(List<Integer> elements, ObservateurEtape observateur);
}