package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;
import org.example.models.Pixbit_20223138_ArmijoPalominos;
import org.example.models.Pixel;
import org.example.models.Pixhex_20223138_ArmijoPalominos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



public class MenuPixhex {

    public static boolean validate(String text) {
        return text.matches("#[0-9A-Fa-f]{6}");
    }

    public void showMenuPixhex(){

        int width = 0;
        int height = 0;
        List<Pixel> pixels = new ArrayList<>();
        int x = 0;
        int y = 0;
        String hex;
        int depth = 0;
        boolean error;

        Scanner sc = new Scanner(System.in);
        System.out.println("## Crear imagen pixhex ##");

        do{
            error = false;
            System.out.println("Ingrese el ancho de la imagen: ");
            String auxWidth = sc.nextLine();
            try {
                width = Integer.parseInt(auxWidth);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && width < 1) {
                System.out.println("Debe ingresar un numero mayor a 0.");
                error = true;
            }
        } while (error);

        do{
            error = false;
            System.out.println("Ingrese el alto de la imagen: ");
            String auxHeight = sc.nextLine();
            try {
                height = Integer.parseInt(auxHeight);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && height < 1) {
                System.out.println("Debe ingresar un numero mayor a 0.");
                error = true;
            }
        } while (error);

        int count = 1;

        for(x = 0; x < height; x++){
            for(y = 0; y < width; y++){

                System.out.println("## Pixel " + count + "/" + (width*height) + " ##");
                count = count + 1;
                System.out.println("## Pixel en la posición (" + x + "," + y + ") ##");

                do{
                    error = false;
                    System.out.println("Ingrese el numero hexadecimal: ");
                    hex = sc.nextLine();

                    if (hex.length() != 7 || !validate(hex) ) {
                        System.out.println("Debe un numero hexadecimal valido");
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

                Pixhex_20223138_ArmijoPalominos pixel = new Pixhex_20223138_ArmijoPalominos(x,y,depth,hex);

                pixels.add(pixel);
            }
        }

        Image_20223138_ArmijoPalominos image = new Image_20223138_ArmijoPalominos(width, height, pixels);
        System.out.println("La imagen ha sido creada con exito.\n");
        MenuOption menuOption = new MenuOption(image);
        menuOption. showMenuOption();

    }

}
