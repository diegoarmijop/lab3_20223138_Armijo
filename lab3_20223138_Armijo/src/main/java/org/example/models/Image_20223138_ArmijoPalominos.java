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
    private List<Pixel> pixels;
    private int width = 0;
    private int height = 0;

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

    public int getWidth() {
        return width;
    }

    public  int getHeight() {
        return height;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    public  void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    private Pixel getFirstPixel(){
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
    public String isBitmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixbit_20223138_ArmijoPalominos){
            return "La imagen es un bitmap.";
        }
        return "La imagen NO es un bitmap.";
    }

    //Metodo que verifica si una imagen es un pixmap.
    //Param: No tiene
    //Salida: String
    public  String isPixmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixmap_20223138_ArmijoPalominos){
            return "La imagen es un pixmap.";
        }
        return "La imagen NO es un pixmap.";
    }

    //Metodo que verifica si una imagen es un hexmap.
    //Param: No tiene
    //Salida: String
    public String isHexmap(){
        Pixel p = getFirstPixel();
        if (p instanceof Pixhex_20223138_ArmijoPalominos){
            return "La imagen es un pixhex.";
        }
        return "La imagen NO es un pixhex.";
    }

    // Metodo que verifica si una imagen esta comprimida.
    //Param: No tiene
    //Salida: String
    public String isCompressed(){

        int p = (this.getWidth() * this.getHeight());
        int c = (this.getPixels().size());
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

        for(int i = 0; i < this.getPixels().size(); i++){
            Pixel p = this.getPixels().get(i);
            y = Math.abs(p.getY() - (this.getWidth() - 1));
            this.getPixels().get(i).setY(y);
        }
        return "La imagen ha sido modificada exitosamente.";
    }

    // Metodo que permite invertir una imagen verticalmente.
    //Param: No tiene
    //Salida: String
    public String flipV(){

        int x = 0;

        for(int i = 0; i < this.getPixels().size(); i++){
            Pixel p = this.getPixels().get(i);
            x = Math.abs(p.getX() - (this.getHeight() - 1));
            this.getPixels().get(i).setX(x);
        }
        return "La imagen ha sido modificada exitosamente.";
    }

    // Metodo que permite rotar una imagen en 90 grados.
    //Param: No tiene
    //Salida: String
    public String rotate90(){

        int x = 0;
        int y = 0;
        for(int i = 0; i < this.getPixels().size(); i++){
            Pixel p = this.getPixels().get(i);
            y = p.getX();
            x = Math.abs(p.getY() - (this.getWidth() - 1));
            this.getPixels().get(i).setX(x);
            this.getPixels().get(i).setY(y);
        }
        int aux = this.getWidth();
        this.setWidth(this.getHeight());
        this.setHeight(aux);
        return "La imagen ha sido rotada exitosamente.";
    }

    // Metodo que permite recortar una imagen a partir de un cuadrante.
    //Param: int X1, int X2, int Y1, int Y2
    //Salida: String
    public String crop(int x1, int y1, int x2, int y2){

        List<Pixel> pixelsAux = new ArrayList<>();
        List<Integer> coordX = new ArrayList<Integer>();
        List<Integer> coordY = new ArrayList<Integer>();

        for(int i = 0; i < this.getPixels().size(); i++){
            Pixel p = this.getPixels().get(i);
            if(p.getX() >= x1 && p.getX() <= x2 && p.getY() >= y1 && p.getY() <= y2){
                pixelsAux.add(p);
            }
        }

        for(int i = 0; i < pixelsAux.size(); i++){
            Pixel p = pixelsAux.get(i);
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

        //this.setWidth(newCoordY.size());
        //this.setHeight(newCoordX.size());
        this.setPixels(pixelsAux);

        System.out.println("LA NUEVA DIMENSION DE LA IMAGEN ES " + newCoordY.size() + "x" + newCoordX.size());
        return "--------- IMAGEN CORTADA CORRECTAMENTE -----------";

    }

    //Metodo que permite transformar una imagen RGB a Hexadecimal.
    //Param: No tiene
    //Salida: String
    public String imgRGBToHex(){

        Pixel pix = getFirstPixel();
        List<Pixel> pixelsAux = new ArrayList<>();


        if (pix instanceof Pixmap_20223138_ArmijoPalominos){
            for(int i = 0; i < this.getPixels().size(); i++){
                Pixel p = this.getPixels().get(i);
                String hex = String.format("#%02x%02x%02x", ((Pixmap_20223138_ArmijoPalominos)p).getR(), ((Pixmap_20223138_ArmijoPalominos)p).getG(), ((Pixmap_20223138_ArmijoPalominos)p).getB());
                Pixhex_20223138_ArmijoPalominos pixelAux = new Pixhex_20223138_ArmijoPalominos(p.getX(), p.getY(), p.getDepth(), hex);
                pixelsAux.add(pixelAux);
            }
            this.setPixels(pixelsAux);
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
            for(int i = 0; i < this.getPixels().size(); i++){
                Pixel p = this.getPixels().get(i);
                values.add(((Pixbit_20223138_ArmijoPalominos)p).getBit());
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

            for(int i = 0; i < this.getPixels().size(); i++){
                Pixel p = this.getPixels().get(i);
                red.add(((Pixmap_20223138_ArmijoPalominos)p).getR());
                green.add(((Pixmap_20223138_ArmijoPalominos)p).getG());
                blue.add(((Pixmap_20223138_ArmijoPalominos)p).getB());
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
            for(int i = 0; i < this.getPixels().size(); i++){
                Pixel p = this.getPixels().get(i);
                hex.add(((Pixhex_20223138_ArmijoPalominos)p).getHex());
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
            for(int i = 0; i < this.getPixels().size(); i++){
                if(pixel.getX() == this.getPixels().get(i).getX() && pixel.getY() == this.getPixels().get(i).getY()){
                    ((Pixbit_20223138_ArmijoPalominos)this.getPixels().get(i)).setBit(((Pixbit_20223138_ArmijoPalominos)pixel).getBit());
                    this.getPixels().get(i).setDepth(pixel.getDepth());
                }
            }
        }else if(pixel instanceof Pixmap_20223138_ArmijoPalominos){
            for(int i = 0; i < this.getPixels().size(); i++){
                if(pixel.getX() == this.getPixels().get(i).getX() && pixel.getY() == this.getPixels().get(i).getY()){
                    ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setR(((Pixmap_20223138_ArmijoPalominos)pixel).getR());
                    ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setG(((Pixmap_20223138_ArmijoPalominos)pixel).getG());
                    ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setB(((Pixmap_20223138_ArmijoPalominos)pixel).getB());
                }
            }

        }else{
            for(int i = 0; i < this.getPixels().size(); i++){
                if(pixel.getX() == this.getPixels().get(i).getX() && pixel.getY() == this.getPixels().get(i).getY()){
                    ((Pixhex_20223138_ArmijoPalominos)this.getPixels().get(i)).setHex(((Pixhex_20223138_ArmijoPalominos)pixel).getHex());
                    this.getPixels().get(i).setDepth(pixel.getDepth());
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
            for(int i = 0; i < this.getPixels().size(); i++){
                int newbit = Math.abs(((Pixbit_20223138_ArmijoPalominos)this.getPixels().get(i)).getBit() - 1);
                ((Pixbit_20223138_ArmijoPalominos)this.getPixels().get(i)).setBit(newbit);
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
            for (int i = 0; i < this.getPixels().size(); i++) {
                int newR = Math.abs(((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).getR() - 255);
                int newG = Math.abs(((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).getG() - 255);
                int newB = Math.abs(((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).getB() - 255);
                ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setR(newR);
                ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setG(newG);
                ((Pixmap_20223138_ArmijoPalominos)this.getPixels().get(i)).setB(newB);
            }
        }
        return "---- IMAGEN CON LOS COLORES RGB INVERTIDOS ----";
    }


    //Metodo que permite mostrar una imagen por salida.
    @Override
    public String toString () {

        String resultado = "Imagen de dimensiones " + this.getWidth() + "x" + this.getHeight() + "\n";
        Pixel pix = getFirstPixel();
        if (pix instanceof Pixbit_20223138_ArmijoPalominos){
            for (int i = 0; i < this.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < this.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + ((Pixbit_20223138_ArmijoPalominos)posicionEncontrada.get()).getBit();
                    }
                    else {
                        resultado += "| ";
                    }
                }
                resultado += "|\n";
            }
            //return resultado;
        }else if (pix instanceof Pixmap_20223138_ArmijoPalominos){

            for (int i = 0; i < this.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < this.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + ((Pixmap_20223138_ArmijoPalominos)posicionEncontrada.get()).getR() + " " + ((Pixmap_20223138_ArmijoPalominos)posicionEncontrada.get()).getG() + " " + ((Pixmap_20223138_ArmijoPalominos)posicionEncontrada.get()).getB();
                    }
                    else {
                        resultado += "| ";
                    }
                }
                resultado += "|\n";
            }

        }else{
            for (int i = 0; i < this.getHeight(); i++) {
                int iConstante = i;
                for (int j = 0; j < this.getWidth(); j++) {
                    int jConstante = j;
                    Optional<Pixel> posicionEncontrada = pixels.stream()
                            .filter(p -> p.getX() == iConstante)
                            .filter(p -> p.getY() == jConstante)
                            .findFirst();
                    if (posicionEncontrada.isPresent()) {
                        resultado += "|" + ((Pixhex_20223138_ArmijoPalominos)posicionEncontrada.get()).getHex();
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
