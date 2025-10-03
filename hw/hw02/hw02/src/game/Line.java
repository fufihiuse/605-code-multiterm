package game;

import game.Dot;
import game.Player;
import game.Box;

/**
 * Represents the drawn lines in the game
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Line {
    /** The range the line spans */
    private Dot first, second;

    /** The owner of the line */
    private Player owner;

    /** Whether the line is vertical or horizontal */
    private boolean isVertical;

    /** An array of boxes this line belongs to */
    private Box[] parentBoxes;
    /** The number of boxes this line belongs to */
    private int parentBoxCount;

    /**
     * Creates a Line
     * @param first the first dot the line connects to
     * @param second the second dot the line connects to
     */
    public Line(Dot first, Dot second) {
        // Ensure that the line is assigned in the proper order
        assert (first.getRow() < second.getRow() && first.getColumn() <= second.getColumn()
        || first.getRow() <= second.getRow() && first.getColumn() < second.getColumn());

        // Check whether vertical or horizontal
        isVertical = first.getRow() < second.getRow() && first.getColumn() == second.getColumn();

        // Set the line position
        this.first = first;
        this.second = second;

        // Make the dot ownerless
        this.owner = Player.NONE;

        // Create the empty boxes array (each line can belong to at MOST three boxes)
        parentBoxes = new Box[3];
        parentBoxCount = 0;
    }

    /**
     * Gets the starting dot for the line
     * @return the starting dot of the line
     */
    public Dot getFirst() {
        return first;
    }

    /**
     * Gets the ending dot for the line
     * @return the ending dot of the line
     */
    public Dot getSecond() {
        return second;
    }

    /**
     * Gets whether the dot has an owner
     * @return whether the dot has an owner
     */
    public boolean hasOwner() {
        return owner != Player.NONE;
    }

    /**
     * Gives the owner of the line
     * @return the line's owner
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Assigns an owner to the dot
     * @param owner the player who claims a line
     */
    public void claim(Player owner) {
        // Make sure there's no current owner of the line
        if(this.owner != Player.NONE)
            return;
        // Assign a new owner
        this.owner = owner;

        // See if any parent boxes can be claimed
        for(int i = 0; i < parentBoxCount; i++)
        {
            parentBoxes[i].claim(owner);
        }
    }

    /**
     * Stringifies the line
     * @return "-" if horizontal, "|" if vertical, and " " if unowned
     */
    @Override
    public String toString() {
        if(owner == Player.NONE)
            return " ";
        return isVertical ? "|" : "-";
    }

    /**
     * Compares whether two objects are the same line
     * @param other the reference object with which to compare.
     * @return true if the two objects are the same Line, otherwise false
     */
    public boolean equals(Object other) {
        if( !(other instanceof Line) ) {
            return false;
        }

        /** Temporary line used for comparison */
        Line compLine = (Line) other;

        return compLine.getFirst().equals(this.first) && compLine.getSecond().equals(this.second);
    }

    /**
     * Adds a box as a parent to this line
     * @param box the box to make a parent
     */
    public void addParentBox(Box box) {
        parentBoxes[parentBoxCount++] = box;
    }

    /**
     * Gets the number of boxes this line appears in
     * @return the number of boxes this line is a member of
     */
    public int getParentBoxCount() {
        return parentBoxCount;
    }
}
