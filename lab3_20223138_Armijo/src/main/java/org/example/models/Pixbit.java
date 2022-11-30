package org.example.models;

public class Pixbit extends Pixels{

    private int bit;

    public Pixbit(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }
}
