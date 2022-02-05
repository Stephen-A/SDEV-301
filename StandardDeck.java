package deck;
import cards.*;

public class StandardDeck extends Deck {

    /**
     * creates a deck of cards with all 52 card
     */
    public StandardDeck(){
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};
        for (String value : rank) {
            for (String s : suit) {
                addCard(new StandardCard(value, s));
            }
        }
    }

    /**
     * Overrides the dealTopCard() method in the Deck class and casts it to a StandardCard instead of a Card,
     * and calls the dealTopCard() method from the parent Deck class
     * @return a cast version of the card returned from the dealTopCard() method in the Deck class
     */
    @Override
    public StandardCard dealTopCard(){
       return (StandardCard) super.dealTopCard();
    }
}
