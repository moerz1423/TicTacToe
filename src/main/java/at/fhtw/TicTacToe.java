package at.fhtw;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame(scanner);

            System.out.print("Do you want to play again? (Y/N): ");
            char playAgain = scanner.next().charAt(0);

            if (playAgain == 'Y' || playAgain == 'y') {
                board.clear();
                currentPlayer = player1;
            } else {
                break;
            }
        } while (true);

        scanner.close();
    }
    private void playGame(Scanner scanner) {
        boolean gameWon = false;

        do {
            //board.print();
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
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}

