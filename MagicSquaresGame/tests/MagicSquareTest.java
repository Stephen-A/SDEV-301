import com.sun.jdi.ByteValue;
import ms.MagicSquare;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MagicSquareTest {

    private static final byte[] selections = {2, 7, 6, 9, 5, 1, 4, 3, 8};
    private static final short[] CHOICES = {0b0_0000_0010, //2
                                            0b0_0100_0010, //7
                                            0b0_0110_0010, //6
                                            0b1_0110_0010, //9
                                            0b1_0111_0010, //5
                                            0b1_0111_0011, //1
                                            0b1_0111_1011, //4
                                            0b1_0111_1111, //3
                                            0b1_1111_1111};//8

    // TODO: add a testGetChoices() method
    @Test
    public void testGetChoices() {
        MagicSquare sq = new MagicSquare(selections);
        for (int i = 0; i < selections.length; i++) {
            sq.choose(selections[i]);
            assertEquals(CHOICES[i], sq.getChoices());
        }
    }

    // TODO: add a testGetSquare() method
    @Test
    public void testGetSquare() {
        MagicSquare sq = new MagicSquare(selections);
        System.out.println((Arrays.toString(selections)));   // Print the selections array
        System.out.println(Arrays.toString(sq.getSquare())); // Print the getSquare.toString() array
        assertArrayEquals(selections, sq.getSquare());
    }

    // TODO: Add a testHasAlreadyChosen() method
    @Test
    public void testHasAlreadyChosen(){
        MagicSquare sq = new MagicSquare(selections);
        for (byte selection : selections) {
            sq.choose(selection);
            assertTrue(sq.hasAlreadyChosen(selection));
        }
    }


    @Test
    public void testPrintChoicesEmptySquare() {
        MagicSquare ms = new MagicSquare(selections);

        // redirect output from console window into a PrintStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // invoke toString() which now prints to the PrintStream instead of the console window
        System.out.println(ms);

        String expectedConsoleOutput = "_ _ _ "+ System.lineSeparator()+"_ _ _ "+System.lineSeparator()+"_ _ _ "+System.lineSeparator();
        assertEquals("print choices incorrect output", expectedConsoleOutput, out.toString());

    }

    @Test
    public void testChoose() {
        MagicSquare sq = new MagicSquare(selections);

        // for every selection choice in values array
        for (int i = 0; i < selections.length; i++) {

            // choose num
            sq.choose((byte) selections[i]);

            // verify that getChoices returns proper cummulative selections
            assertEquals("choice was noted incorrectly", CHOICES[i], sq.getChoices());
        }
    }



    @Test(expected = IllegalArgumentException.class)
    public void testInvalidChoice() {
        MagicSquare ms = new MagicSquare(selections);
        ms.choose((byte) -7);
        ms.choose((byte) 0);
        ms.choose((byte) 10);
    }

    @Test
    public void testPrintChoicesFullSquare() {
        MagicSquare ms = new MagicSquare(selections);

        // choose every selection in the values array
        for (byte selection : selections) {
            ms.choose((byte) selection);
        }

        // redirect output from console window into a PrintStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // invoke toString() which now prints to the PrintStream instead of the console window
        System.out.println(ms);

        String expectedConsoleOutput = "2 7 6 "+
                System.lineSeparator()+"9 5 1 "+
                System.lineSeparator()+"4 3 8 "+
                System.lineSeparator();

        assertEquals("print choices incorrect output", expectedConsoleOutput, out.toString());

    }
}
