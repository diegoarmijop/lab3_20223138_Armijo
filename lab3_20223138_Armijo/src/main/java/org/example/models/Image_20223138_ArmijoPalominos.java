package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Image_20223138_ArmijoPalominos {

    private static List<Pixel> pixels;
    private static int width = 0;
    private static int height = 0;

    public static void setPixels(List<Pixel> pixels) {
        Image_20223138_ArmijoPalominos.pixels = pixels;
    }

    public static void setWidth(int width) {
        Image_20223138_ArmijoPalominos.width = width;
    }

    public static void setHeight(int height) {
        Image_20223138_ArmijoPalominos.height = height;
    }

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

    public String flipH(){

        int y = 0;

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            y = Math.abs(p.getY() - (Image_20223138_ArmijoPalominos.getWidth() - 1));
            Image_20223138_ArmijoPalominos.getPixels().get(i).setY(y);
        }
        return "La imagen ha sido modificada exitosamente.";
    }

    public String flipV(){

        int x = 0;

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            x = Math.abs(p.getY() - (Image_20223138_ArmijoPalominos.getHeight() - 1));
            Image_20223138_ArmijoPalominos.getPixels().get(i).setX(x);
        }
        return "La imagen ha sido modificada exitosamente.";
    }


    public String rotate90(){

        int x = 0;
        int y = 0;
        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            y = x;
            x = Math.abs(p.getY() - (Image_20223138_ArmijoPalominos.getWidth() - 1));
            Image_20223138_ArmijoPalominos.getPixels().get(i).setX(x);
            Image_20223138_ArmijoPalominos.getPixels().get(i).setY(y);
        }
        int aux = Image_20223138_ArmijoPalominos.getWidth();
        Image_20223138_ArmijoPalominos.setWidth(Image_20223138_ArmijoPalominos.getHeight());
        Image_20223138_ArmijoPalominos.setHeight(aux);
        return "La imagen ha sido rotada exitosamente.";
    }

    public static String crop(int x1, int y1, int x2, int y2){

        List<Pixel> pixelsAux = new ArrayList<>();

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            if(p.getX() >= x1 && p.getX() <= x2 && p.getY() >= y1 && p.getY() <= y2){
                pixelsAux.add(p);
            }
        }
        Image_20223138_ArmijoPalominos.setPixels(pixelsAux);
        return "Imagen crop.";
    }

    public String imgRGBToHex(){

        Pixel pix = getFirstPixel();
        List<Pixel> pixelsAux = new ArrayList<>();

        if (pix instanceof Pixmap_20223138_ArmijoPalominos){
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
                String hex = String.format("#%02x%02x%02x", p.getR(), p.getG(), p.getB());
                Pixhex_20223138_ArmijoPalominos pixelAux = new Pixhex_20223138_ArmijoPalominos(p.getX(), p.getY(), p.getDepth(), hex);
                pixelsAux.add(pixelAux);
            }
            Image_20223138_ArmijoPalominos.setPixels(pixelsAux);
        }
        return "La imagen no es RGB, ingrese una imagen valida.";
    }









    @Override
    public String toString () {

        String resultado = "Imagen de dimensiones " + Image_20223138_ArmijoPalominos.getWidth() + "x" + Image_20223138_ArmijoPalominos.getHeight() + "\n";
        Pixel pix = getFirstPixel();
        if (pix instanceof Pixbit_20223138_ArmijoPalominos){
            for (int i = 0; i < Image_20223138_ArmijoPalominos.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < Image_20223138_ArmijoPalominos.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + posicionEncontrada.get().getBit();
                    }
                    else {
                        resultado += "| ";
                    }
                }
                resultado += "|\n";
            }
            //return resultado;
        }else if (pix instanceof Pixmap_20223138_ArmijoPalominos){

            for (int i = 0; i < Image_20223138_ArmijoPalominos.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < Image_20223138_ArmijoPalominos.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + posicionEncontrada.get().getR() + " " + posicionEncontrada.get().getG() + " " + posicionEncontrada.get().getB();
                    }
                    else {
                        resultado += "| ";
                    }
                }
                resultado += "|\n";
            }

        }else{
            for (int i = 0; i < Image_20223138_ArmijoPalominos.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < Image_20223138_ArmijoPalominos.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + posicionEncontrada.get().getHex();
                    }
                    else {
                        resultado += "| ";
                    }
                }
                resultado += "|\n";
            }
            //return resultado;

        }
        return resultado;
    }






    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


}
