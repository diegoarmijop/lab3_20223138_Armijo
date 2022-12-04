package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;
import org.example.models.Pixhex_20223138_ArmijoPalominos;

import java.util.Scanner;

import static org.example.cli.MenuPixhex.validate;

public class MenuChangePixhex {

    public MenuChangePixhex(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    private Image_20223138_ArmijoPalominos image;

    public void showMenuChangePixhex(){

        int x = 0;
        int y = 0;
        String hex;
        int depth = 0;

        Scanner sc = new Scanner(System.in);
        boolean error;

        System.out.println("## Creacion de pixel tipo pixhex ##");

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
        System.out.println(this.image.toString());
        System.out.println(this.image.changePixel(pixel));
        System.out.println(this.image.toString());

    }
}
