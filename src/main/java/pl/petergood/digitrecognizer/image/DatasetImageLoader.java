package pl.petergood.digitrecognizer.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class DatasetImageLoader {

    public static final int MIN_COLOR = 190;

    private FileInputStream inputStream;

    private int imageWidth;
    private int imageHeight;
    private int imageAmount;

    public DatasetImageLoader(FileInputStream inputStream, int imageWidth, int imageHeight, int imageAmount) {
        this.inputStream = inputStream;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageAmount = imageAmount;
    }

    public ArrayList<Image> loadImages() throws IOException {
        ArrayList<Image> images = new ArrayList<>();

        //TODO read image width, image height, and image amount from dataset file
        inputStream.skip(16);

        for (int i = 0; i < imageAmount; i++) {
            Image image = new Image(imageWidth, imageHeight);

            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    int nextValue = inputStream.read();

                    image.setColor(y, x, nextValue < MIN_COLOR ? 0 : nextValue);
                }
            }

            images.add(image);
        }

        return images;
    }

}
