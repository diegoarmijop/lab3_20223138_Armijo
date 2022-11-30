package org.example.models;

import java.util.List;

public class Image {

    private int Width;
    private int Height;
    private List<Pixels> pixels;

    public Image(int width, int height, List<Pixels> pixels) {
        Width = width;
        Height = height;
        this.pixels = pixels;
    }
}
