import java.util.Scanner;

public class UI {

    public static int initial(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----BIENVENIDO A SU IPOD----");
        System.out.println("");
        System.out.println("----Ingrese el numeor de la opcion a realizar----");
        System.out.println("");
        System.out.println("1. Encender/Apagar");
        System.out.println("2. Bloquear/Desbloquear");
        System.out.println("3. Subir volumen");
        System.out.println("4. Bajar volumen");
        System.out.println("5. Siguente cancion");
        System.out.println("6. Anterior cancion");
        System.out.println("7. Agegar favoritas");
        System.out.println("8. Ir a alguna favorita");
        System.out.println("9. Mostrar estado");
        return sc.nextInt();
    }
}
