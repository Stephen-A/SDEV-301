package cards;

import deck.Deck;

public class Card extends Deck {

    private String cardText;

    // Default Constructor
    public Card(){
    }

    // Parameterized constructor
    public Card(String cardText){
        this.cardText = cardText;
    }

    /**
     *
     * @return the text of the Card
     */
    public String getCardText(){
        return this.cardText;
    }

    /**
     *
     * @return the text of the Card
     */
    public String toString(){
        return this.cardText;
    }
}
