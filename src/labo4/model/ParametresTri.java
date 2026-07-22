package labo4.model;

import labo4.sort.AlgorithmeTrieur;
import java.util.List;

public class ParametresTri {

    private final AlgorithmeTrieur  algorithme;
    private final List<Integer>     nombres;
    private final VitesseSimulation vitesse;

    public ParametresTri(AlgorithmeTrieur algorithme, List<Integer> nombres, VitesseSimulation vitesse) {

        this.algorithme = algorithme;
        this.nombres    = nombres;
        this.vitesse    = vitesse;
    }

    public AlgorithmeTrieur getAlgorithme() {

        return algorithme;
    }

    public List<Integer> getNombres()    {

        return nombres;
    }

    public VitesseSimulation getVitesse()    {

        return vitesse;
    }
}