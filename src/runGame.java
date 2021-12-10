//What this game needs to do:
//        tic tac toe
//        draw the board
//        assign 1 player to circle and 1 player to X's
//        create an array list that saves the positions of what the user picks
//        change the board to represent an (letters so char)O/X if the User picks it
//        every turn check if the user gets one of the 8 possible solution's
//        Print out who won.
import java.util.Scanner;

public class runGame {

    public static final char SPACE = '-';
    private char[][] board = new char[3][3];
    private String user1;
    private String user2;
    private Scanner reader1 = new Scanner(System.in);
    private Scanner reader2 = new Scanner(System.in);
    private String n;
    private String m;

    //use in startGame
    private void initBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = SPACE;
            }
        }
    }

    //use in startGame
    private void printBoard() {
        System.out.println("\n  0 1 2");
        char y = '0';
        for (int row = 0; row < board.length; row++) {
            System.out.print(y + " ");
            y++;
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println(" ");
        }
    }

    //updates the position's that the User Guessed
    private void updateBoard1() {
        int x = n.charAt(0) - 48; //returns 0 of player 1
        int y = n.charAt(1) - 48; //returns 1
        board[x][y] = '0';

    }

    private void updateBoard2() {
        int x = m.charAt(0) - '0'; //returns 0 of player 2
        int y = m.charAt(1) - '0'; //returns 1
        board[x][y] = 'X';
    }

    private void user1Won() {
        user1 = "lost";
        if(board[0][0] == '0' && board[0][1] == '0' && board[0][2] == '0') {
            user1 = "won";
        }
        if(board[1][0] == '0' && board[1][1] == '0' && board[1][2] == '0') {
            user1 = "won";
        }
        if(board[2][0] == '0' && board[2][1] == '0' && board[2][2] == '0') {
            user1 = "won";
        }
        if(board[0][0] == '0' && board[1][0] == '0' && board[2][0] == '0') {
            user1 = "won";
        }
        if(board[0][1] == '0' && board[1][1] == '0' && board[2][1] == '0') {
            user1 = "won";
        }
        if(board[0][2] == '0' && board[1][2] == '0' && board[2][2] == '0') {
            user1 = "won";
        }
        if(board[0][0] == '0' && board[1][1] == '0' && board[2][2] == '0') {
            user1 = "won";
        }
        if(board[0][2] == '0' && board[1][1] == '0' && board[2][0] == '0') {
            user1 = "won";
        }
    }

    private void user2Won() {
        user2 = "lost";
        if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            user2 = "won";
        }
        if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            user2 = "won";
        }
        if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            user2 = "won";
        }
        if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            user2 = "won";
        }
        if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            user2 = "won";
        }
        if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            user2 = "won";
        }
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            user2 = "won";
        }
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            user2 = "won";
        }
    }

    private void startGame(){
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Player 1 is Circle, Player 2 is X");
        System.out.println("Player 1 chooses first");
        System.out.println("In order to answer, you need to use numbers for the position in terms of x and y.");
        System.out.println("Example: 00 is top left, 02 is top right, 01 is top middle");
        System.out.println("Good luck! \n \n");
        int x = 0;
        initBoard(); // creates board and sets locations to SPACE
        printBoard();
        while(x < 1) { // run's until either play 1 or 2 win
            System.out.println("Player 1: ");
            n = reader1.nextLine();
            //Set user 1 Guess to location
            updateBoard1();
            printBoard();
            user1Won();
            if(user1 == "won"){
                x++;
                break;
            }
            System.out.println("Player 2: ");
            m = reader2.nextLine();
            //Set user 2 Guess to location
            updateBoard2();
            printBoard();
            user2Won();
            if(user2 == "won"){
                x++;
                break;
            }
            printBoard();
        }
    }

    private void endGame(){
        if (user1.equals("won")) {
            System.out.println("Player 1 Won!");
        }
        else {
            System.out.println("Player 1 Lost!");
        }
        if (user2.equals("won")) {
            System.out.println("Player 2 Won!");
        }
        else {
            System.out.println("Player 2 Lost!");
        }
    }
    public static void main(String[] args){
        runGame game = new runGame();
        game.startGame();
        game.endGame();
    }
}
