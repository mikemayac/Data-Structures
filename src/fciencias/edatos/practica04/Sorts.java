package fciencias.edatos.practica04;

import java.util.Arrays;

import java.util.Random;
/**
 * Implementación de algunos algoritmos de ordenamiento.
 * @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
 * @version 12.0 Noviembre 2021.
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
    quickSort(arr,0,arr.length-1);
  }
  /**
  * Metodo privado quickSort
  * @param arr el arreglo a ordenar.
  * @param lo entero.
  * @param hi entero.
   */
   private static void quickSort(int[] arr, int lo, int hi){
		 if(hi<=lo){
			 return ;
		 }
    int j = partition(arr,lo,hi);
     quickSort(arr,lo,j);
     quickSort(arr,j+1,hi);
   }
   /**
   * Metodo privado quickSort
   * @param arr el arreglo a ordenar.
   * @param lo entero.
   * @param hi entero.
    */
   private static int partition(int[] arreglo, int lo, int hi){
    int i = lo;
    int j = hi;
    int piv = arreglo[lo];
		while (true) {
			while (arreglo[i] < piv) {
					i++;
			}
			while (arreglo[j] > piv) {
					j--;
			}
			if (i >= j) {
					return j;
			} else {
					swap(arreglo,i,j);
					i++;
					j--;
			}
	}
}


	/**
	 * Verifica si un elemento está contenido en un arreglo.
	 * @param arr el arreglo donde buscar.
	 * @param e el elemento a buscar.
	 */
	public static int contains(int[] arr, int e){
		return contains(arr, e, 0, arr.length-1);
	}

	private static int contains(int[] array, int elem, int lo, int hi){
		if(lo>hi)
			return -1;
		int mid = lo + ((hi-lo)/2);
		System.out.println(array[mid]);
		if(array[mid] == elem)
			return elem;

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
	public static int find(int[] arr, int e){
		return contains(arr, e, 0, arr.length-1);
	}

	/**
		 * Ordena un arreglo de forma ascendente con merge sort.
		 * @param arr el arreglo a ordenar.
		 */
		public static void mergeSort(int[] arr){
			mergeSort(arr, 0, arr.length-1);
		}

		/**
		 * Auxiliar de mergeSort para dividir y mezclar.
		 * @param arr el arreglo con los elementos a dividir y mezclar.
		 * @param lo el índice de inicio a modificación.
		 * @param hi el índice del último elemento a modificación.
		 */
		private static void mergeSort(int[] arr, int lo, int hi){
			// Cuando ya esta ordenado el fragmento de lo hasta hi
			if(hi <= lo)
				return;

			// La mitad del corte del arreglo
			int mid = lo + (hi-lo) / 2;

			mergeSort(arr, lo, mid);
			mergeSort(arr, mid+1, hi);
			merge(arr, lo, mid, hi);
		}

		/**
		 * Mezcla dos arreglos, ordenando de menor a mayor.
		 * @param arr el arreglo con los elementos a modificar.
		 * @param lo el inicio de la primera mitad.
		 * @param mid el índice de la mitad del subarreglo.
		 * @param hi el índice del último elemento.
		 */
		private static void merge(int[] arr, int lo, int mid, int hi){

			 // Crea
			 int n1 = mid - lo + 1;
			 int n2 = hi - mid;

			 /* arreglos auxiliares */
			 int array1[] = new int[n1];
			 int array2[] = new int[n2];

			 /*Copiando los elementos del arreglo a los auxiliares*/
			 for (int i = 0; i < n1; ++i)
					 array1[i] = arr[lo + i];
			 for (int j = 0; j < n2; ++j)
					 array2[j] = arr[mid + 1 + j];


			 int i = 0, j = 0;
			 int k = lo;
			 while (i<n1 && j<n2) {
	 			if (array1[i] < array2[j]) { //Si el elemento de array1 es menor que array2
	 				arr[k] = array1[i];	//Copiamos el elemento de array1
	 				i++;
					k++;					//Avanzamos una posicion en el array1

	 			} else {					//Si el elemento de array2 es menor que array1
	 				arr[k] = array2[j]; //Copiamos el elemento de array2
	 				j++;				   //Avanzamos una posicion en el array2.
	 			}
	 			k++;                      //Avanzamos una posicion en el arreglo result.
	 		}
	 		//Cuando salimos del while es por que un arreglo ya sea el array1 o array2 se a
	 		//copiado completamente, pero falta por copiarse elementos de algun arreglo aun.

	 			while (j<n2) { //Mientras no hayamos terminado de copiar todos los elementos de array2.
	 				arr[k] = array2[j]; //Copiamos el elemento de array2 en result.
	 				j++; //Avanzamos una posicion en array2
	 				k++; //Avanzamos una posicion en result.
	 			}

	 		//Entramos en la condicion que ya copiamos todo el array2, falta el array1.
	 			while (i<n1) { //Mientras no hayamos terminado de copiar todos los elementos de array1.
	 				arr[k] = array1[i]; //Copiamos el elemento de array1 en result.
	 				i++; //Avanzamos una posicion en array1.
	 				k++; //Avanzamos una posicion en result.
	 			}
		}
		/**
		 * Crea un nuevo arreglo con números pseudoaleatorios.
		 * @param n el tamaño del arreglo a crear.
		 * @param max el mayor elemento a generar en el arreglo.
		 * @return un arreglo de tamaño n con números pseudoaleatorios de 0 a 19.
		 */
		public static int[] generate(int n, int max){
			int[] res = new int[n];
			Random rn = new Random();
			for(int i = 0 ; i < n; i++)
				res[i] = rn.nextInt(max);
			return res;
		}

		public static void main(String[] args) {
			int[] arr1 = generate(100, 99);
			int [] arr2 =  {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58
				,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,
				8,7,6,5,4,3,2,1};
			int [] arr3 =  {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58
				,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,
				8,7,6,5,4,3,2,1};
			//System.out.println("No ordenado: " + Arrays.toString(arr1));

			long inicio = System.currentTimeMillis();
			quickSort(arr1);
			System.out.println("Despues de QS: " + Arrays.toString(arr1));

			long fin = System.currentTimeMillis();

			System.out.println("Ordenado con quickSort tardó: " + (fin - inicio) + " milisegundos");



			inicio = System.currentTimeMillis();
		mergeSort(arr2);
				System.out.println("Despues de MS: " + Arrays.toString(arr2));
			fin = System.currentTimeMillis();

			System.out.println("Ordenado con mergeSort tardó: " + (fin - inicio) + " milisegundos");


			//System.out.println("No ordenado: " + Arrays.toString(arr3));
			inicio = System.currentTimeMillis();
			quickSort(arr3);
		   find(arr3,1);
			 	System.out.println("Después de find: " + find(arr3,23)+"");
			fin = System.currentTimeMillis();
			//System.out.println("Ordenado: " + Arrays.toString(arr3));
			System.out.println("Ordenado con  find tardó: " + (fin - inicio) + " milisegundos");
		}
}
