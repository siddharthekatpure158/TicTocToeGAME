import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe.......");
        char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

        char player = 'X';
        int moves = 0;
        boolean flag = false;

        while (true) {
            System.out.println("    1    2    3");
            for (int i = 0; i < board.length; i++) {
                System.out.println("-----------------");
                System.out.print((i + 1) + " ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print("| " + board[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("-----------------");

            System.out.println("Player " + player + " is playing......");
            System.out.println("Enter row num");
            int row = obj.nextInt();
            if (row <= 0 || row > 3) {
                System.out.println("Invalid row num:");
                continue;
            }

            System.out.println("Enter col num");
            int col = obj.nextInt();
            if (col <= 0 || col > 3) {
                System.out.println("Invalid col num:");
                continue;
            }

            if (board[row - 1][col - 1] != ' ') {
                System.out.println("Space Occupied");
                continue;
            }

            board[row - 1][col - 1] = player;
            moves++;

            // check rows and columns
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                    System.out.println("Player " + player + " Wins");
                    flag = true;
                    break;
                }
            }

            // check diagonals
            if (!flag) {
                if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
                    System.out.println("Player " + player + " Wins");
                    flag = true;
                }
            }

            if (flag) {
                break;
            }

            if (moves == 9) {
                System.out.println("Match Draw............");
                break;
            }

            player = (player == 'X' ? 'O' : 'X');
        }
    }
}