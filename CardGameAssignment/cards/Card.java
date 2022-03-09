package cards;

public class Card {

    private String cardText;

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
    @Override
    public String toString(){
        return this.cardText;
    }
}
