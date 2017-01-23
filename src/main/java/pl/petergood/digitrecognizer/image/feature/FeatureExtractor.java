package pl.petergood.digitrecognizer.image.feature;

import pl.petergood.digitrecognizer.image.Image;

import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class FeatureExtractor {

    private Image image;

    private ArrayList<Feature> features = new ArrayList<>();

    public FeatureExtractor(Image image) {
        this.image = image;
    }

    public void fillIn(int x, int y) {
        if (x >= 0 && y >= 0 && x < image.getWidth() && y < image.getHeight() && image.getColor(x, y) == 0) {
            image.setColor(x, y, 500);

            fillIn(x + 1, y);
            fillIn(x - 1, y);
            fillIn(x, y + 1);
            fillIn(x, y - 1);
        }
    }

}
