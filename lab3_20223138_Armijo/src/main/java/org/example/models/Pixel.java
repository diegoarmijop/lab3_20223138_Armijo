package org.example.models;

public abstract class Pixel {

    //--------------------------------------------
    // Atributos.
    //--------------------------------------------
    private int x;
    private int y;
    private int depth;

    //--------------------------------------------
    // Getters and Setters
    //--------------------------------------------
    public abstract void setBit(int bit);
    public abstract int getBit();
    public abstract int getR();
    public abstract int getB();
    public abstract void setHex(String hex);
    public abstract void setR(int r);
    public abstract void setG(int g);
    public abstract void setB(int b);
    public abstract void setR(String hex);
    public abstract int getG();
    public abstract String getHex();

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

    //--------------------------------------------
    // Constructor.
    //--------------------------------------------
    public Pixel(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}