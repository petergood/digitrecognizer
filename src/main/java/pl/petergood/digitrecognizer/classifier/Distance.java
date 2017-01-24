package pl.petergood.digitrecognizer.classifier;

/**
 * Created by petergood on 24/01/17.
 */
public class Distance implements Comparable<Distance> {

    private String tag;
    private double distance;

    public Distance(String tag, double distance) {
        this.tag = tag;
        this.distance = distance;
    }

    public String getTag() {
        return tag;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Distance o) {
        if (distance < o.getDistance()) {
            return -1;
        } else if (distance == o.getDistance()) {
            return 0;
        } else if (distance > o.getDistance()) {
            return 1;
        }

        return 0;
    }
}
