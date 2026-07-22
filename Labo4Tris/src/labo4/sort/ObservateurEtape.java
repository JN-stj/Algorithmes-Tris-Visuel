package labo4.sort;

import java.util.List;

public interface ObservateurEtape {

    void surEtape(List<Integer> etatActuel, int[] indicesActifs);
}