package deck;
import cards.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> dealerPile = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();

    public Deck(){
    }

    /**
     * Simply adds one at least one card into the dealerPile
     * @param card created in the StandardDeck class
     */
    public void addCard(Card card){
        dealerPile.add(card);
    }

    /**
     * Adds all the cards from the discardPile to the dealerPile and uses the Collections class to randomly sort the dealerPile
     */
    public void shuffle(){
        dealerPile.addAll(discardPile);
        dealerPile.removeAll(discardPile);
        Collections.shuffle(dealerPile);
    }

    /**
     * This method adds the top card of the dealerPile to the discardPile and also removes it from the dealerPile
     * @return the card that was taken from the top of the dealerPile
     */
    public Card dealTopCard(){
        discardPile.add(dealerPile.get(dealerPile.size() - 1));
        dealerPile.remove(dealerPile.size() - 1);
        return discardPile.get(discardPile.size() -1);
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
        return build();
    }

    /**
     *
     * @return formatted version of the deck - removes unnecessary comma and brackets
     */
    private String build() {
        StringBuilder formattedDeck = new StringBuilder();

        formattedDeck.append(cardCount()).append(" cards in the deck\n");
        formattedDeck.append("*******************\n");

        //prints out the list of cards
        for (Card card : dealerPile){
            formattedDeck.append(card.toString());
        }

        formattedDeck.append("\n").append(discardPile.size()).append(" cards in discard");
        formattedDeck.append("\n*******************");
        return formattedDeck.toString();
    }
}
