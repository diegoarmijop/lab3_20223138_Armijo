package org.example.models;

public class Pixbit_20223138_ArmijoPalominos extends Pixel {

    final int bit;

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
    public int getG() {
        return 0;
    }

    @Override
    public String getHex() {
        return null;
    }

    public Pixbit_20223138_ArmijoPalominos(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }




}
