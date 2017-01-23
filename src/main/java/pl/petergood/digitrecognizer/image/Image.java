package pl.petergood.digitrecognizer.image;

import pl.petergood.digitrecognizer.image.feature.Feature;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by petergood on 23/01/17.
 */
public class Image {

    private int width;
    private int height;

    private int pixels[][];

    private HashMap<String, Feature> features = new HashMap<>();

    public Image(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width][height];
    }

    public void setColor(int x, int y, int RGB) {
        pixels[x][y] = RGB;
    }

    public int getColor(int x, int y) {
        return pixels[x][y];
    }

    public void setFeatures(HashMap<String, Feature> features) {
        this.features = features;
    }

    public HashMap<String, Feature> getFeatures() {
        return features;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
