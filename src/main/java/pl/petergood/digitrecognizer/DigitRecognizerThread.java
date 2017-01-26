package pl.petergood.digitrecognizer;

import pl.petergood.digitrecognizer.classifier.ImageClassifier;
import pl.petergood.digitrecognizer.image.Image;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by petergood on 26/01/17.
 */
public class DigitRecognizerThread extends Thread {

    private ArrayList<Image> trainingImages;
    private ArrayList<Image> testingImages;

    private int minK;
    private int maxK;

    private int segmentNumber;

    public DigitRecognizerThread() {
    }

    @Override
    public void run() {
        for (int k = minK; k <= maxK; k++) {
            ImageClassifier imageClassifier = new ImageClassifier(k);
            imageClassifier.setTrainingData(trainingImages);

            int errorCount = 0;

            for (Image image : testingImages) {
                if (!imageClassifier.predict(image).equals(image.getTag())) errorCount++;
            }

            try {
                PrintWriter writer = new PrintWriter(segmentNumber + "-" + k + ".txt");
                writer.write(Double.toString((double) errorCount / testingImages.size()));
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setTrainingImages(ArrayList<Image> trainingImages) {
        this.trainingImages = trainingImages;
    }

    public void setTestingImages(ArrayList<Image> testingImages) {
        this.testingImages = testingImages;
    }

    public void setMinK(int minK) {
        this.minK = minK;
    }

    public void setMaxK(int maxK) {
        this.maxK = maxK;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public static class Builder {
        private DigitRecognizerThread digitRecognizerThread;

        public Builder() {
            digitRecognizerThread = new DigitRecognizerThread();
        }

        public Builder setSegmentNumber(int id) {
            digitRecognizerThread.setSegmentNumber(id);
            return this;
        }

        public Builder setTrainingImages(ArrayList<Image> trainingImages) {
            digitRecognizerThread.setTrainingImages(trainingImages);
            return this;
        }

        public Builder setTestingImages(ArrayList<Image> testingImages) {
            digitRecognizerThread.setTestingImages(testingImages);
            return this;
        }

        public Builder setMinK(int minK) {
            digitRecognizerThread.setMinK(minK);
            return this;
        }

        public Builder setMaxK(int maxK) {
            digitRecognizerThread.setMaxK(maxK);
            return this;
        }

        public DigitRecognizerThread build() {
            return digitRecognizerThread;
        }
    }

}
