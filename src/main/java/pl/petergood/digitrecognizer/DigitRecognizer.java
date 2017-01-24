package pl.petergood.digitrecognizer;


import pl.petergood.digitrecognizer.classifier.ImageClassifier;
import pl.petergood.digitrecognizer.image.DatasetImageLoader;
import pl.petergood.digitrecognizer.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class DigitRecognizer {

    public static void main(String args[]) {
        ArrayList<Image> trainingImages = new ArrayList<>();
        ArrayList<Image> testingImages = new ArrayList<>();

        try {
            System.out.println("Loading training data...");
            DatasetImageLoader trainingImageLoader = new DatasetImageLoader("/train-images", "/train-labels");
            trainingImages = trainingImageLoader.loadImages();

            System.out.println("Loading testing data...");
            DatasetImageLoader testingImageLoader = new DatasetImageLoader("/testing-images", "/testing-labels");
            testingImages = testingImageLoader.loadImages();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageClassifier imageClassifier = new ImageClassifier();
        imageClassifier.setTrainingData(trainingImages);
    }

}
