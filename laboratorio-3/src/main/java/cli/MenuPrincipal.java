package cli;

import java.util.Scanner;

public class MenuPrincipal {

    public void mostrar(){
        int opcion = 0;
        System.out.println("### Manipulador de imagenes ###\n");
        System.out.println("-------------------------------\n");
        System.out.println("- Ingrese una opcion:\n");
        System.out.println("Crear una imagen. ");
        Scanner lectorTeclado = new Scanner(System.in);
        boolean hayError = false;
        do {
            hayError = false;
            String line = lectorTeclado.nextLine();
            try {
                opcion = Integer.parseInt(line);
            }
            catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es válido, debe ser un número mayor o igual 0");
                hayError = true;
            }

        } while (hayError);
        switch (opcion){
            case 1:

                break;
        }
    }
}
