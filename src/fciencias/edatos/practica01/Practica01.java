import java.util.Arrays;

/**
* Práctica 1 del curso de Estructuras de Datos.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602 
* @version 30 Septiembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Practica01{
	//Actividad 1
	/**
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArray(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");

		int[] result = new int[n + m];
		int pointer;
		for(pointer = 0; pointer < n; pointer++)
			result[pointer] = array1[pointer];
		for(int i = 0 ; i < m ; i++, pointer++)
			result[pointer] = array2[i];

		// Ordenamiento del arreglo result
		for(int j = 0; j < result.length - 1; j++){
			for(int k = j+1; k < result.length; k++){
				if(result[k] < result[j]){
					int aux = result[k];
					result[k] = result[j];
					result[j] = aux;
				}
			}
		}

		return result;
	}
	
	//Algoritmo de la actividad 1, mergeSortedArray pero mejorado en tiempo.
	/**
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArrayImproved(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");

		int[] result = new int[n + m];
		
		int i=0; //Iterador i será para el array1
		int j=0; //Iterador j será para el array2
		int k=0; //Iterador k será para el arreglo result
		
		while (i<n && j<m) {
			if (array1[i] < array2[j]) { //Si el elemento de array1 es menor que array2
				result[k] = array1[i];	//Copiamos el elemento de array1
				i++;					//Avanzamos una posicion en el array1
				
			} else {					//Si el elemento de array2 es menor que array1
				result[k] = array2[j]; //Copiamos el elemento de array2
				j++;				   //Avanzamos una posicion en el array2.
			}
			k++;                      //Avanzamos una posicion en el arreglo result.
		}
		//Cuando salimos del while es por que un arreglo ya sea el array1 o array2 se a 
		//copiado completamente, pero falta por copiarse elementos de algun arreglo aun.
		
		if (i==n) { //Significa que ya copiamos todos los elementos de array1, falta el array2.
			while (j<m) { //Mientras no hayamos terminado de copiar todos los elementos de array2.
				result[k] = array2[j]; //Copiamos el elemento de array2 en result.
				j++; //Avanzamos una posicion en array2
				k++; //Avanzamos una posicion en result.
			}
		} 
		else { //Entramos en la condicion que ya copiamos todo el array2, falta el array1.
			while (i<n) { //Mientras no hayamos terminado de copiar todos los elementos de array1.
				result[k] = array1[i]; //Copiamos el elemento de array1 en result.
				i++; //Avanzamos una posicion en array1.
				k++; //Avanzamos una posicion en result.
			}
		}	
		return result;
	}

	//Actividad 2
    /**
    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
    * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	* false en otro caso.
    */
    
	public static boolean isValidBoard(int[][] board){
    	int length = board.length;
		for (int i = 0; i < length ; i++) {
			for (int j = 0; j < length ; j++ ) {
				boolean verificador = false;
				// Verifica sobre las filas
				for(int k = 0 ; k < length; k++){
					if(board[i][k] == j){
						verificador = true;
						break;
					} 
				}
				if(!verificador){
					return false;
				}
				verificador = false;
				// Verifica sobre las columnas
				for(int k = 0 ; k < length; k++){
					if(board[k][i] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
			}
		}
		return true;
	}
	
	//Algoritmo de la actividad 2, isValidBoard pero mejorado en tiempo.
	/**
	    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
	    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
	    * @return verificador si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
		* false en otro caso.
	    */
	public static boolean isValidBoardImproved(int[][] board){
		
    	int length = board.length;     //Como la matriz es cuadrada no tenemos problema con la longitud.
    	int [] aux = new int [length]; //Usamos un arreglo auxiliar como contador de cada posicion.
    	int renglones=0, columnas=0;  //Guardamos los elementos de los renglones y columnas de las posiciones.
    	boolean verificador=true;     //Esto solo es para el return, ya que el metodo devuelve un boolean.
    	
		for (int i = 0; i < length ; i++) { //Asi recorremos el numero de renglones			
			for (int j = 0; j < length ; j++ ) { //Asi recorremos el numero de columnas.
				renglones = board[i][j];    //Guardamos el numero que esta en x posicion de los renglones.
				columnas = board[j][i];		//Guardamos el numero que esta en x posicion de las columnas.
				aux[renglones]++;		//"Contador", el numero que guardamos en renglones es la posicion del arreglo aux que va a aumentar en 1. 
				aux[columnas]++;  		//"Contador", el numero que guardamos en columnas es la posicion del arreglo aux que va a aumentar en 1.
				
			if (aux[renglones] >2 || aux[columnas] >2) {
				verificador = false;
				return verificador; //Si alguna posicion del arreglo tiene mas de 2 nos saca del for, ya que no tiene
			}
														//caso seguir recorriendo la matriz porque ya vimos que hay repetidos.
			if(j==length-1) aux = new int[length]; //Cuando acabamos de recorrer un renglon o una columna por completo, tenemos que quitar los 
			//contadores en las posiciones que ya teniamos y empezar todos desde cero, ya que recorreremos de nuevo un renglon y una columna.
			}		
		}	
		return verificador; //Si nunca hay repetidos regresa verdadero.
	}
		
	
	//Actividad 3
	/**
	* Rota position cantidad de veces los elementos de un arreglo
	* hacia el vecino izquierdo.
	* @param num el arreglo de enteros a rotar.
	* @param position la cantidad de espacios a rotar.
	*/
	public static void rotateArray(int[] num, int position){
		for(int i = 0; i < position ; i++){
			int aux = num[0];
			for(int j = 0; j < num.length -1 ; j++){
				num[j] = num[j+1];
			}
			num[num.length-1] = aux;
		}
	}

	public static void main(String[] args) {

		String directorio1 = "src/fciencias/edatos/practica01/Examples/ArrayExamples/";
		String directorio2 = "src/fciencias/edatos/practica01/Examples/BoardExamples/";

		// EJEMPLOS DE ACTIVIDAD 1
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 1\n");
		System.out.println("Algoritmo 1.");
	    long inicio = System.currentTimeMillis();

		int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] resultA = mergeSortedArray(arrayA1, 3, arrayA2, 5);
		System.out.println("Resultado A: "+Arrays.toString(resultA));

		int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] resultB = mergeSortedArray(arrayB1, 5, arrayB2, 5);
		System.out.println("Resultado B: "+Arrays.toString(resultB));

		int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");
		int[] resultC = mergeSortedArray(arrayC1, 4, arrayC2, 6);
		System.out.println("Resultado C: "+Arrays.toString(resultC));
		
		long fin = System.currentTimeMillis();
		System.out.println("El algoritmo 1 se tardó: "+ (fin - inicio) + " milisegundos.");
		
		System.out.println("\nAlgoritmo 2 (Mejora del algoritmo 1 en tiempo).");
		
		inicio = System.currentTimeMillis();

		int[] arrayA1_1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2_1 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] resultA_1 = mergeSortedArrayImproved(arrayA1_1, 3, arrayA2_1, 5);
		System.out.println("Resultado A: "+Arrays.toString(resultA_1));

		int[] arrayB1_1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2_1 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] resultB_1 = mergeSortedArrayImproved(arrayB1_1, 5, arrayB2_1, 5);
		System.out.println("Resultado B: "+Arrays.toString(resultB_1));

		int[] arrayC1_1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2_1 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");
		int[] resultC_1 = mergeSortedArrayImproved(arrayC1_1, 4, arrayC2_1, 6);
		System.out.println("Resultado C: "+Arrays.toString(resultC_1));
		
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 2 se tardó: "+ (fin - inicio) + " milisegundos.");


		// EJEMPLOS DE ACTIVIDAD 2
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 2\n");
		System.out.println("Algoritmo 1.");
		
		inicio = System.currentTimeMillis();
		
		int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
		boolean boardResultA = isValidBoard(boardA);
		System.out.println("El tablero A es válido: "+boardResultA);

		int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
		boolean boardResultB = isValidBoard(boardB);
		System.out.println("El tablero B es válido: "+boardResultB);

		int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
		boolean boardResultC = isValidBoard(boardC);
		System.out.println("El tablero C es válido: "+boardResultC);

		int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
		boolean boardResultD = isValidBoard(boardD);
		System.out.println("El tablero D es válido: "+boardResultD);
		
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 1 se tardó: "+ (fin - inicio) + " milisegundos.");
		
		System.out.println("\nAlgoritmo 2 (Mejora del algoritmo 1 en tiempo).");

		inicio = System.currentTimeMillis();
		
		int[][] boardA1 = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
		boolean boardResultA1 = isValidBoardImproved(boardA1);
		System.out.println("El tablero A es válido: "+boardResultA1);

		int[][] boardB1 = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
		boolean boardResultB1 = isValidBoardImproved(boardB1);
		System.out.println("El tablero B es válido: "+boardResultB1);

		int[][] boardC1 = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
		boolean boardResultC1 = isValidBoardImproved(boardC1);
		System.out.println("El tablero C es válido: "+boardResultC1);

		int[][] boardD1 = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
		boolean boardResultD1 = isValidBoardImproved(boardD1);
		System.out.println("El tablero D es válido: "+boardResultD1);
		
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 2 se tardó: "+ (fin - inicio) + " milisegundos.");

		// EJEMPLOS DE ACTIVIDAD 3
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 3\n");
		System.out.println("Algoritmo 1.");
		
		inicio = System.currentTimeMillis();

		rotateArray(arrayA1, 5);
		rotateArray(arrayB1, 0);
		rotateArray(arrayC1, 6);

		System.out.println("Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayA1));
		System.out.println("Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1));
		System.out.println("Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1));
		
		fin = System.currentTimeMillis();
		System.out.println("El algoritmo 1 se tardó: "+ (fin - inicio) + " milisegundos.");

		System.out.println("\n\nFIN DE EJEMPLOS\n");
	}
}
