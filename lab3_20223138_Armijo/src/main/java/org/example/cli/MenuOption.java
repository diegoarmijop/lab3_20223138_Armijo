package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuOption {

    private Image_20223138_ArmijoPalominos image;

    public MenuOption(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    public void showMenuOption(){

        Scanner sc = new Scanner(System.in);

        System.out.println("## Manipulador de imágenes ##");
        System.out.println("1) Visualizar imagen.");
        System.out.println("2) Ver tipo de imagen.");
        System.out.println("3) ¿Imagen comprimida?");
        System.out.println("4) Modificar imagen.");
        System.out.println("5) Crear nueva imagen.");
        System.out.println("6) Salir.");

        int option = 0;
        boolean error;

        do {
            error = false;
            System.out.println("Introduzca su opcion: ");
            String line = sc.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opción válida.");
                error = true;
            }
            if (!error && (option < 1 || option > 5)) {
                System.out.println("Debe ingresar una opción válida");
                error = true;
            }
        } while (error) ;

        if(option == 1){
            System.out.println(this.image.toString());
        }
        else if(option == 2){
            MenuTypeImage menuTypeImage = new MenuTypeImage(this.image);
            menuTypeImage.showMenuTypeImage();
        } else if(option == 3){
            System.out.println(this.image.isCompressed());
        } else if(option == 4){
            MenuModify menuModify = new MenuModify(this.image);
            menuModify.showMenuModify();
        }



    }





}

