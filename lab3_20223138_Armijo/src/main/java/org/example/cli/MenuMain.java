package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuMain {

    public void showMenuMain(){

        System.out.println("## Manipulador de imágenes ##");
        System.out.println("Para comenzar debes crear una imagen: ");
        System.out.println("1) Crear imagen pixbit.");
        System.out.println("2) Crear imagen pixmap.");
        System.out.println("3) Crear imagen pixhex.");

        int option = 0;
        Scanner sc = new Scanner(System.in);
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

        if (option == 1){
            MenuPixbit menuPixbit = new MenuPixbit();
            menuPixbit.showMenuPixbit();
        } else if (option == 2){
            MenuPixmap menuPixmap = new MenuPixmap();
            menuPixmap.showMenuPixmap();
        } else{
            MenuPixhex menuPixhex = new MenuPixhex();
            menuPixhex.showMenuPixhex();
        }
    }
}
