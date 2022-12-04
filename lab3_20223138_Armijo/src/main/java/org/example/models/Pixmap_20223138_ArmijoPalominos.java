package org.example.models;

public class Pixmap_20223138_ArmijoPalominos extends Pixel {

    //--------------------------------------------
    // Atributos.
    //--------------------------------------------
    private int r;
    private int g;
    private int b;

    //--------------------------------------------
    // Getters and Setters.
    //--------------------------------------------
    public void setR(int r) {
        this.r = r;
    }
    public void setG(int g) {
        this.g = g;
    }
    public void setB(int b) {
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    //--------------------------------------------
    // Constructor.
    //--------------------------------------------
    public Pixmap_20223138_ArmijoPalominos(int x, int y, int depth, int r, int g, int b) {
        super(x, y, depth);
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
