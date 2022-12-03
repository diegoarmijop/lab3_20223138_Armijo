package org.example.models;

public class Pixhex_20223138_ArmijoPalominos extends Pixel {

    //--------------------------------------------
    // Atributos.
    //--------------------------------------------
    private String hex;

    //--------------------------------------------
    // Getters and Setters.
    //--------------------------------------------
    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
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
        return 0;
    }

    @Override
    public int getB() {
        return 0;
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
    public void setR(String hex) {

    }

    @Override
    public int getG() {
        return 0;
    }

    //--------------------------------------------
    // Constructor.
    //--------------------------------------------
    public Pixhex_20223138_ArmijoPalominos(int x, int y, int depth, String hex) {
        super(x, y, depth);
        this.hex = hex;
    }
}