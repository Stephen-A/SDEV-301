package cards;

public class StandardCard extends Card {

    private String rank;
    private String suit;

    // Default Constructor
    public StandardCard(){
    }

    // Parameterized Constructor
    public StandardCard(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     *
     * @return rank of the StandardCard
     */
    public String getRank(){
        return this.rank;
    }

    /**
     *
     * @return suit of the StandardCard
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     *
     * @return formatted version of what the StandardCard would display
     */
    public String toString(){
        return rank + " of " + suit + "\n";
    }

}
