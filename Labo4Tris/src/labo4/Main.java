package labo4;

import javafx.application.Application;
import javafx.stage.Stage;
import labo4.sort.AlgorithmeTrieur;
import labo4.sort.MergeSort;
import labo4.sort.QuickSort;
import labo4.vue.FenetrePrincipale;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage ignoree) throws Exception {

        List<AlgorithmeTrieur> algorithmes = List.of(
                new MergeSort(),
                new QuickSort()
        );
        new FenetrePrincipale(algorithmes).show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}