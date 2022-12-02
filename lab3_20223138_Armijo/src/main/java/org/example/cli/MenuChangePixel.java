package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuChangePixel {

    public MenuChangePixel(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    private Image_20223138_ArmijoPalominos image;

    public void showMenuChangePixel(){

        System.out.println("## IMAGE CHANGE PIXEL ##");
        System.out.println("1) Pixbit");
        System.out.println("2) Pixmap");
        System.out.println("3) Pixhex");

        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean error;

        do {
            error = false;
            System.out.println("Introduzca una opcion: ");
            String line = sc.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                error = true;
            }
            if(!error && (option > 3 || option < 1)){
                System.out.println("Debe ingresar una opcion valida");
                error = true;
            }
        } while (error);

        if(option==1){
            MenuChangePixbit menuChangePixbit = new MenuChangePixbit(this.image);
            menuChangePixbit.showMenuChangePixel();
        }else if(option == 2){
            MenuChangePixmap menuChangePixmap = new MenuChangePixmap(this.image);
            menuChangePixmap.showMenuChangePixmap();
        }else{
            MenuChangePixhex menuChangePixhex = new MenuChangePixhex(this.image);
            menuChangePixhex.showMenuChangePixhex();
        }
    }


}
