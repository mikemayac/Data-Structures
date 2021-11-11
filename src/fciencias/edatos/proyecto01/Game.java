package fciencias.edatos.proyecto01;
import java.util.Scanner;
import java.util.Random;
/**
* Proyecto 01 del curso de Estructuras de Datos.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
* @version 11 Noviembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/

public class Game {


	static int sizeComputerDeck ;
	DoubleLinkedList<String>  historial = new DoubleLinkedList<>();
    /**
	 *
	 *  Metodo de la implementacion del juego
	 */
	public  void playGame(){
		Deck deck = new Deck();
		PlayerAction.shuffleArray( deck.getDeck(), deck.getSizeDeck());
		deck.dealCards();
		System.out.println("Hola! Vamos a jugar old maid.");
		System.out.println("Soy el robot y yo voy a repartir");
		System.out.println("Tu deck actual de cartas es: ");
	        System.out.println("");
		String s = ""+PlayerAction.printArray(deck.getPlayerDeck(), deck.getSizePlayerDeck())+"";
	        System.out.println("");
					historial.add(0,s);
		System.out.println("Por cierto, como robot no puedo ver las cartas.");

		System.out.println("Se van a descartar todos los pares de tu deck. Yo haré lo mismo.");
        sizeComputerDeck = deck.getSizeComputerDeck();
		sizeComputerDeck = PlayerAction.removePairs(deck.getComputerDeck(), deck.getSizeComputerDeck());

		 int sizePlayerDeck = deck.getSizePlayerDeck();
         sizePlayerDeck =  PlayerAction.removePairs(deck.getPlayerDeck(), deck.getSizePlayerDeck());

		int roundParity = 0;
		while (sizeComputerDeck > 0 && sizePlayerDeck > 0) {
			if (roundParity == 0) {
				System.out.println("***********************************************************");
				System.out.println("Tu turno.");
				System.out.println("\nTu deck actual de cartas es: ");
				System.out.println("");

				String k = ""+PlayerAction.printArray(deck.getPlayerDeck(), sizePlayerDeck)+"";

				System.out.println("");
				historial.add(0,k);
				int card_position = PlayerAction.getValidInput();


                String [] computerDeck = deck.getComputerDeck();
				String item =  computerDeck[card_position - 1];
				sizeComputerDeck = PlayerAction.removeItemByIndex(deck.getComputerDeck(), sizeComputerDeck, card_position - 1); //this is valid since cards are unique

				System.out.println("Pediste mi carta " + card_position);

				System.out.println("Aqui esta es el " + item);

				sizePlayerDeck = PlayerAction.appendItem(deck.getPlayerDeck(), sizePlayerDeck, item);
				System.out.println("\nCon " + item + " añadido, a tu deck actual de cartas es: ");
				System.out.println("");
				PlayerAction.printArray(deck.getPlayerDeck(), sizePlayerDeck);
				System.out.println("");
				System.out.println("Después de descartar los pares y barajar, tu mazo es:");
				sizePlayerDeck = PlayerAction.removePairs(deck.getPlayerDeck(), sizePlayerDeck);
				System.out.println("");
				PlayerAction.printArray(deck.getPlayerDeck(), sizePlayerDeck);
				System.out.println("");
				roundParity = 1;
                                System.out.println("Preciona ENTER para continuar.");
	                        Scanner scanner = new Scanner(System.in);
                            scanner.nextLine();

			} else {
				System.out.println("***********************************************************");
				System.out.println("Mi turno.\n");

                Random generator = new Random();
				int cardIndex = generator.nextInt(sizePlayerDeck);
                String [] playerDeck = deck.getPlayerDeck();
				String item = playerDeck[cardIndex];
				sizePlayerDeck = PlayerAction.removeItemByIndex(deck.getPlayerDeck(), sizePlayerDeck, cardIndex);
				sizeComputerDeck = PlayerAction.appendItem(deck.getComputerDeck(), sizeComputerDeck, item);
				sizeComputerDeck = PlayerAction.removePairs(deck.getComputerDeck(), sizeComputerDeck);


				System.out.println("Tomé tu carta en la posición " + (cardIndex + 1) );

				roundParity = 0;
                                System.out.println("Presiona ENTER para continuar.");
                                Scanner scanner = new Scanner(System.in);
                                scanner.nextLine();
			}
		}

		if (sizeComputerDeck == 0) {
			System.out.println("***********************************************************");
			System.out.println("Lo lamento, ya no tengo mas cartas en mi mazo.");
			System.out.println("Tu pierdes, yo la computadora gano.");
			for(int i = 0; i< historial.size(); i++){

					System.out.println("Tu mano número "+i+" en orden descendente fue " + historial.get(i).toString()+".");
			}
		} else {
			System.out.println("***********************************************************");
			System.out.println("Ya no tienes mas cartas en tu mazo");
			System.out.println("Felicidades, haz ganado");

			for(int i = 0; i< historial.size(); i++){

				  System.out.println("Tu mano número "+i+ " en orden descendente fue " + historial.get(i).toString()+".");
			}
		}
}


		public static  int sizeComputerDeck(){
			return sizeComputerDeck;
		}



public static void main(String[] args){
    System.out.println("Inicio del juego old maid.");
    System.out.println("");
    Game game = new Game();
    game.playGame();
    System.out.println("");

}
}
