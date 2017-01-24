package pl.petergood.digitrecognizer.classifier;

import java.util.ArrayList;

/**
 * Created by petergood on 24/01/17.
 */
public interface Classifier<T> {
    void setTrainingData(ArrayList<T> trainingData);
    String predict(T object);
}
