package org.example.models;

public class Pixhex_20223138_ArmijoPalominos extends Pixel {

    private String hex;

    public Pixhex_20223138_ArmijoPalominos(int x, int y, int depth, String hex) {
        super(x, y, depth);
        this.hex = hex;
    }

    @Override
    public int getBit() {
        return 0;
    }


}