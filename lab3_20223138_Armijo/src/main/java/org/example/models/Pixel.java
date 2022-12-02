package org.example.models;

public abstract class Pixel {

    private int x;
    private int y;

    public Pixel(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    private int depth;


}