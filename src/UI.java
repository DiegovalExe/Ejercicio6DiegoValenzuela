import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);

    /**
     * Menu principal
     * @return opcion del usuario ingresada
     */
    public static int initial(){

        System.out.println("----BIENVENIDO A SU IPOD----");
        System.out.println("");
        System.out.println("----Ingrese el numero de la opcion a realizar----");
        System.out.println("");
        System.out.println("1. Encender/Apagar");
        System.out.println("2. Bloquear/Desbloquear");
        System.out.println("3. Subir volumen");
        System.out.println("4. Bajar volumen");
        System.out.println("5. Siguiente cancion");
        System.out.println("6. Anterior cancion");
        System.out.println("7. Agegar favoritas");
        System.out.println("8. Ir a alguna favorita");
        System.out.println("9. Mostrar estado");
        return sc.nextInt();
    }

    /**
     * Error 1
     */
    public static void err1(){
        System.out.println("OPCION INCORRECTA");
    }

    /**
     * Error 2
     */
    public static void err2(){
        System.out.println("Dispositivo apagado, enciendalo para continuar");
    }

    /**
     * Error 3
     */
    public static void err3(){
        System.out.println("Dispositivo bloqueado o apagado, desbloquelo o enciendalo para continuar");
    }

    /**
     * Obtiene la cancion a reproducir
     * @return Opcion ingresada
     */
    public static int requestFavoriteSong(){
        System.out.println("Ingrese el inidide de la cancion favorita a reproducir");
        return sc.nextInt();
    }
}
