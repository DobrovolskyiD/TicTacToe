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

            int row, col;
            do {
                System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row and column, separated by space): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!game.makeMove(row, col));

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
}
