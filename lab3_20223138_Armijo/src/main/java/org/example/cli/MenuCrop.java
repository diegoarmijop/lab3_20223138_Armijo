package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuCrop {

    public MenuCrop(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    private Image_20223138_ArmijoPalominos image;
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;



    public void showMenuCrop(){

        System.out.println("## Image crop ##");
        Scanner sc = new Scanner(System.in);
        //int option = 0;
        boolean error;
        do {
            error = false;
            System.out.println("Introduzca x1: ");
            String auxX1 = sc.nextLine();
            try {
                x1 = Integer.parseInt(auxX1);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error) ;

        do {
            error = false;
            System.out.println("Introduzca y1: ");
            String auxY1 = sc.nextLine();
            try {
                y1 = Integer.parseInt(auxY1);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error) ;

        do {
            error = false;
            System.out.println("Introduzca x2: ");
            String auxX2 = sc.nextLine();
            try {
                x2 = Integer.parseInt(auxX2);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error) ;

        do {
            error = false;
            System.out.println("Introduzca y2: ");
            String auxY2 = sc.nextLine();
            try {
                y2 = Integer.parseInt(auxY2);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
        } while (error) ;

        System.out.println(this.image.toString());
        System.out.println(Image_20223138_ArmijoPalominos.crop(x1, y2, x2, y2));
        System.out.println(this.image.toString());
    }

}
