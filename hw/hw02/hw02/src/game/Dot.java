package game;

/**
 * Represents the individual dots in the game board
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Dot {
    /** The position of the dot */
    private int row, col;

    /**
     * The constructor for a Dot
     * @param row non-negative integer representing the dot's horizontal position
     * @param col non-negative integer representing the dot's vertical position
     */
    public Dot(int row, int col) {
        // Ensure row is a positive integer
        assert row >= 0 && col >= 0;

        this.row = row;
        this.col = col;
    }

    /**
     * Gets the row of the dot
     * @return the dot's row
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the dot
     * @return the dot's column
     */
    public int getColumn() {
        return col;
    }

    @Override
    public String toString() {
        return ".";
    }

    /**
     * Overrides the equals operator to determine if two objects are the same
     * @param other the object to compare
     * @return whether the two objects are the same dot
     */
    public boolean equals(Object other) {
        if(!(other instanceof Dot))
            return false;

        /** The dot to compare to */
        Dot compDot = (Dot) other;
        return this.row == compDot.row && this.col == compDot.col;
    }
}
