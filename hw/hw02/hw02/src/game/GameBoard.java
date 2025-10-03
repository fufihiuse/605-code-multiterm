package game;

import game.Dot;
import game.Lines;

/**
 * Class that stores information about the GameBoard
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class GameBoard {
    /**
     * Stores the number of rows and columns of boxes
     */
    private int rows, cols;
    /**
     * Stores all the dots on the board as [row, col]
     */
    private Dot[][] dots;
    /**
     * Stores all the lines on the board
     */
    private Lines lines;
    /**
     * Stores the all the boxes on the board as [row, col]
     */
    private Box[][] boxes;
    /**
     * Tracks if the game is still active
     */
    private boolean isGameOver;
    /** Tracks how many moves have been made */
    private int moves;

    /**
     * Creates an instance of the GameBoard
     * @param rows the number of rows for the board
     * @param cols the number of columns for the board
     */
    GameBoard(int rows, int cols) {
        isGameOver = false;
        moves = 0;

        this.rows = rows;
        this.cols = cols;

        // Setup empty dots, expanding by one dimension to make way for the boxes
        dots = new Dot[rows + 1][cols + 1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                dots[i][j] = new Dot(i, j);
            }
        }

        // Create lines
        lines = new Lines(rows, cols, dots);

        // Setup new empty board of boxes
        boxes = new Box[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boxes[i][j] = new Box(i, j, lines);
            }
        }
    }

    /**
     * Returns whether the game is over
     *
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver() {
        return isGameOver;
    }

    /**
     * Checks if a line is valid
     *
     * @param startRow the start row of the line
     * @param startCol the start column of the line
     * @param endRow   the end row of the line
     * @param endCol   the end column of the line
     * @return true if the line is valid, otherwise false
     */
    public boolean isLineValid(int startRow, int startCol, int endRow, int endCol) {
        // Check if coords are invalid
        if (startRow < 0 || startRow >= rows + 1
                || startCol < 0 || startCol >= cols + 1
                || endRow < 0 || endRow >= rows + 1
                || endCol < 0 || endCol >= cols + 1
                || (endRow <= startRow && endCol <= startCol)
        || (endRow == startRow + 1 && endCol == startCol + 1))
            return false;

        // Check if already claimed
        return !lines.getLine(startRow, startCol, endRow, endCol).hasOwner();
    }

    /**
     * Creates a line from the two dots
     *
     * @param player   the player making the move
     * @param startRow the start row of the line
     * @param startCol the start column of the line
     * @param endRow   the end row of the line
     * @param endCol   the end column of the line
     */
    public void makeMove(Player player, int startRow, int startCol, int endRow, int endCol) {
        // Determine if horizontal or vertical
        if (startRow == endRow) {
            // Correct for dots that are out of bounds
            if(startRow == rows) {
                boxes[startRow - 1][startCol].getBottomLine().claim(player);
            }
            else {
                boxes[startRow][startCol].getTopLine().claim(player);
            }
        } else if (startCol == endCol) {
            // Correct for dots that are out of bounds
            if(startCol == cols)
                boxes[startRow][startCol - 1].getRightLine().claim(player);
            else {
                boxes[startRow][startCol].getLeftLine().claim(player);
            }
        }
        moves++;
    }

    /**
     * Gets the current number of moves
     * @return the number of moves so far
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Prints the current state of the board
     */
    public void printBoard() {
        // Print grid numbers
        System.out.print("  ");
        for (int i = 0; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();


        for (int i = 0; i <= rows; i++) {
            // Print identifier
            System.out.print(i + " ");

            // Print dots and lines
            for (int j = 0; j < cols; j++) {
                System.out.print(dots[i][j].toString());
                System.out.print(lines.getLine(i, j, i, j + 1));
            }
            System.out.println(".");

            // Print vertical lines and boxes unless it's the last line
            if(i == rows)
                break;

            System.out.print("  ");
            for(int j = 0; j < cols; j++) {
                System.out.print(lines.getLine(i, j, i + 1, j));
                System.out.print(boxes[i][j].toString());
                if(j == cols - 1) {
                    System.out.print(lines.getLine(i, j + 1, i + 1, j + 1));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Gets the number of boxes claimed by player RED
     * @return the number of boxes RED has claimed
     */
    public int getPlayersBoxes(Player player) {
        // Loop through boxes, return how many are red

        /** Claimed boxes */
        int claimedBoxes = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(boxes[i][j].owner == player)
                    claimedBoxes++;
            }
        }
        return claimedBoxes;
    }

    /**
     * Gets the end goal for the game
     * @return the number of claimed boxes that signifies the end of the game
     */
    public int getGoal() {
        return rows * cols;
    }

    /**
     * Sets whether the game should end
     * @param isGameOver true if the game should end
     */
    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
