package pl.petergood.digitrecognizer.image;

import java.util.ArrayList;

/**
 * Created by petergood on 23/01/17.
 */
public class Image {

    private ArrayList<Byte> bytes;

    public void appendByte(Byte b) {
        bytes.add(b);
    }

    public ArrayList<Byte> getBytes() {
        return bytes;
    }

}
