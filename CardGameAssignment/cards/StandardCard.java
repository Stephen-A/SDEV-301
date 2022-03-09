package cards;

public class StandardCard extends Card {

    private String rank;
    private String suit;

    public StandardCard(String rank, String suit){
        super(rank + " of " + suit);
        this.rank = rank;
        this.suit = suit;
    }

    /**
     *
     * @return rank of the StandardCard
     */
    public String getRank(){
        return rank;
    }

    /**
     *
     * @return suit of the StandardCard
     */
    public String getSuit(){
        return suit;
    }

    /**
     *
     * @return formatted version of what the StandardCard would display
     */
    public String toString(){
        return getCardText();
    }
}
