package at.fhtw;
import java.util.InputMismatchException;
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
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + "'s turn.");
            int x = -1, y = -1;

            try {
                while (true) {
                    System.out.print("Enter row (0-2): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid number for the row.");
                        scanner.nextLine(); // Clear the input buffer
                    } else {
                        x = scanner.nextInt();
                        if (x < 0 || x > 2) {
                            System.out.println("Invalid input. Row must be between 0 and 2. Please enter again.");
                        } else {
                            break; // Valid input, exit the loop
                        }
                    }
                }

                while (true) {
                    System.out.print("Enter column (0-2): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid number for the column.");
                        scanner.nextLine(); // Clear the input buffer
                    } else {
                        y = scanner.nextInt();
                        if (y < 0 || y > 2) {
                            System.out.println("Invalid input. Column must be between 0 and 2. Please enter again.");
                        } else {
                            break; // Valid input, exit the loop
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
                continue; // Restart the loop
            }

            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());

            } else {
                System.out.println("Invalid move. Please try again.");
            }

        } while (!board.isFull() && !gameWon);

        board.print();

        if (gameWon) {
            System.out.println("Player " + (currentPlayer == player1 ? player2 : player1).getMarker() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}

