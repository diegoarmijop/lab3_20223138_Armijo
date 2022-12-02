package org.example.models;

public class Pixbit_20223138_ArmijoPalominos extends Pixel {

    int bit;

    public int getBit() {
        return bit;
    }

    @Override
    public int getR() {
        return 0;
    }

    @Override
    public int getB() {
        return 0;
    }

    @Override
    public void setHex(String hex) {

    }

    @Override
    public void setR(String hex) {

    }

    @Override
    public void setR(int r) {

    }

    @Override
    public void setG(int g) {

    }

    @Override
    public void setB(int b) {

    }

    @Override
    public int getG() {
        return 0;
    }

    @Override
    public String getHex() {
        return null;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public Pixbit_20223138_ArmijoPalominos(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }




}
