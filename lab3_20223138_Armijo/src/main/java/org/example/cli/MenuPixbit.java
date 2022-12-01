package org.example.cli;
import org.example.models.Image;
import org.example.models.Pixbit;
import org.example.models.Pixels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPixbit {

    public void showMenuPixbit (){

        System.out.println("\n### Crear Pixeles ###");

        int width = 0;
        int height = 0;
        List<Pixels> pixels = new ArrayList<>();

        int bit = 0;
        int depth = 0;

        Scanner sc = new Scanner(System.in);
        boolean error = false;

        do {
            System.out.println("Ingrese el ancho de la imagen: ");
            String line = sc.nextLine();
            error = false;
            try {
                width = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un ancho valido.");
                error = true;
            }
            if (!error && width <= 0) {
                System.out.println("Debe ingresar un ancho valido.");
                error = true;
            }
        } while (error);

        do {
            System.out.println("Ingrese el alto de la imagen: ");
            String line1 = sc.nextLine();
            error = false;
            try {
                height = Integer.parseInt(line1);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un alto valido.");
                error = true;
            }
            if (!error && height <= 0) {
                System.out.println("Debe ingresar un alto valido.");
                error = true;
            }
        } while (error);



        for (int i=0; i < width; i++){
            for (int j=0; j < height; j++){
                System.out.println("Pixel en la posicion (" + i + "," + j + ")");
                System.out.println("Ingrese el valor del bit (0 o 1): ");
                String line3 = sc.nextLine();
                bit = Integer.parseInt(line3);
                System.out.println("Ingrese la profundidad del pixel: ");
                String line4 = sc.nextLine();
                depth = Integer.parseInt(line4);
                System.out.println("x" + i + "y" + j + "ancho" + width + "alto" + height);
                Pixbit pixbit = new Pixbit(i,j,depth,bit);
                pixels.add(pixbit);
            }
        }

        Image imagePixbit = new Image(width, height, pixels);

    }
}
