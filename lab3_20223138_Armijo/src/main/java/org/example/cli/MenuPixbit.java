package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;
import org.example.models.Pixbit_20223138_ArmijoPalominos;
import org.example.models.Pixel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPixbit {

    public void showMenuPixbit(){

        int width = 0;
        int height = 0;
        List<Pixel> pixels = new ArrayList<>();
        int x = 0;
        int y = 0;
        int bit = 0;
        int depth = 0;
        boolean error;

        Scanner sc = new Scanner(System.in);
        System.out.println("## Crear imagen pixbit ##");

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

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){

                System.out.println("## Pixel " + count + "/" + (width*height) + " ##");
                count = count + 1;

                do{
                    error = false;
                    System.out.println("Ingrese la coordenada X: ");
                    String coordX = sc.nextLine();
                    try {
                        x = Integer.parseInt(coordX);
                    } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar un numero entero.");
                        error = true;
                    }
                    if (!error && x < 0) {
                        System.out.println("Debe ingresar una coordenada valida.");
                        error = true;
                    }
                    if (!error && x > height) {
                        System.out.println("Debe ingresar una coordenada valida.");
                        error = true;
                    }
                } while (error);

                do{
                    error = false;
                    System.out.println("Ingrese la coordenada Y: ");
                    String coordY = sc.nextLine();
                    try {
                        y = Integer.parseInt(coordY);
                    } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar un numero entero.");
                        error = true;
                    }
                    if (!error && y < 0) {
                        System.out.println("Debe ingresar una coordenada valida.");
                        error = true;
                    }
                    if (!error && y > width) {
                        System.out.println("Debe ingresar una coordenada valida.");
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

                pixels.add(pixel);
            }
        }

        Image_20223138_ArmijoPalominos image = new Image_20223138_ArmijoPalominos(width, height, pixels);
        System.out.println("La imagen ha sido creada con exito.\n");
        MenuOption menuOption = new MenuOption(image);
        menuOption. showMenuOption();

    }

}
