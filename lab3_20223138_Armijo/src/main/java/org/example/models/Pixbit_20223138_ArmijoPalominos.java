package org.example.models;

public class Pixbit_20223138_ArmijoPalominos extends Pixel {

    //--------------------------------------------
    // Atributos.
    //--------------------------------------------
    int bit;

    //--------------------------------------------
    // Getters and Setters.
    //--------------------------------------------
    public int getBit() {
        return bit;
    }


    public void setBit(int bit) {
        this.bit = bit;
    }

    //--------------------------------------------
    // Constructor.
    //--------------------------------------------
    public Pixbit_20223138_ArmijoPalominos(int x, int y, int depth, int bit) {
        super(x, y, depth);
        this.bit = bit;
    }
}
