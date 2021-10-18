package fciencias.edatos.practica02;
import java.util.Scanner;

/**
* Práctica 2 del curso de Estructuras de Datos.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
* @version 17 Octubre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/

public class Practica02{

    public static void main(String[] args) {
        DoubleLinkedList<String> lista = new DoubleLinkedList();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println(
            "[1] Agrega una cadena a la lista\n"+
            "[2] Elimina una cadena a la lista\n"+
            "[3] Limpia la lista\n"+
            "[4] ¿El elemento a introducir está contenido?\n"+
            "[5] Obtener un elemento de la lista\n"+
            "[6] ¿Es vacía la lista?\n"+
            "[7] Obtener la longitud de la lista\n"+
            "[8] Obtener la reversa de la lista\n"+
            "[9] Cortar la lista\n"+
            "[10] Mostrar la lista\n"+
            "[11] Salir del menu\n"+
            "Elige una opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("En que posición quieres agregar tu cadena? ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa la cadena que quieras agregar: ");
                    String s = sc.nextLine();
                    lista.add(i, s);
                    break;
                case 2:
                    System.out.println("Elimina el elemento del indice: ");
                    int indice = sc.nextInt();
                    lista.remove(indice);
                    break;
                case 3:
                    lista.clear();
                    break;
                case 4:
                    System.out.println("Introduce el elemento que quieres saber si esta en la lista: ");
                    String contain = sc.nextLine();
                    System.out.println(lista.contains(contain));
                    break;
                case 5:
                    System.out.println("Ingresa la posicion del elemento que quieras obtener: ");
                    int posicion = sc.nextInt();
                    lista.get(posicion);
                    break;
                case 6:
                    lista.isEmpty();
                    break;
                case 7:
                    System.out.println("La longitud es "+ lista.size());
                    break;
                case 8:
                    System.out.println("La reversa de la lista es: " + lista.revert());
                    break;
                case 9:
                    break;
                case 10:
                    System.out.println(lista.toString());
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(true);

    }
}
