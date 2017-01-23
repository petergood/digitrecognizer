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
        image.setColor(x, y, 500);

        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if ((i != x || j != y) && j < image.getWidth() && i < image.getHeight() && i >= 0 && j >= 0 && image.getColor(i, j) == 0) {
                    fillIn(i, j);
                }
            }
        }
    }

}
