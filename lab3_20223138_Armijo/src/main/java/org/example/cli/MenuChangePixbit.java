package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;
import org.example.models.Pixbit_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuChangePixbit {

    public MenuChangePixbit(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    private Image_20223138_ArmijoPalominos image;


    public void showMenuChangePixel(){

        int x = 0;
        int y = 0;
        int bit = 0;
        int depth = 0;

        Scanner sc = new Scanner(System.in);
        boolean error;

        System.out.println("## Creacion de pixel tipo pixbit ##");

        do{
            error = false;
            System.out.println("Ingrese la coordenada X: ");
            String auxX = sc.nextLine();
            try {
                x = Integer.parseInt(auxX);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && x < 0) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error);

        do{
            error = false;
            System.out.println("Ingrese la coordenada Y: ");
            String auxY = sc.nextLine();
            try {
                y = Integer.parseInt(auxY);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && x < 0) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error);


        do{
            error = false;
            System.out.println("Ingrese el bit (0/1): ");
            String auxBit = sc.nextLine();
            try {
                bit = Integer.parseInt(auxBit);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && (bit < 0 || bit > 1)) {
                System.out.println("Debe ingresar un bit valido.");
                error = true;
            }
        } while (error);

        do{
            error = false;
            System.out.println("Ingrese la profundidad: ");
            String auxDepth = sc.nextLine();
            try {
                depth = Integer.parseInt(auxDepth);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && depth < 0) {
                System.out.println("Debe ingresar una profundidad valida.");
                error = true;
            }
        } while (error);

        Pixbit_20223138_ArmijoPalominos pixel = new Pixbit_20223138_ArmijoPalominos(x,y,depth,bit);
        System.out.println(this.image.toString());
        System.out.println(this.image.changePixel(pixel));
        System.out.println(this.image.toString());


    }



}
