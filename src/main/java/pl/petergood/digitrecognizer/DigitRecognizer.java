package pl.petergood.digitrecognizer;


import pl.petergood.digitrecognizer.image.DatasetImageLoader;
import pl.petergood.digitrecognizer.image.Image;
import pl.petergood.digitrecognizer.image.MNISTDatasetLoaderFactory;

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
            DatasetImageLoader imageLoader = new MNISTDatasetLoaderFactory("/train-images").getDatasetImageLoader();
            images = imageLoader.loadImages();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
