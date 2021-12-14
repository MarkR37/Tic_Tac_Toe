import java.util.Arrays;
import java.util.Scanner;

public class runGame {

    public static final char SPACE = '-';
    private final char[][] board = new char[3][3];
    private final Scanner scanner = new Scanner(System.in);
    private String winner;
    private String userInput;
    private String currentPlayer = "";
    private int numTurns = 0;

    private static final String INSTRUCTIONS = """
            Welcome to Tic Tac Toe
            Player 1 is Circle, Player 2 is X
            Player 1 chooses first
            In order to answer, you need to use numbers for the position in terms of x and y.
            Example: 00 is top left, 02 is top right, 01 is top middle
            Good luck! 
            
            
            """;

    private void initBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, SPACE);
        }
    }

    private void printBoard() {
        System.out.println("\n  0 1 2");
        char y = '0';
        for (char[] chars : board) {
            System.out.print(y + " ");
            y++;
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println(" ");
        }
    }

    private void updateBoard() {
        int x = userInput.charAt(0) - 48; //returns 0 of player 1
        int y = userInput.charAt(1) - 48; //returns 1
        if (board[x][y] == 'X' || board[x][y] == '0') {
            System.out.println("Already Chosen, please try again: ");
            userInput = scanner.next();
            updateBoard();
        } else if (currentPlayer.equals("Player 1")) {
            board[x][y] = '0';
        } else {
            board[x][y] = 'X';
        }
    }

    private boolean userWon(char x) {
        return (board[0][0] == x && board[0][1] == x && board[0][2] == x) ||
                (board[1][0] == x && board[1][1] == x && board[1][2] == x) ||
                (board[2][0] == x && board[2][1] == x && board[2][2] == x) ||
                (board[0][0] == x && board[1][0] == x && board[2][0] == x) ||
                (board[0][1] == x && board[1][1] == x && board[2][1] == x) ||
                (board[0][2] == x && board[1][2] == x && board[2][2] == x) ||
                (board[0][0] == x && board[1][1] == x && board[2][2] == x) ||
                (board[0][2] == x && board[1][1] == x && board[2][0] == x);
    }

    private void startGame() {
        System.out.println(INSTRUCTIONS);
        initBoard();
        printBoard();
        currentPlayer = "Player 1";
        while (true) {
            System.out.println(currentPlayer + ": ");
            userInput = scanner.next();
            updateBoard();
            printBoard();
            numTurns++;
            if (currentPlayer.equals("Player 1") && userWon('0')) {
                winner = "Player 1";
                break;
            } else if (currentPlayer.equals("Player 2") && userWon('X')) {
                winner = "Player 2";
                break;
            }
            if (numTurns == 9) {
                winner = "tie";
                break;
            }
            if (currentPlayer.equals("Player 1")) {
                currentPlayer = "Player 2";
            } else {
                currentPlayer = "Player 1";
            }
        }
    }

    private void endGame() {
        if(winner.equals("tie")) {
            System.out.println("You both Tied!");
        } else {System.out.println(winner + " won");}
    }

    public static void main(String[] args) {
        runGame game = new runGame();
        game.startGame();
        game.endGame();
    }
}
