package cards;

public class SetCard extends Card {

    private String shading;
    private String color;
    private String shape;
    private int number;

    //Default Constructor
    public SetCard(){

    }

    // Parameterized Constructor
    public SetCard(String shape, int number, String shading, String color){
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this. color = color;
    }

    /**
     *
     * @return the shape from the SetCard
     */
    public String getShape(){
       return this.shape;
    }

    /**
     *
     * @return the number from the SetCard
     */
    public int getNumber(){
        return this.number;
    }

    /**
     *
     * @return the shading from the SetCard
     */
    public String getShading(){
        return this.shading;
    }

    /**
     *
     * @return the color from the SetCard
     */
    public String getColor(){
        return this.color;
    }

    /**
     *
     * @return formatted version of what the SetCard would display
     */
    public String toString(){
        return shading + "-" + color + " " + shape +  " " + number;
    }




}
