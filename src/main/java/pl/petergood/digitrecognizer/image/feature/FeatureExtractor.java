package pl.petergood.digitrecognizer.image.feature;

import pl.petergood.digitrecognizer.image.Image;

import java.util.HashMap;

/**
 * Created by petergood on 23/01/17.
 */
public class FeatureExtractor {

    public static final int BACKGROUND_FILL = 500;
    public static final int CLUSTERED_WHITE = 1;
    public static final int OPEN_AREA_FILL = 2;

    public static final int MIN_AMOUNT_IN_CLUSTER = 5;

    private Image image;
    private HashMap<String, Feature> features = new HashMap<>();

    private int pixelsFilledInCount = 0;

    public FeatureExtractor(Image image) {
        this.image = image;
    }

    public HashMap<String, Feature> getFeatures() {
        fillIn(0, 0, BACKGROUND_FILL, 0);

        features.put("holeAmount", new Feature("holeAmount", getHoleAmount()));

        return features;
    }

    private void fillIn(int x, int y, int fillColor, int targetColor) {
        if (x >= 0 && y >= 0 && x < image.getWidth() && y < image.getHeight() && image.getColor(x, y) == targetColor) {
            image.setColor(x, y, fillColor);
            pixelsFilledInCount++;

            fillIn(x + 1, y, fillColor, targetColor);
            fillIn(x - 1, y, fillColor, targetColor);
            fillIn(x, y + 1, fillColor, targetColor);
            fillIn(x, y - 1, fillColor, targetColor);
        }
    }

    private int getHoleAmount() {
        int clusterAmount = 0;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (image.getColor(x, y) == 0 && image.getColor(x, y) != CLUSTERED_WHITE) {
                    pixelsFilledInCount = 0;

                    fillIn(x, y, CLUSTERED_WHITE, 0);

                    if (pixelsFilledInCount > MIN_AMOUNT_IN_CLUSTER) clusterAmount++;
                }
            }
        }

        return clusterAmount;
    }

}
