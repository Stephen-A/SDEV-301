package deck;
import cards.*;

public class StandardDeck extends Deck {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private static final String[] FACES = {"Jack", "Queen", "King", "Ace"};
    /**
     * creates a deck of cards with all 52 card
     */
    public StandardDeck(){
        for (String suit : SUITS) {
            for (int i = 2; i <= 10; i++) {
                addCard(new StandardCard(i+"",suit));
            }
            for (String face : FACES) {
                addCard(new StandardCard(face, suit));
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
