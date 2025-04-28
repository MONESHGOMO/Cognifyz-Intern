import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        char[][] gameBoard = new char[3][3];

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                gameBoard[row][col] = ' ';
            }
        }

        char currentPlayer = 'X';
        boolean isGameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            printBoard(gameBoard);
            System.out.print("Player " + currentPlayer + ", enter row and column (0, 1, 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (gameBoard[row][col] == ' ') {
                gameBoard[row][col] = currentPlayer;
                isGameOver = checkWinner(gameBoard, currentPlayer);
                if (isGameOver) {
                    System.out.println("Player " + currentPlayer + " has won!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Cell already taken. Try again!");
            }
        }
        printBoard(gameBoard);
    }

    public static boolean checkWinner(char[][] gameBoard, char player) {
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0] == player && gameBoard[row][1] == player && gameBoard[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col] == player && gameBoard[1][col] == player && gameBoard[2][col] == player) {
                return true;
            }
        }

        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }

        if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] gameBoard) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.print(gameBoard[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
