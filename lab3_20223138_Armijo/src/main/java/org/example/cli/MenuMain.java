package org.example.cli;

import java.util.Scanner;

public class MenuMain {

    public void showMenu(){

        System.out.println("### Manipulador de imagenes ###\n\n");
        System.out.println("Escoja su opcion:\n");
        System.out.println("1. Crear una imagen\n");
        System.out.println("2. Modificar imagen\n");
        System.out.println("3. Visualizar imagen\n");

        Scanner sc = new Scanner(System.in);
        boolean error = false;
        int option = 0;

        do {
            error = false;
            System.out.println("INTRODUZCA SU OPCION: ");
            String line = sc.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opción válida.");
                error = true;
            }
            if (!error && (option > 3 || option < 1)){
                System.out.println("Debe ingresar una opción válida");
                error = true;
            }
        } while(error);

        if(option == 1){

            MenuCreateImage menuCreateImage = new MenuCreateImage();
            menuCreateImage.showMenu();

        }

    }

}
