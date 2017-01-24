package pl.petergood.digitrecognizer.classifier;

import java.util.ArrayList;

/**
 * Created by petergood on 24/01/17.
 */
public abstract class KNearestClassifier<T> implements Classifier<T> {

    private ArrayList<T> trainingData;

    private int k;

    public KNearestClassifier(int k) {
        this.k = k;
    }

    public void setTrainingData(ArrayList<T> trainingData) {
        this.trainingData = trainingData;
    }

    public ArrayList<T> getTrainingData() {
        return trainingData;
    }

    protected double computeDistance(int[] featureVectorA, int[] featureVectorB) {
        double total = 0;
        int vectorLength = featureVectorA.length; //both vectors are the same length (28^2)

        for (int i = 0; i < vectorLength; i++) {
            total += Math.pow(featureVectorA[i] - featureVectorB[i], 2);
        }

        //fun fact - we are computing the distance between two points in a 784 dimensional space.
        //Try to visualise that :)
        return Math.sqrt(total);
    }

    protected int getK() {
        return k;
    }

}
