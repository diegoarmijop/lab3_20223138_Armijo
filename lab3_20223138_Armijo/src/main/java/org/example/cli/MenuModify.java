package org.example.cli;

import org.example.models.Image_20223138_ArmijoPalominos;

import java.util.Scanner;

public class MenuModify {

    private Image_20223138_ArmijoPalominos image;

    public MenuModify(Image_20223138_ArmijoPalominos image) {
        this.image = image;
    }

    public void showMenuModify(){

        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean error;

        System.out.println("## Manipulador de imágenes ##");
        System.out.println("1) flipH.");
        System.out.println("2) flipV.");
        System.out.println("3) crop.");
        System.out.println("4) imgRGBToHex.");
        System.out.println("5) image histogram.");
        System.out.println("6) rotate90.");
        System.out.println("7) changePixel.");
        System.out.println("8) invertColorBit.");
        System.out.println("9) invertColorRGB.");
        System.out.println("10) Volver.");


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
            if (!error && (option < 1 || option > 10)) {
                System.out.println("Debe ingresar una opción válida");
                error = true;
            }
        } while (error) ;

        if(option == 1){
            System.out.println(this.image.toString());
            System.out.println(this.image.flipH());
            System.out.println(this.image.toString());
        } else if(option == 2){
            System.out.println(this.image.toString());
            System.out.println(this.image.flipV());
            System.out.println(this.image.toString());
        } else if(option == 3){
            MenuCrop menuCrop = new MenuCrop(this.image);
            menuCrop.showMenuCrop();
        } else if(option == 4){
            System.out.println(this.image.toString());
            System.out.println(this.image.imgRGBToHex());
            System.out.println(this.image.toString());
        }else if (option == 5){
            System.out.println(this.image.histogram());
        } else if (option == 6){
            System.out.println(this.image.toString());
            System.out.println(this.image.rotate90());
            System.out.println(this.image.toString());
        }else if(option == 7){
            MenuChangePixel menuChangePixel = new MenuChangePixel(this.image);
            menuChangePixel.showMenuChangePixel();
        } else if(option == 8){
            System.out.println(this.image.toString());
            System.out.println(this.image.invertColorBit());
            System.out.println(this.image.toString());
        }else if(option == 9){
            System.out.println(this.image.toString());
            System.out.println(this.image.invertColorRGB());
            System.out.println(this.image.toString());
        }
        else{
            MenuOption newMenuOption = new MenuOption(this.image);
            newMenuOption.showMenuOption();
        }
    }
}
