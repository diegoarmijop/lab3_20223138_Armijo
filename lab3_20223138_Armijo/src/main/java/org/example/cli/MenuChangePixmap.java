package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;
import org.example.models.Pixmap_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuChangePixmap {

    public MenuChangePixmap(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    private Image_20223138_ArmijoPalominos image;

    public void showMenuChangePixmap(){
        int x = 0;
        int y = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int depth = 0;

        Scanner sc = new Scanner(System.in);
        boolean error;

        System.out.println("## Creacion de pixel tipo pixmap ##");
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
            System.out.println("Ingrese el color R: ");
            String auxR = sc.nextLine();
            try {
                r = Integer.parseInt(auxR);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && (r < 0 || r > 255)) {
                System.out.println("Debe ingresar un valor dentro del rango permitido (0-255).");
                error = true;
            }
        } while (error);

        do{
            error = false;
            System.out.println("Ingrese el color G: ");
            String auxG = sc.nextLine();
            try {
                g = Integer.parseInt(auxG);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && (g < 0 || g > 255)) {
                System.out.println("Debe ingresar un valor dentro del rango permitido (0-255).");
                error = true;
            }
        } while (error);

        do{
            error = false;
            System.out.println("Ingrese el color B: ");
            String auxB = sc.nextLine();
            try {
                b = Integer.parseInt(auxB);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero.");
                error = true;
            }
            if (!error && (b < 0 || b > 255)) {
                System.out.println("Debe ingresar un valor dentro del rango permitido (0-255).");
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
                System.out.println("Debe ingresar un valor positivo.");
                error = true;
            }
        } while (error);

        Pixmap_20223138_ArmijoPalominos pixel = new Pixmap_20223138_ArmijoPalominos(x, y, depth, r,g,b);
        System.out.println(this.image.toString());
        System.out.println(this.image.changePixel(pixel));
        System.out.println(this.image.toString());
    }
}
