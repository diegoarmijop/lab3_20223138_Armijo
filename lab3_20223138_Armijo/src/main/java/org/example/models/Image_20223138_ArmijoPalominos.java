// Simulador de editor de imagenes en JAVA

package org.example.models;

//Se importan las clases que se utilizaran.
//import java.awt.*;
import java.util.*;
import java.util.List;
//import java.util.function.Function;
import java.util.stream.Collectors;

public class Image_20223138_ArmijoPalominos {
    //--------------------------------------------
    // Atributos.
    //--------------------------------------------
    private static List<Pixel> pixels;
    private static int width = 0;
    private static int height = 0;

    //--------------------------------------------
    // Constructor de image.
    //--------------------------------------------
    public Image_20223138_ArmijoPalominos(int width, int height, List<Pixel> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    //--------------------------------------------
    // Getters and Setters.
    //--------------------------------------------

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setPixels(List<Pixel> pixels) {
        Image_20223138_ArmijoPalominos.pixels = pixels;
    }

    public static void setWidth(int width) {
        Image_20223138_ArmijoPalominos.width = width;
    }

    public static void setHeight(int height) {
        Image_20223138_ArmijoPalominos.height = height;
    }

    public static List<Pixel> getPixels() {
        return pixels;
    }

    private static Pixel getFirstPixel(){
        List<Pixel> pixels = getPixels();
        Pixel firstPixel = pixels.get(0);
        return firstPixel;
    }

    //--------------------------------------------
    // Metodos.
    //--------------------------------------------

    //Metodo que verifica si una imagen es pixbit.
    //Param: No tiene
    //Salida: String
    public static String isBitmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixbit_20223138_ArmijoPalominos){
            return "La imagen es un bitmap.";
        }
        return "La imagen NO es un bitmap.";
    }

    //Metodo que verifica si una imagen es un pixmap.
    //Param: No tiene
    //Salida: String
    public static String isPixmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixmap_20223138_ArmijoPalominos){
            return "La imagen es un pixmap.";
        }
        return "La imagen NO es un pixmap.";
    }

    //Metodo que verifica si una imagen es un hexmap.
    //Param: No tiene
    //Salida: String
    public static String isHexmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixhex_20223138_ArmijoPalominos){
            return "La imagen es un pixhex.";
        }
        return "La imagen NO es un pixhex.";
    }

    // Metodo que verifica si una imagen esta comprimida.
    //Param: No tiene
    //Salida: String
    public static String isCompressed(){

        int p = (Image_20223138_ArmijoPalominos.getWidth() * Image_20223138_ArmijoPalominos.getHeight());
        int c = (Image_20223138_ArmijoPalominos.getPixels().size());
        if(p == c){
            return "La imagen no esta comprimida.";
        }else{
            return "La imagen esta comprimida.";
        }
    }

    // Metodo que permite invertir una imagen  horizontalmente.
    //Param: No tiene
    //Salida: String
    public String flipH(){

        int y = 0;

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            y = Math.abs(p.getY() - (Image_20223138_ArmijoPalominos.getWidth() - 1));
            Image_20223138_ArmijoPalominos.getPixels().get(i).setY(y);
        }
        return "La imagen ha sido modificada exitosamente.";
    }

    // Metodo que permite invertir una imagen verticalmente.
    //Param: No tiene
    //Salida: String
    public String flipV(){

        int x = 0;

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            x = Math.abs(p.getY() - (Image_20223138_ArmijoPalominos.getHeight() - 1));
            Image_20223138_ArmijoPalominos.getPixels().get(i).setX(x);
        }
        return "La imagen ha sido modificada exitosamente.";
    }

    // Metodo que permite rotar una imagen en 90 grados.
    //Param: No tiene
    //Salida: String
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

    // Metodo que permite recortar una imagen a partir de un cuadrante.
    //Param: int X1, int X2, int Y1, int Y2
    //Salida: String
    public static String crop(int x1, int y1, int x2, int y2){

        List<Pixel> pixelsAux = new ArrayList<>();
        List<Integer> coordX = new ArrayList<Integer>();
        List<Integer> coordY = new ArrayList<Integer>();

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            if(p.getX() >= x1 && p.getX() <= x2 && p.getY() >= y1 && p.getY() <= y2){
                pixelsAux.add(p);
            }
        }

        for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
            Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
            coordX.add(p.getX());
            coordY.add(p.getY());
        }

        Collections.sort(coordX);
        Collections.sort(coordY);

        List<Integer> newCoordX = coordX.stream()
                    .distinct()
                    .collect(Collectors.toList());

        List<Integer> newCoordY = coordY.stream()
                    .distinct()
                    .collect(Collectors.toList());

        Image_20223138_ArmijoPalominos.setWidth(newCoordY.size());
        Image_20223138_ArmijoPalominos.setHeight(newCoordX.size());
        Image_20223138_ArmijoPalominos.setPixels(pixelsAux);

        return "--------- IMAGEN CORTADA CORRECTAMENTE -----------";
    }

    //Metodo que permite transformar una imagen RGB a Hexadecimal.
    //Param: No tiene
    //Salida: String
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
        }else{
            System.out.println("La imagen no es RGB, ingrese una imagen valida.");

        }
        return "-------- imagen transformada exitosamente --------";
    }

    //Metodo que permite crear un histogram para cada tipo de imagen.
    //Param: No tiene
    //Salida: String
    public String histogram(){

        Pixel pix = getFirstPixel();
        List<Integer> values = new ArrayList<Integer>();
        List<Integer> bit0 = new ArrayList<Integer>();
        List<Integer> bit1 = new ArrayList<Integer>();
        List<Integer> red = new ArrayList<Integer>();
        List<Integer> green = new ArrayList<Integer>();
        List<Integer> blue = new ArrayList<Integer>();
        List<String> hex = new ArrayList<String>();


        if (pix instanceof Pixbit_20223138_ArmijoPalominos){
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
                values.add(p.getBit());
            }
            for(int i = 0; i < values.size(); i++){
                if(values.get(i) == 0){
                    bit0.add(values.get(i));
                } else{
                    bit1.add(1);
                }
            }
            System.out.println("------------ HISTOGRAMA IMAGE PIXBIT ------------");
            System.out.println("BIT 0 = " + bit0.size() + " | BIT 1 = " + bit1.size());

        } else if (pix instanceof Pixmap_20223138_ArmijoPalominos){

            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
                red.add(p.getR());
                green.add(p.getG());
                blue.add(p.getB());
            }

            List<String> redString = red.stream().map(Object::toString)
                    .collect(Collectors.toList());

            List<String> greenString = green.stream().map(Object::toString)
                    .collect(Collectors.toList());

            List<String> blueString = blue.stream().map(Object::toString)
                    .collect(Collectors.toList());

            Map<String, Integer> hm = new HashMap<String, Integer>();
            Map<String, Integer> greenAux = new HashMap<String, Integer>();
            Map<String, Integer> blueAux = new HashMap<String, Integer>();

            for (String i : redString) {
                Integer j = hm.get(i);
                hm.put(i, (j == null) ? 1 : j + 1);
            }

            for (String i : greenString) {
                Integer j = greenAux.get(i);
                greenAux.put(i, (j == null) ? 1 : j + 1);
            }

            for (String i : blueString) {
                Integer j = blueAux.get(i);
                blueAux.put(i, (j == null) ? 1 : j + 1);
            }

            System.out.println("------------ HISTOGRAMA IMAGE PIXMAP ------------");
            System.out.println("------------------ COLOR R ------------------");
            for (Map.Entry<String, Integer> val : hm.entrySet()) {
                System.out.println("Numero " + val.getKey() + " "
                        + "se repite"
                        + ": " + val.getValue() + " veces.");
            }

            System.out.println("------------------ COLOR G ------------------");

            for (Map.Entry<String, Integer> val : greenAux.entrySet()) {
                System.out.println("Numero " + val.getKey() + " "
                        + "se repite"
                        + ": " + val.getValue() + " veces.");
            }
            System.out.println("------------------ COLOR B ------------------");
            for (Map.Entry<String, Integer> val : blueAux.entrySet()) {
                System.out.println("Numero " + val.getKey() + " "
                        + "se repite"
                        + ": " + val.getValue() + " veces.");
            }

        } else{
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                Pixel p = Image_20223138_ArmijoPalominos.getPixels().get(i);
                hex.add(p.getHex());
            }

            Map<String, Integer> hm = new HashMap<String, Integer>();

            for (String i : hex) {
                Integer j = hm.get(i);
                hm.put(i, (j == null) ? 1 : j + 1);
            }
            System.out.println("------------ HISTOGRAMA IMAGE PIXHEX ------------");
            for (Map.Entry<String, Integer> val : hm.entrySet()) {
                System.out.println("Numero hexadecimal " + val.getKey() + " "
                        + "se repite"
                        + ": " + val.getValue() + " veces.");
            }
        }
        return "----------------- HISTOGRAMA CREADO EXITOSAMENTE -----------------";
    }

    // Metodo que permite cambiar el pixel dentro de una imagen.
    //Param: Pixel
    //Salida: String
    public String changePixel(Pixel pixel){

        if(pixel instanceof Pixbit_20223138_ArmijoPalominos){
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                if(pixel.getX() == Image_20223138_ArmijoPalominos.getPixels().get(i).getX() && pixel.getY() == Image_20223138_ArmijoPalominos.getPixels().get(i).getY()){
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setBit(pixel.getBit());
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setDepth(pixel.getDepth());
                }
            }
        }else if(pixel instanceof Pixmap_20223138_ArmijoPalominos){
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                if(pixel.getX() == Image_20223138_ArmijoPalominos.getPixels().get(i).getX() && pixel.getY() == Image_20223138_ArmijoPalominos.getPixels().get(i).getY()){
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setR(pixel.getR());
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setG(pixel.getG());
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setB(pixel.getB());
                }
            }

        }else{
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                if(pixel.getX() == Image_20223138_ArmijoPalominos.getPixels().get(i).getX() && pixel.getY() == Image_20223138_ArmijoPalominos.getPixels().get(i).getY()){
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setHex(pixel.getHex());
                    Image_20223138_ArmijoPalominos.getPixels().get(i).setDepth(pixel.getDepth());
                }
            }
        }
        return "------ SE HA MODIFICADO EL PIXEL EXITOSAMENTE ------";
    }

    //Metodo que permite invertir el color bit de una imagen de tipo pixbit.
    //Param: No tiene
    //Salida: String
    public String invertColorBit(){

        Pixel p = getFirstPixel();

        if (p instanceof Pixbit_20223138_ArmijoPalominos){
            for(int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++){
                int newbit = Math.abs(Image_20223138_ArmijoPalominos.getPixels().get(i).getBit() - 1);
                Image_20223138_ArmijoPalominos.getPixels().get(i).setBit(newbit);
            }
        }else{
            System.out.println("Ingrese una imagen de tipo pixbit.");
        }
        return "---------- IMAGEN CON LOS BITS INVERTIDOS CORRECTAMENTE ---------";
    }

    //Metodo que permite invertir el color de una imagen RGB.
    //Param: No tiene
    //Salida: String
    public String invertColorRGB() {
        Pixel p = getFirstPixel();
        if (p instanceof Pixmap_20223138_ArmijoPalominos) {
            for (int i = 0; i < Image_20223138_ArmijoPalominos.getPixels().size(); i++) {
                int newR = Math.abs(Image_20223138_ArmijoPalominos.getPixels().get(i).getR() - 255);
                int newG = Math.abs(Image_20223138_ArmijoPalominos.getPixels().get(i).getG() - 255);
                int newB = Math.abs(Image_20223138_ArmijoPalominos.getPixels().get(i).getB() - 255);
                Image_20223138_ArmijoPalominos.getPixels().get(i).setR(newR);
                Image_20223138_ArmijoPalominos.getPixels().get(i).setG(newG);
                Image_20223138_ArmijoPalominos.getPixels().get(i).setB(newB);
            }
        }
        return "---- IMAGEN CON LOS COLORES RGB INVERTIDOS ----";
    }


    //Metodo que permite mostrar una imagen por salida.
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
}
