package pl.petergood.digitrecognizer.image;

import pl.petergood.digitrecognizer.image.feature.Feature;

import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class Image {

    private int width;
    private int height;

    private int pixels[][];

    private ArrayList<Feature> features = new ArrayList<>();

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

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
