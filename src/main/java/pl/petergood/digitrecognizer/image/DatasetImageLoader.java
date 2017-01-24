package pl.petergood.digitrecognizer.image;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class DatasetImageLoader {

    public static final int MIN_COLOR = 190;

    private DataInputStream datasetInputStream;
    private DataInputStream tagInputStream;

    public DatasetImageLoader(String datasetName, String tagFileName) throws FileNotFoundException {
        datasetInputStream = new DataInputStream(new FileInputStream(getClass().getResource(datasetName).getFile()));
        tagInputStream = new DataInputStream(new FileInputStream(getClass().getResource(tagFileName).getFile()));
    }

    public ArrayList<Image> loadImages() throws IOException {
        ArrayList<Image> images = new ArrayList<>();

        tagInputStream.skip(8);
        datasetInputStream.skip(4);

        int imageAmount = datasetInputStream.readInt();
        int imageHeight = datasetInputStream.readInt();
        int imageWidth = datasetInputStream.readInt();

        for (int i = 0; i < imageAmount; i++) {
            Image image = new Image(imageWidth, imageHeight, String.valueOf(tagInputStream.read()));

            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    int nextValue = datasetInputStream.read();

                    image.setColor(y, x, nextValue < MIN_COLOR ? 0 : nextValue);
                }
            }

            images.add(image);
        }

        return images;
    }

}
