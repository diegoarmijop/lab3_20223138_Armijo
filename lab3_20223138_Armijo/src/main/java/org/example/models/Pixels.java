package org.example.models;

public abstract class Pixels {

    private int x;
    private int y;
    private int depth;

    public Pixels(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
