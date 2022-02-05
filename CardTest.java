import cards.Card;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {

    /**
     * checks if the cardText parameter matches with expected cardText
     * e.g "10 of Hearts" == "10 of Hearts"
     */
    @Test
    public void testGet() {
        Card card = new Card("I don't know if this is right");
        Card card1 = new Card("Maybe this is working properly");
        Card card2 = new Card(card1.getCardText());
        Card card3 = new Card("10 of Hearts");

        assertEquals("I don't know if this is right", card.getCardText());
        assertEquals("Maybe this is working properly", card1.getCardText());
        assertEquals("Maybe this is working properly", card2.getCardText());
        assertEquals("10 of Hearts", card3.getCardText());
    }
}