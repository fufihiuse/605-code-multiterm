package game;

/**
 * Stores drawn boxes
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Box {
    /**
     * The box's owner
     */
    Player owner;

    /**
     * The lines that makeup the box
     */
    Line top, bottom, left, right;

    /**
     * Tracks the position of the Box
     */
    int row, col;


    /**
     * Creates a Box object
     * @param row the row this box resides in
     * @param col the column this box resides in
     * @param lines the lines that make up this box
     */
    public Box(int row, int col, Lines lines) {
        this.row = row;
        this.col = col;
        this.owner = Player.NONE;

        this.top = lines.getLine(row, col, row, col + 1);
        this.bottom = lines.getLine(row + 1, col, row + 1, col + 1);
        this.left = lines.getLine(row, col, row + 1, col);
        this.right = lines.getLine(row, col + 1, row + 1, col + 1);

        // Tell the lines they belong to this box
        this.top.addParentBox(this);
        this.bottom.addParentBox(this);
        this.left.addParentBox(this);
        this.right.addParentBox(this);
    }

    /**
     * Gets the top line
     *
     * @return the top line
     */
    public Line getTopLine() {
        return top;
    }

    /**
     * Gets the bottom line
     *
     * @return the bottom line
     */
    public Line getBottomLine() {
        return bottom;
    }

    /**
     * Gets the left line
     *
     * @return the left line
     */
    public Line getLeftLine() {
        return left;
    }

    /**
     * Gets the left line
     *
     * @return the left line
     */
    public Line getRightLine() {
        return right;
    }

    /**
     * Gets the owner of the box
     *
     * @return the box's owner
     */
    public Player getOwner() {
        if (owner != Player.NONE)
            return owner;

        return Player.NONE;
    }

    /**
     * Assigns an owner to the box
     *
     * @param player the box's new owner
     */
    public void claim(Player player) {
        // Make sure that the box is fully drawn, and that the player has claimed at least one line
        if ((top.hasOwner() &&
                bottom.hasOwner() &&
                left.hasOwner() &&
                right.hasOwner() &&
                (top.getOwner() == player || bottom.getOwner() == player ||
                        left.getOwner() == player || right.getOwner() == player)
        )) {
            this.owner = player;
        }
    }

    /**
     * Gets the row position of the box
     *
     * @return the box's row position
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column position of the box
     *
     * @return the box's column position
     */
    public int getColumn() {
        return col;
    }

    /**
     * Compares whether two boxes are the same
     *
     * @param other the reference object with which to compare.
     */
    public boolean equals(Object other) {
        // Make sure other is a Box
        if (!(other instanceof Box)) {
            return false;
        }

        Box otherBox = (Box) other;
        return (this.top.equals(otherBox.getTopLine()) &&
                this.bottom.equals(otherBox.getBottomLine()) &&
                this.left.equals(otherBox.getLeftLine()) &&
                this.right.equals(otherBox.getRightLine()));
    }

    /**
     * Returns the box as a String
     * @return " " if no owner, otherwise "R" for RED, and "B" for BLUE
     */
    public String toString() {
        if (this.owner == Player.NONE)
            return " ";
        return this.owner == Player.RED ? "R" : "B";
    }
}
