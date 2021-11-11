import java.util.Random;
import java.util.Scanner;

public class PlayerAction {


	/**
	 *
	 *  Obtiene un índice válido de una tarjeta que debe ser eliminada de computerDeck.
	 *  Nota: este método no comprueba que la entrada sea efectivamente un número entero 
	 *  y se bloqueará si se proporciona otra cosa.
	 * 
	 *  @return el input valido.
	 */
	public static int getValidInput( ){
		int sizeComputerDeck = Game.sizeComputerDeck();
		System.out.print("Tengo " + sizeComputerDeck + " cartas. Mi primer carta es la 1 y mi ultima carta es ");
		System.out.println(sizeComputerDeck + " , que carta vas a querer ?");
		System.out.println("Digita un entero entre 1 y " + sizeComputerDeck + ": ");
        Scanner sc = new Scanner(System.in);
		int position = sc.nextInt();
		sc.nextLine();

		while (!(position >= 1 && position <= sizeComputerDeck)) {
			System.out.println("Vuelve a introducir un número. Solo puedes introducir numeros enteros entre 1 y "
			+ sizeComputerDeck + ": ");
			position = sc.nextInt();
			sc.nextLine();
		}
		
		return position;
	}

    /**
	 *
	 *  Elimina todos los pares de cartas del array deckOfCards, que actualmente 
	 *  contiene las cartas de currentSize. deckOfCards no está ordenado. Tampoco 
	 * debería estar ordenado una vez que el método termine.
	 *
	 *   @param deckOfCards el arreglo de strings que representa la baraja de cartas
	 *   @param currentSize el número de strings en el arrayOfStrings, almacenado 
     *   desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1] 
	 *   @return el número de cartas en deckOfCards una vez que se retira el par
	 */
	public static int removePairs(String[] deckOfCards, int currentSize){
		String[] noPairs = new String[deckOfCards.length];
		int noPairsSize = 0;

		sortArray(deckOfCards, currentSize);

		int i = 0;
		while (i < currentSize - 1) {
			String card1 = deckOfCards[i];
			String card2 = deckOfCards[i + 1];
			if (card1.charAt(0) == card2.charAt(0) && card1.charAt(1) == card2.charAt(1)) { 
				i++;
			} else if (card1.charAt(0) == card2.charAt(0)) { 
				i++;
			} else {
				noPairsSize = appendItem(noPairs, noPairsSize, deckOfCards[i]);
			}
			i++;
		}

		if (i == currentSize - 1) {
			noPairsSize = appendItem(noPairs, noPairsSize, deckOfCards[i]);
		}

		shuffleArray(noPairs, noPairsSize);

                System.arraycopy(noPairs, 0, deckOfCards, 0, noPairs.length );

		return noPairsSize;
	}

	/** 
     * Hace una ordenación lexicográfica de arrayOfStrings. 
     * Simplemente se basa en el método sort(Object[])
	 * de java.util.Arrays. 
	 * Teniendo en cuenta que ordena en orden lexicográfico, por lo que 
	 * "10" está antes que "2", "A" está antes que "Q", etc. 
     * 
     *   @param arrayOfStrings el arreglo de strings
     *   @param currentSize el número de cadenas en el arrayOfStrings,
     * almacenado desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1] 
     */
    public static void sortArray(String[] arrayOfStrings, int currentSize){
        if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
	    System.out.println("ArrayStringsTools.sortArray: wrong call");
	    return ;
	}
	java.util.Arrays.sort(arrayOfStrings, 0, currentSize );
	}

    
    /** 
     * 
	 * Barajea aleatoriamente el arrayOfStrings
     * 
     *   @param arrayOfStrings el arreglo de strings
     *   @param currentSize el número de strings en el arrayOfStrings, almacenado 
     *   desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1]
     */
    public static void shuffleArray(String[] arrayOfStrings, int currentSize){
     
		
	Random generator = new Random();

	for(int i = currentSize-1 ; i > 1 ; i--){
	    swapItems(arrayOfStrings, i,generator.nextInt(i-1));
	}
    }

	/**
	 * Metodo auxiliar de shuffleArray que hace intercambios
	 */
    private static void swapItems(String[] arrayOfStrings, int i, int j){
        String intermediate = arrayOfStrings[i];
	arrayOfStrings[i]=arrayOfStrings[j];
	arrayOfStrings[j]=intermediate;
    }

    
    /** 
     * Método auxiliar
	 * Elimina la cadena en arrayOfStrings[itemToRemove] y
	 * 
     *   @param arrayOfStrings el arreglo de cadenas
     *   @param currentSize el número de cadenas en el arrayOfStrings, almacenado 
     *   desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1] 
     *   @param itemToRemove índice del elemento a eliminar de arrayOfStrings
     *   @return el nuevo tamaño del arrayOfStrings modificado
     */

    public static int removeItemByIndex(String[] arrayOfStrings, int currentSize, int itemToRemove){
		
		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			return currentSize;
		}
		if( itemToRemove < 0 || itemToRemove >= currentSize ) {
			return currentSize;
		}

        int i;
        for( i = itemToRemove; i < currentSize-1; i++){
            arrayOfStrings[i] = arrayOfStrings[i+1];
        }
        arrayOfStrings[i]= null;
        return currentSize-1;
        }

    
    /** 
     * Método auxiliar
     * Añade itemToAdd al final de arrayOfStrings 
     * 
     *   @param arrayOfStrings el arreglo de cadenas
     *   @param currentSize el número de cadenas en el arrayOfStrings, almacenado 
     *   desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1] 
     *   @param itemToAdd la cadena a añadir a arrayOfStrings
     *   @return el nuevo tamaño del arrayOfStrings modificado
     */

    public static int appendItem(String[] arrayOfStrings, int currentSize, String itemToAdd){

		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			return currentSize;
		}
	
		if( currentSize == arrayOfStrings.length) {
			return currentSize;
		}
	arrayOfStrings[currentSize++]=itemToAdd;
	return currentSize;
	} 	

    /** 
	 * 
	 * Imprime las cadenas contenidas en arrayOfStrings
     * 
     *   @param arrayOfStrings el arreglo de cadenas
     *   @param currentSize el número de cadenas en el arrayOfStrings, almacenado 
     *   desde arrayOfStrings[0] hasta arrayOfStrings[currentSize-1]
     */

    public static void printArray(String[] arrayOfStrings, int currentSize){
	for(int i = 0; i < currentSize-1; i++){
	    System.out.print(arrayOfStrings[i] + ", ");
        }
	System.out.println(arrayOfStrings[currentSize-1]);
	}
}

   


