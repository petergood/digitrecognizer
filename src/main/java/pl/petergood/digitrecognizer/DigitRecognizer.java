package pl.petergood.digitrecognizer;


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
        ArrayList<Image> images = new ArrayList<>();

        try {
            DatasetImageLoader imageLoader = new DatasetImageLoader("/train-images", "/train-labels");
            images = imageLoader.loadImages();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image image = images.get(0);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                System.out.print(image.getColor(i, j) + " ");
            }

            System.out.println();
        }

        System.out.println("Tag: " + image.getTag());

        int[] featureVector = image.getFeatureVector();
        for (int i = 0; i < image.getWidth() * image.getHeight(); i++) {
            System.out.print(featureVector[i] + " ");
        }
    }

}
