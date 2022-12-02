package org.example.models;

import java.util.List;

public class Image_20223138_ArmijoPalominos {

    private static List<Pixel> pixels;
    private static int width = 0;
    private static int height = 0;

    public Image_20223138_ArmijoPalominos(int width, int height, List<Pixel> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public static List<Pixel> getPixels() {
        return pixels;
    }

    private static Pixel getFirstPixel(){
        List<Pixel> pixels = getPixels();
        Pixel firstPixel = pixels.get(0);
        return firstPixel;
    }

    public static String isBitmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixbit_20223138_ArmijoPalominos){
            return "La imagen es un bitmap.";
        }
        return "La imagen NO es un bitmap.";
    }

    public static String isPixmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixmap_20223138_ArmijoPalominos){
            return "La imagen es un pixmap.";
        }
        return "La imagen NO es un pixmap.";
    }

    public static String isHexmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixhex_20223138_ArmijoPalominos){
            return "La imagen es un pixhex.";
        }
        return "La imagen NO es un pixhex.";
    }

    public static String isCompressed(){

        int p = (Image_20223138_ArmijoPalominos.getWidth() * Image_20223138_ArmijoPalominos.getHeight());
        int c = (Image_20223138_ArmijoPalominos.getPixels().size());
        if(p == c){
            return "La imagen no esta comprimida.";
        }else{
            return "La imagen esta comprimida.";
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


}
