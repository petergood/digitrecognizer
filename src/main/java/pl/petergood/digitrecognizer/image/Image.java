package pl.petergood.digitrecognizer.image;

/**
 * Created by petergood on 23/01/17.
 */
public class Image {

    private int width;
    private int height;

    private int pixels[][];

    private String tag;

    public Image(int width, int height, String tag) {
        this.width = width;
        this.height = height;
        this.tag = tag;

        pixels = new int[width][height];
    }

    public void setColor(int x, int y, int RGB) {
        pixels[x][y] = RGB;
    }

    public int getColor(int x, int y) {
        return pixels[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTag() {
        return tag;
    }

    public int[] getFeatureVector() {
        int[] featureVector = new int[width * height];
        int i = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                featureVector[i] = pixels[x][y];
                i++;
            }
        }

        return featureVector;
    }

}
