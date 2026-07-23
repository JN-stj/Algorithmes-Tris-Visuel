package labo4.model;


public enum VitesseSimulation {

    LENTE("Lente", 600),
    NORMALE("Normale", 250),
    RAPIDE("Rapide", 80);

    private final String libelle;
    private final int    delaiMs;

    VitesseSimulation(String libelle, int delaiMs) {

        this.libelle = libelle;
        this.delaiMs = delaiMs;
    }
    public int getDelaiMs() {

        return delaiMs;
    }

    @Override
    public String toString() {

        return libelle;
    }
}