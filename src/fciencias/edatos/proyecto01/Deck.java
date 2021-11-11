package fciencias.edatos.proyecto01;
/**
* Proyecto 01 del curso de Estructuras de Datos.
* @author Francisco Javier Becerril Lara No Cuenta 317114490 y Joel Miguel Maya Castrejón 417112602
* @version 11 Noviembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Deck {

    /**
     * Arreglo donde vamos a almacenar el deck completo de cartas (52-1 = 51 cartas)
     */
    private String[] deck;

    /**
     * Nos dice el numero actual de cartas que hay en el deck.
     */
    private int sizeDeck;

    /**
     * Arreglo donde vamos a almacenar el deck de las cartas del jugador.
     */
    private String[] playerDeck;

    /**
     * El numero actual de cartas en el deck del jugador.
     */
    private int sizePlayerDeck;

    /**
     * Arreglo donde vamos a alamcenar el deck de las cartas de la maquina.
     */
    private String[] computerDeck;

    /**
     * El numero actual de cartas en el deck de la computadora
     */
    private int sizeComputerDeck;

    public Deck() {

        // Info de la baraja en https://en.wikipedia.org/wiki/Clubs_(suit)

        // Unicode Character Suits
        String spades = "\u2660";
        String hearts = "\u2661";
        String diamons = "\u2662";
        String clubs = "\u2663";
        // Unicode Character Ranks
        String jack = "J";
        String queen = "Q";
        String king = "K";
        String ace = "A";
        String two = "2";
        String three = "3";
        String four = "4";
        String five = "5";
        String six = "6";
        String seven = "7";
        String eight = "8";
        String nine = "9";
        String teen = "10";

        // Suits
        String[] suits = { spades, hearts, diamons, clubs };
        // Ranks
        String[] ranks = { two, three, four, five, six, seven, eight, nine, teen, jack, queen, king, ace };

        // Vamos a tener 52 cartas en la baraja menos una, osea 51 cartas.
        sizeDeck = suits.length * ranks.length - 1;

        // Creamos el deck con 51 cartas.
        this.deck = new String[sizeDeck];

        int counter = 0;

        // Concatenamos las 51 cartas, suits + ranks para que tengan forma las cartas.
        // La condición es para que no concatene un suit + rank si no serian 52 cartas.
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                if (!(ranks[i] == ace && suits[j] == clubs)) {
                    this.deck[counter++] = ranks[i] + " " + suits[j];
                }
            }
        }
    }

    /**
     *
     * @return Nos dice el numero actual de cartas que hay en el deck.
     */
    public int getSizeDeck() {
        return this.sizeDeck;
    }

    /**
     *
     * @return
     */
    public String[] getComputerDeck() {
        return this.computerDeck;
    }

    /**
     * @return Regresa el deck completo de cartas.
     */
    public String[] getDeck() {
        return this.deck;
    }

    /**
     *
     * @return el deck del jugador
     */
    public String[] getPlayerDeck() {
        return this.playerDeck;
    }

    /**
     *
     * @return el tamaño del deck del jugador
     */
    public int getSizePlayerDeck() {
        return this.sizePlayerDeck;
    }

    /**
     * Reparte las cartas, sacando las cartas de sizeDeck del mazo, y las reparte en
     * playerDeck y computerDeck, empezando por playerDeck
     */
    public void dealCards() {
        // Deck del jugador y de la maquina.
        playerDeck = new String[sizeDeck];
        computerDeck = new String[sizeDeck];

        String item;

        while (sizeDeck > 1) {
            item = deck[sizeDeck - 1];
            sizeDeck = PlayerAction.removeItemByIndex(deck, sizeDeck, sizeDeck - 1);
            sizePlayerDeck = PlayerAction.appendItem(playerDeck, sizePlayerDeck, item);

            item = deck[sizeDeck - 1];
            sizeDeck = PlayerAction.removeItemByIndex(deck, sizeDeck, sizeDeck - 1);
            sizeComputerDeck = PlayerAction.appendItem(computerDeck, sizeComputerDeck, item);
        }



        // Reparte la última carta restante
        item = deck[sizeDeck - 1];
        sizeDeck = PlayerAction.removeItemByIndex(deck, sizeDeck, sizeDeck - 1);
        sizePlayerDeck = PlayerAction.appendItem(playerDeck, sizePlayerDeck, item);

    }

    /**
     *
     * @return Nos dice el numero actual de cartas que hay en el deck de la
     *         computadora.
     */
    public int getSizeComputerDeck() {
        return sizeComputerDeck;
    }

}
