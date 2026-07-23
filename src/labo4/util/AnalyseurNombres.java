package labo4.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AnalyseurNombres {

    public List<Integer> analyser(String entree) {

        if (entree == null || entree.isBlank()) {

            throw new IllegalArgumentException("La liste de nombres est vide.");
        }

        try {

            return Arrays.stream(entree.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        catch (NumberFormatException e) {

            throw new IllegalArgumentException("Format invalide. Ex: 50,87,12");
        }
    }
}