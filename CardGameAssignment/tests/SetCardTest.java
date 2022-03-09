import cards.SetCard;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SetCardTest {

    /**
     * checks if the shape parameter matches with expected shape
     * e.g: "Shape" == "Shape"
     */
    @Test
    public void getShape() {
        SetCard setCard = new SetCard("Shape", 4, "Shading", "Color");
        assertEquals("Shape", setCard.getShape());
    }

    /**
     * checks if the number parameter matches with expected number
     * e.g: 4 == 4
     */
    @Test
    public void getNumber() {
        SetCard setCard = new SetCard("Shape", 4, "Shading", "Color");
        assertEquals(4, setCard.getNumber());
    }

    /**
     * checks if the shading parameter matches with expected shading
     * e.g: "Shading" == "Shading"
     */
    @Test
    public void getShading() {
        SetCard setCard = new SetCard("Shape", 4, "Shading", "Color");
        assertEquals("Shading", setCard.getShading());
    }

    /**
     * checks if the color parameter matches with expected color
     * e.g: "Color" == "Color"
     */
    @Test
    public void getColor() {
        SetCard setCard = new SetCard("Shape", 4, "Shading", "Color");
        assertEquals("Color", setCard.getColor());
    }
}