package ms;

public class MagicSquare {

    // Initialized at 0. Updates each bit as the program takes new parameters.
    private short choices;
    // Array of numbers that represent the Magic Square
    private byte[] square = {2, 7, 6,
                             9, 5, 1,
                             4, 3, 8};

    // Default Constructor
    public MagicSquare() {
    }

    // Parameterized Constructor
    public MagicSquare(byte[] square) {
        this.square = square; // {2, 7, 6, 9, 5, 1, 4, 3, 8};
    }

    /**
     * Takes in an input number from user. Checks if it is between 1 and 9 AND if that number
     * has already been chosen. Throws IllegalArgumentException if number is out of scope.
     *
     * @param selection user input for a number
     * @return TRUE if number is between 1 and 9 AND has not been chosen previously
     * FALSE if the number is greater than 9 or less than 1 AND has been chosen previously
     */
    public boolean choose(byte selection) {
        // If the selection is less than 1 or greater than 9
        if (selection < 1 || selection > 9) {
            throw new IllegalArgumentException(selection + " is not between 1 and 9");
        }
        // if the selection has already been made, return false
        if (hasAlreadyChosen(selection)) {
            return false;
            // Otherwise, give choices the value of choices | mask
            // and return true
        } else {
            short mask = (short) (1 << selection - 1);
            choices = (short) (choices | mask);
            return true;
        }
    }

    /**
     * This method accepts the user selection as a parameter and creates a mask
     * that bit shifts over 1 from selection - 1
     * @param selection user input from MagicSquaresGame
     * @return TRUE if choices (user selections) & mask are equal to the mask created
     *         FALSE if choices & mask are not equal to the mask created
     */
    public boolean hasAlreadyChosen(byte selection) {
        // mask = bit index of selection -1
        short mask = (short) (1 << selection - 1);
        return (choices & mask) == mask;
    }

    /**
     *
     * @return choices from user as bit values
     */
    public short getChoices() {
        return choices;
    }

    /**
     *
     * @return array of numbers initialized
     */
    public byte[] getSquare() {
        return square;
    }

    /**
     *
     * @return build() Stringbuilder
     */
    @Override
    public String toString() {
        return build();
    }

    /**
     *
     * @return formatted MagicSquares string that either places an
     * underscore ("_ ")
     * or the number chosen from the user
     */
    public String build() {

        StringBuilder build = new StringBuilder();

        for (int i = 0; i < square.length; i++) {
            if (i == 3 || i == 6) {
                build.append("\n");
            }
            if(hasAlreadyChosen(square[i])) {
                build.append(square[i]).append(" ");
            } else {
                build.append("_ ");
            }
        }
        return build.toString();
    }
}