import cards.StandardCard;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StandardCardTest {

    /**
     * loops through the array to compare each value using the getRank() method
     */
    @Test
    public void getRank() {

        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        // Not required to compare the suit so leave blank
        for (String s : rank) {
            StandardCard standardCard = new StandardCard(s, "");
            assertEquals(s, standardCard.getRank());
        }
    }

    /**
     * loops through the array to compare each value using the getSuit() method
     */
    @Test
    public void getSuit() {

        String[] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};
        // Not required to compare the rank so leave blank
        for (String s : suit) {
            StandardCard standardCard = new StandardCard("", s);
            assertEquals(s, standardCard.getSuit());
        }
    }
}
