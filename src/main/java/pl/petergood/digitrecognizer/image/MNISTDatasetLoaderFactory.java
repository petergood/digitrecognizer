package pl.petergood.digitrecognizer.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by petergood on 23/01/17.
 */
public class MNISTDatasetLoaderFactory {

    public static final int IMAGE_WIDTH = 28;
    public static final int IMAGE_HEIGHT = 28;
    public static final int IMAGE_AMOUNT = 30;

    private FileInputStream inputStream;

    public MNISTDatasetLoaderFactory(String inputFilePath) throws FileNotFoundException {
        inputStream = new FileInputStream(getClass().getResource(inputFilePath).getFile());
    }

    public DatasetImageLoader getDatasetImageLoader() {
        DatasetImageLoader loader = new DatasetImageLoader(inputStream,
                IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_AMOUNT);

        return loader;
    }

}
