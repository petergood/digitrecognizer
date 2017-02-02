package pl.petergood.digitrecognizer.classifier;

import pl.petergood.digitrecognizer.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by petergood on 24/01/17.
 */
public class ImageClassifier extends KNearestClassifier<Image> {

    public static final int DEFAULT_K = 3;

    public ImageClassifier(int k) {
        super(k);
    }

    public ImageClassifier() {
        super(DEFAULT_K);
    }

    @Override
    public String predict(Image image) {
        ArrayList<Distance> distances = new ArrayList<>();

        for (Image trainingImage : getTrainingData()) {
            distances.add(new Distance(trainingImage.getTag(), computeDistance(trainingImage.getFeatureVector(), image.getFeatureVector())));
        }

        distances.sort(null);
        distances.removeAll(distances.subList(getK(), distances.size()));

        HashMap<String, Integer> tagCount = new HashMap<>();

        for (Distance distance : distances) {
            tagCount.putIfAbsent(distance.getTag(), 0);
            tagCount.put(distance.getTag(), tagCount.get(distance.getTag()) + 1);
        }

        return getMostCommonTag(tagCount);
    }

    private String getMostCommonTag(HashMap<String, Integer> map) {
        Integer maxValue = 0;

        for (String tag : map.keySet()) {
            if (map.get(tag) > maxValue) {
                maxValue = map.get(tag);
            }
        }

        for (String tag : map.keySet()) {
            if (map.get(tag).equals(maxValue)) {
                return tag;
            }
        }

        return null;
    }
}
