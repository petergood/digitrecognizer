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
        int segmentAmount = 0;
        int minK = 0;
        int maxK = 0;

        if (args.length >= 3) {
            segmentAmount = Integer.parseInt(args[0]);
            minK = Integer.parseInt(args[1]);
            maxK = Integer.parseInt(args[2]);
        } else {
            System.exit(1);
        }

        ArrayList<Image> trainingImages = new ArrayList<>();
        ArrayList<Image> testingImages = new ArrayList<>();

        try {
            DatasetImageLoader trainingImagesLoader = new DatasetImageLoader("/train-images", "/train-labels");
            DatasetImageLoader testingImagesLoader = new DatasetImageLoader("/testing-images", "/testing-labels");

            trainingImages = trainingImagesLoader.loadImages();
            testingImages = testingImagesLoader.loadImages();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int offset = testingImages.size() / segmentAmount;

        for (int i = 0; i < segmentAmount; i++) {
            DigitRecognizerThread recognizerThread = new DigitRecognizerThread.Builder()
                    .setSegmentNumber(i)
                    .setTestingImages(new ArrayList<>(testingImages.subList(i * offset, i * offset + offset)))
                    .setTrainingImages(trainingImages)
                    .setMinK(minK)
                    .setMaxK(maxK)
                    .build();

            recognizerThread.start();
        }
    }

}
