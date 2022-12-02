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

    public void setR(int r) {
        this.r = r;
    }
    public void setG(int g) {
        this.g = g;
    }
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public void setBit(int bit) {

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
    public void setHex(String hex) {

    }

    @Override
    public void setR(String hex) {

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
