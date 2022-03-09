package deck;

import cards.Card;
import java.util.*;

public class Deck {

    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;
    private static final int STAR_SIZE = 18;

    public Deck(){
        dealerPile = new ArrayList<>();
        discardPile = new ArrayList<>();
    }

    /**
     * Simply adds one at least one card into the dealerPile
     * @param card created in the StandardDeck class
     */
    public void addCard(Card card){
        if (card != null){
            dealerPile.add(card);
        }
    }

    /**
     * Adds all the cards from the discardPile to the dealerPile and uses the Collections class to randomly sort the dealerPile
     */
    public void shuffle(){
        dealerPile.addAll(discardPile);
        discardPile.clear();
        Collections.shuffle(dealerPile);
    }

    /**
     * This method adds the top card of the dealerPile to the discardPile and also removes it from the dealerPile
     * @return the card that was taken from the top of the dealerPile
     */
    public Card dealTopCard(){
        if (cardCount() > 0){
            Card removed = dealerPile.remove(0);
            discardPile.add(removed);
            return removed;
        }
        return new Card("");
    }

    /**
     *
     * @return the size of the dealerPile
     */
    public int cardCount(){
        return dealerPile.size();
    }

    /**
     * Overrides the built-in ToString() method with the build() method below.
     * @return build method that incorporates the StringBuilder class
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        getCards(result, dealerPile, "deck");

        result.append("\n");

        getCards(result, discardPile, "discard");
        return result.toString();
    }

    /**
     *
     * @return formatted version of the deck - removes unnecessary comma and brackets
     */
    private void getCards(StringBuilder result, ArrayList<Card> deck, String text) {
        result.append(deck.size() + " cards in " + text + "\n");
        result.append("*".repeat(STAR_SIZE) + "\n");

        for(Card c : deck) {
            result.append(c + "\n");
        }
    }
}
