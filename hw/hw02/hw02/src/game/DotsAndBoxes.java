package game;

import java.util.Scanner;

/**
 * The main class used to play the Dots and Boxes game
 *
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class DotsAndBoxes {
    /**
     * The game's board
     */
    private GameBoard gameBoard;
    /**
     * The current player
     */
    private Player currentPlayer;
    /**
     * The Red and Blue players scores, as well as what the score was last
     */
    private int redScore, blueScore, prevScore;

    /** Used to get user input */
    Scanner scanner;

    /**
     * Creates an instance of the Dots and Boxes games
     * @param rows the number of rows of boxes
     * @param cols the number of cols of boxes
     */
    public DotsAndBoxes(int rows, int cols) {
        gameBoard = new GameBoard(rows, cols);
        currentPlayer = Player.RED;
        redScore = 0;
        blueScore = 0;
        prevScore = 0;
        scanner = new Scanner(System.in);
    }


    /**
     * Used by the player to make a move
     * with input coming in as "startRow startCol endRow endCol"
     */
    public void makeMove() {
        /** Loop until input is valid*/
        boolean isValidMove = false;
        do {
            // Prompt for move
            System.out.print("> ");

            /** User's input */
            String input = scanner.nextLine();

            // Check if valid
            /** Temp string array used to convert to integer array */
            String[] moveString = input.split(" ");

            // if q, quit
            if (moveString[0].equals("q")) {
                System.exit(0);
            }

            // Check if valid
            if(moveString.length != 4) {
                System.out.println("Invalid line!");
                continue;
            }

            /** Array that holds the user input */
            int[] move = new int[4];

            for (int i = 0; i < 4; i++) {
                move[i] = Integer.parseInt(moveString[i]);
            }

            if (!gameBoard.isLineValid(move[0], move[1], move[2], move[3])) {
                System.out.println("Invalid line!");
                continue;
            }
            isValidMove = true;

            gameBoard.makeMove(currentPlayer, move[0], move[1], move[2], move[3]);

            // Check if any boxes have been claimed
            if(currentPlayer == Player.RED) {
                prevScore = redScore;
                redScore = gameBoard.getPlayersBoxes(currentPlayer);
            }
            else if (currentPlayer == Player.BLUE) {
                prevScore = blueScore;
                blueScore = gameBoard.getPlayersBoxes(currentPlayer);
            }

        } while (!isValidMove);

        // Switch players
        if((currentPlayer == Player.RED && prevScore == redScore)
                || (currentPlayer == Player.BLUE && prevScore == blueScore)) {
            currentPlayer = currentPlayer == Player.RED ? Player.BLUE : Player.RED;
        }

        // Check if game is over
        if(redScore + blueScore == gameBoard.getGoal())
            gameBoard.setGameOver(true);
    }

    /**
     * Prints the current state of the game
     */
    void printGame() {
        gameBoard.printBoard();
        System.out.println("Turn: " + currentPlayer
                + ", Red: " + redScore
                + ", Blue: " + blueScore
                + " , Moves: " + gameBoard.getMoves());
    }

    /**
     * The main gameplay loop
     */
    void play() {
        // Enter the main game loop
        while(!gameBoard.gameOver()) {
            printGame();
            System.out.println("\n" + currentPlayer.toString() + "'s move...");
            makeMove();
        }
        // Print game over string
        gameBoard.printBoard();
        if(redScore == blueScore) {
            System.out.println("TIE game " + redScore + " to " + blueScore + "!");
        }
        else if(redScore < blueScore) {
            System.out.println("BLUE wins " + blueScore + " to " + redScore + "!");
        }
        else {
            System.out.println("RED wins " + redScore + " to " + blueScore + "!");
        }
    }

    /**
     * The main method, where the game is played
     *
     * @param args the rows and columns
     */
    public static void main(String[] args) {
        // Verify the correct amount of arguments
        if (args.length != 2) {
            System.out.println("Usage: java DotsAndBoxes rows columns");
            return;
        }

        // Get rows and columns from args
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);

        DotsAndBoxes dotsAndBoxes = new DotsAndBoxes(rows, cols);
        dotsAndBoxes.play();
    }
}
