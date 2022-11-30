package org.example.cli;

import java.util.Scanner;

public class MenuCreateImage {

    public void showMenu(){

        System.out.println("\n### Crear Imagen ###\n\n");
        System.out.println("1. Crear imagen pixbit.\n");
        System.out.println("2. Crear imagen pixrgb.\n");
        System.out.println("3. Crear imagen pixhex.\n");

        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean error = false;

        do {
            error = false;
            System.out.println("Ingrese el tipo de imagen que desea crear: ");
            String line = sc.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opcion valida.");
                error = true;
            }
            if (!error && (option > 3 || option < 1)) {
                System.out.println("Debe ingresar una opcion valida.");
                error = true;
            }
        } while (error) ;

        if (option == 1){
            MenuPixbit menuPixbit = new MenuPixbit();
            menuPixbit.showMenuPixbit();
        } else if (option == 2) {

        }else{

        }

    }
}
