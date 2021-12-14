import java.util.Arrays;
import java.util.Scanner;

public class runGame {

    public static final char SPACE = '-';
    private final char[][] board = new char[3][3];
    private final Scanner userInput = new Scanner(System.in);
    private String winner;
    private String takeUserInput;
    private String wonOrTie;
    private String Player1 = "Not Playing";
    private String Player2 = "Not Playing";
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
        if (Player1.equals("Playing") || Player2.equals("Playing")) {
            int x = takeUserInput.charAt(0) - 48; //returns 0 of player 1
            int y = takeUserInput.charAt(1) - 48; //returns 1
            if (board[x][y] == 'X' || board[x][y] == '0') {
                System.out.println("Already Chosen, please try again: ");
                takeUserInput = userInput.next();
                updateBoard();
            }
            if(Player1.equals("Playing")) {
                if (board[x][y] == SPACE) {
                    board[x][y] = '0';
                }
            }
            if(Player2.equals("Playing")) {
                if(board[x][y] == SPACE) {
                    board[x][y] = 'X';
                }
            }
        }
    }

    private void setPlayer() {
        System.out.println("Please Choose player 1(0) or 2(X) by typing 1 or 2: ");
        int z = userInput.nextInt();
        if(z < 1 || z > 2) { //Checking to see if the user selected any other number other than 1 or 2
            setPlayer();
        }
    }

    private String userWon(char x) {
        if(board[0][0] == x && board[0][1] == x && board[0][2] == x) {
            return "won";
        }
        if(board[1][0] == x && board[1][1] == x && board[1][2] == x) {
            return "won";
        }
        if(board[2][0] == x && board[2][1] == x && board[2][2] == x) {
            return "won";
        }
        if(board[0][0] == x && board[1][0] == x && board[2][0] == x) {
            return "won";
        }
        if(board[0][1] == x && board[1][1] == x && board[2][1] == x) {
            return "won";
        }
        if(board[0][2] == x && board[1][2] == x && board[2][2] == x) {
            return "won";
        }
        if(board[0][0] == x && board[1][1] == x && board[2][2] == x) {
            return "won";
        }
        if(board[0][2] == x && board[1][1] == x && board[2][0] == x) {
            return "won";
        }
        return "";
    }

    private void playingStatus(String doesP1, String doesP2) {
        if(doesP1.equals("Playing")) {
            System.out.println("Player 1: ");
        }
        if(doesP2.equals("Playing")) {
            System.out.println("Player 2: ");
        }
        takeUserInput = userInput.next();
        updateBoard();
        Player1 = "Not Playing";
        Player2 = "Not Playing";
        printBoard();
        numTurns++;
    }

    private void startGame() {
        System.out.println(INSTRUCTIONS);
        setPlayer();
        initBoard();
        printBoard();
        while(true) {
            Player1 = "Playing";
            playingStatus(Player1, Player2);
            wonOrTie = userWon('0');
            if(wonOrTie.equals("won")){
                winner = "Player 1";
                break;
            }
            if(numTurns == 9) {
                wonOrTie = "tie";
                break;
            }
            Player2 = "Playing";
            playingStatus(Player1, Player2);
            wonOrTie = userWon('X');
            if(wonOrTie.equals("won")){
                winner = "Player 2";
                break;
            }
            if(numTurns == 9) {
                wonOrTie = "tie";
                break;
            }
            printBoard(); 
        }
    }

    private void endGame() {
        if(wonOrTie.equals("tie")) {
            System.out.println("You both Tied!");
        } else {System.out.println(winner + " won");}
    }

    public static void main(String[] args) {
        runGame game = new runGame();
        game.startGame();
        game.endGame();
    }
}
