import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        playGame(game);
    }

    private static void playGame(TicTacToe game) {
        Scanner scanner = new Scanner(System.in);

        while (!game.checkWin() && !game.isBoardFull()) {
            System.out.println("Current board:");
            game.printBoard();

            int row = -1, col = -1; // Initialize with default values

            try {
                do {
                    System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row and column, separated by space): ");
                    row = getInput("Enter the row: ", scanner);
                    col = getInput("Enter the column: ", scanner);

                    if (!isValidMove(row, col)) {
                        System.out.println("Invalid move. Please enter a valid move within the board.");
                    } else if (!game.makeMove(row, col)) {
                        System.out.println("Invalid move. The cell is already occupied.");
                    }
                } while (!isValidMove(row, col));
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers for row and column.");
                scanner.nextLine(); // clear the invalid input
            }

            System.out.println("\n---------------------------------\n");
        }

        System.out.println("Final board:");
        game.printBoard();

        if (game.checkWin()) {
            char winner = (game.getCurrentPlayer() == 'X') ? 'O' : 'X';
            System.out.println("Player " + winner + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    private static int getInput(String prompt, Scanner scanner) {
        int input;

        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                break; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for row and column.");
            }
        }

        return input;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}
