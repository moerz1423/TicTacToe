package at.fhtw;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private void playGame(Scanner scanner) {
        boolean gameWon = false;

        do {
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + "'s turn.");
            int x = -1, y = -1;

            // ... (existing code)

            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        } while (!board.isFull() && !gameWon);
    }
}

