package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuTypeImage {

    private Image_20223138_ArmijoPalominos image;

    public MenuTypeImage(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    public void showMenuTypeImage(){

        Scanner sc = new Scanner(System.in);

        System.out.println("## Tipo de imagen ##");
        System.out.println("1) Pixbit.");
        System.out.println("2) Pixmap.");
        System.out.println("3) Pixhex.");

        int option = 0;
        boolean error;

        do{
            error = false;
            System.out.println("Ingresa una opcion: ");
            String line = sc.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar una opcion valida.");
                error = true;
            }
            if (!error && (option > 3 || option < 1)) {
                System.out.println("Debe ingresar una opcion valida");
                error = true;
            }
        } while (error);

        if (option == 1) {
            System.out.println(this.image.isBitmap());
        }else if (option == 2) {
            System.out.println(this.image.isPixmap());
        }else {
            System.out.println(this.image.isHexmap());
        }


    }





}

