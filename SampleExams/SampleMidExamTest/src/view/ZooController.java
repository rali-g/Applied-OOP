package view;

import java.net.URL;
import java.util.*;

import blogic.Animal;
import blogic.AnimalInstance;
import blogic.AnimalType;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ZooController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDistribution;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnShowAll;

    @FXML
    private Button btnShowEndangered;

    @FXML
    private Button btnShuffle;

    @FXML
    private TextArea txaResult;

    private AnimalInstance[] samples;
    private Animal[] animals;

    @FXML
    void btnDistributionOnClick(ActionEvent event) {
        int[] arr = new int [Animal.REGIONS.length];
        for(int i = 0; i < samples.length; i++) {
            for(int j = 0; j < Animal.REGIONS.length; j++) {
                if(animals[samples[i].getAnimalKey()].getRegion().equals(Animal.REGIONS[j])) {
                    arr[j]++;
                }
            }
        }
        String result="";
        for(int i = 0; i < Animal.REGIONS.length; i++) {
            result += Animal.REGIONS[i] + ": " + arr[i] + "\n";
        }
        txaResult.setText(result);
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    private String printSamples(){
        String result = "";
        for(int i  =0; i < samples.length; i++){
            result += samples[i].toString() + "\n";
        }
        return result;
    }

    @FXML
    void btnShowAllOnClick(ActionEvent event) {
        AnimalInstance temp;
        for(int i = 0; i < samples.length; i++) {
            for(int j = 0; j < samples.length - i - 1; j++) {
                if (samples[j].getAnimalAge() < samples[j + 1].getAnimalAge()) {
                    temp = samples[j];
                    samples[j] = samples[j + 1];
                    samples[j + 1] = temp;
                }
            }
        }
        txaResult.setText(printSamples());
    }

    @FXML
    void btnShowEndangeredOnClick(ActionEvent event) {
        int[] arr = new int[AnimalType.values().length];
        for(int i = 0; i < samples.length; i++) {
            for(int j = 0; j < AnimalType.values().length; j++) {
                if(animals[samples[i].getAnimalKey()].isEndangered() &&
                animals[samples[i].getAnimalKey()].getAnimalType() == AnimalType.values()[j]) {
                    arr[j]++;
                }
            }
        }
        String result="";
        for(int i = 0; i < AnimalType.values().length; i++) {
            result += AnimalType.values()[i] + ": " + arr[i] + "\n";
        }
        txaResult.setText(result);
    }

    @FXML
    void btnShuffleOnClick(ActionEvent event) {
        Collections.shuffle(Arrays.asList(samples));
        txaResult.setText(printSamples());
    }

    @FXML
    void initialize() {
        assert btnDistribution != null : "fx:id=\"btnDistribution\" was not injected: check your FXML file 'zoo.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'zoo.fxml'.";
        assert btnShowAll != null : "fx:id=\"btnShowAll\" was not injected: check your FXML file 'zoo.fxml'.";
        assert btnShowEndangered != null : "fx:id=\"btnShowEndangered\" was not injected: check your FXML file 'zoo.fxml'.";
        assert btnShuffle != null : "fx:id=\"btnShuffle\" was not injected: check your FXML file 'zoo.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'zoo.fxml'.";

        animals = new Animal[]{
                new Animal("Тигър", AnimalType.MAMMAL, true, "Asia", true),
                new Animal("Фламинго", AnimalType.BIRD, false, "Africa", true),
                new Animal("Гущер", AnimalType.REPTILE, true, "Australia", true),
                new Animal("Пъстърва", AnimalType.FISH, false, "Europe", false),
                new Animal("Делфин", AnimalType.MAMMAL, false, "Australia", true),
                new Animal("Вълк", AnimalType.MAMMAL, true, "America", false)
        };

        samples = new AnimalInstance[20];

        Random random = new Random();

        int animalKey;
        String animalName;
        int animalAge;
        for (int i = 0; i < 20; i++) {
            animalKey = random.nextInt(animals.length);
            animalName = animals[animalKey].getName();
            animalAge = random.nextInt(10, 31);
            samples[i] = new AnimalInstance(animalKey, animalName, animalAge);
        }


    }

}
