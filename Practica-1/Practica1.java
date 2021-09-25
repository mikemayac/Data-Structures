/*Actividad 1 (2.5 puntos)
Dados dos arreglos ordenados de enteros, se mezcla de dos ambos arreglos desde la primera posición
hasta una posición lı́mite n y m para el arreglo A y el arreglo B respectivamente.
La mezcla da como resultado un arreglo ordenado de enteros de longitud n+m que contiene los
primeros n elementos del arreglo A y los primeros m elementos de arreglo B.
mergeSortedArray([13,29,58,58,74,90,91], 3, [3,11,13,16,27,56,59,61,88,90], 5) =
[3,11,13,13,16,27,29,58]
mergeSortedArray([1,24,49,51,63,79,99,107,107,126,128,149], 5, [26,54,68,97,103,107,
109,123,126,132,155,175,187,208,230], 5) = [1,24,26,49,51,54,63,68,97,103]
El siguiente algoritmo tiene complejidad O((n+m) 2 ). Mejora el método para que la complejidad
sea O(n+m).
*/

public class Practica1{

        public static int[] mergeSortedArray(int[] array1, int n,
                                        int[] array2, int m){
    if(n > array1.length || m > array2.length)
            throw new RuntimeException("Lı́mites no válidos");
                                        
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




public static void main(String[] args) {
        
}
