package pl.petergood.digitrecognizer.image.feature;

/**
 * Created by petergood on 23/01/17.
 */
public class Feature {

    private String name;
    private int value;

    public Feature(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
