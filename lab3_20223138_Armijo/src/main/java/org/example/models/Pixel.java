package org.example.models;

public abstract class Pixel {

    public abstract int getBit();
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Pixel(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    private int depth;


}