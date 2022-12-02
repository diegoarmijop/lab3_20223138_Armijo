package org.example.models;

public class Pixmap_20223138_ArmijoPalominos extends Pixel {

    private int r=0;
    private int g=0;
    private int b=0;

    public Pixmap_20223138_ArmijoPalominos(int x, int y, int depth, int r, int g, int b) {
        super(x, y, depth);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public int getBit() {
        return 0;
    }

    @Override
    public int getR() {
        return r;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getG() {
        return g;
    }

    @Override
    public String getHex() {
        return null;
    }
}
