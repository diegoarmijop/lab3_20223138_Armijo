package org.example.models;

import java.util.List;

public class Image {

    private int Width;
    private int Height;
    private List<Pixels> pixels;

    public List<Pixels> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixels> pixels) {
        this.pixels = pixels;
    }

    public Image(int width, int height, List<Pixels> pixels) {
        Width = width;
        Height = height;
        this.pixels = pixels;
    }

    private Pixels getFirstPixel(Image image){
        List<Pixels> pixels = getPixels(image);
        Pixels primerPixel = pixels.get(0);
        System.out.println(primerPixel);
        return primerPixel;
    }
}


