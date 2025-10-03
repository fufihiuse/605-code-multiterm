package game;

import game.Dot;

/**
 * Tracks the lines drawn in the game
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Lines {
    /**
     * Stores the rows and columns of the dots array
     */
    int horizLineCount, vertLineCount;
    /** Stores the horizontal and vertical lines */
    Line[][] horizLines, vertLines;

    /**
     * Creates an object to manage the lines
     *
     * @param rows the number of rows
     * @param cols the number of cols
     * @param dots a 2D array of Dots
     */
    public Lines(int rows, int cols, Dot[][] dots) {
        assert rows > 0 && cols > 0;

        /* Calculate number rows and columns for lines
         * Each row and column can only connect on two axis
         */
        int vertLineCount, horizLineCount;

        vertLineCount = rows * (cols + 1); // For vertical
        horizLineCount = cols * (rows + 1); // For horizontal


        this.vertLineCount = vertLineCount;
        this.horizLineCount = horizLineCount;

        // Allows us to just put in position of first dot for each to determine if there's a line
        vertLines = new Line[rows][vertLineCount / rows];
        horizLines = new Line[horizLineCount / cols][cols];

        // Create vertical lines
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < vertLineCount / rows; j++) {
                vertLines[i][j] = new Line(dots[i][j], dots[i + 1][j]);
            }
        }

        // Create horizontal lines
        for (int i = 0; i < horizLineCount / cols; i++) {
            for (int j = 0; j < cols; j++) {
                horizLines[i][j] = new Line(dots[i][j], dots[i][j + 1]);
            }
        }
    }

    /**
     * Returns the size of the line array
     *
     * @return the line array's size
     */
    public int size() {
        return vertLineCount +  horizLineCount;
    }

    /**
     * Gives a line at a given position
     *
     * @param startRow the beginning row position of the line
     * @param startCol the beginning column position of the line
     * @param endRow   the ending row position of the line
     * @param endCol   the ending column position of the line
     * @return the line between start and end
     */
    public Line getLine(int startRow, int startCol, int endRow, int endCol) {
        // Check if vertical or horizontal
        if(startRow == endRow && startCol < endCol) {
            return horizLines[startRow][startCol];
        }
        else if (startRow < endRow && startCol == endCol) {
            return vertLines[startRow][startCol];
        }
        return null;
    }
}
