package fciencias.edatos.practica02;
import java.util.Scanner;

/**
 * Clase para poner a prueba las operaciones de la lista.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de Datos 2022-1
 */
public class Practica02{

    public static void main(String[] args) {
        DoubleLinkedList<String> lista = new DoubleLinkedList();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("[1] Agrega\n"+
            "[2] LimpiarLisa\n"+
            "[3] ¿Está contenido?\n"+
            "[4] Obtener\n"+
            "[5] ¿Es vacía?\n"+
            "[6] Remover\n"+
            "[7] Longitud\n"+
            "[8] Reversa\n"+
            "[9] Corte\n"+
            "[10] Salir\n"+
            "Elige una opcion: ");

            int opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    int i = sc.nextInt();
                    sc.nextLine();
                    String s = sc.nextLine();
                    lista.add(i, s);
                    break;
                case 2:
                    System.out.println("La longitud es "+ lista.size());
                    break;
                case 3:
                    System.out.println(lista);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        } while(true);

    }
}
