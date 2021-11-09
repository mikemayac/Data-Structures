package fciencias.edatos.practica04;

import java.util.Arrays;


/**
 * Implementación de algunos algoritmos de ordenamiento.
 * @author Emmanuel Cruz Hernández.
 * @version 2.0 Octubre 2021.
 * @since Estructuras de datos 2022-1.
 */
public class Sorts{

	/**
	 * Cambia de posición dos elementos entre sí de un arreglo de enteros.
	 * @param arr el arreglo del cual cambiar la posición de los elementos.
	 * @param i el índice del primer elemento a cambiar.
	 * @param j el índice del segundo elemento a cambiar.
	 */
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
  /**
  * Metodo publico quickSort
  * @param arr el arreglo a ordenar.
   */
  public static void quickSort(int[]arr){
    quickSort(arr,0,arr.length -1);
  }
  /**
  * Metodo privado quickSort
  * @param arr el arreglo a ordenar.
  * @param lo entero.
  * @param hi entero.
   */
   private static void quickSort(int[] arr, int lo, int hi){
    int j = quicksort(arr,lo,hi);
     quickSort(arr,lo,j-1);
     quickSort(arr,j+1,hi);
   }
   /**
   * Metodo privado quickSort
   * @param arr el arreglo a ordenar.
   * @param lo entero.
   * @param hi entero.
    */
   private static int quicksort(int[] arr, int lo, int hi){
    int i = lo;
    int j = hi+1;
    int piv = arr[lo];
    while(true){
      while(arr[i++]<piv){
        if(i==hi) break;
      }
      while(piv<arr[j--]){
        if(j==lo) break;
      }
      if(i>=j) break;
    }
    swap(arr,i,j);
    swap(arr,lo,j);
    return j;
   }


	/**
	 * Verifica si un elemento está contenido en un arreglo.
	 * @param arr el arreglo donde buscar.
	 * @param e el elemento a buscar.
	 */
	public static boolean contains(int[] arr, int e){
		return contains(arr, e, 0, arr.length-1);
	}

	private static boolean contains(int[] array, int elem, int lo, int hi){
		if(lo>hi)
			return false;
		int mid = lo + ((hi-lo)/2);
		System.out.println(array[mid]);
		if(array[mid] == elem)
			return true;

		if(array[mid] > elem)
			return contains(array, elem, lo, mid-1);
		else
			return contains(array, elem, mid+1, hi);
	}

	/**
	 * Regresa la posición de un elemento en un arreglo.
	 * @param arr el arreglo donde buscar.
	 * @param e el elemento a buscar.
	 */
	public int find(int[] arr, int e){
		return 0;
	}


}
