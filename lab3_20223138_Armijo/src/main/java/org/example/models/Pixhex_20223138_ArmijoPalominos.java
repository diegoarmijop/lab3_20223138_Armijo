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


    //--------------------------------------------
    // Constructor.
    //--------------------------------------------
    public Pixhex_20223138_ArmijoPalominos(int x, int y, int depth, String hex) {
        super(x, y, depth);
        this.hex = hex;
    }
}