//What this game needs to do:
//        tic tac toe
//        draw the board
//        assign 1 player to circle and 1 player to X's
//        change the board to represent an (letters so char)O/X if the User picks it
//        every turn check if the user gets one of the 8 possible solution's
//        Print out who won.
import java.util.Scanner;

public class runGame {

    public static final char SPACE = '-';
    private char[][] board = new char[3][3];
    private Scanner reader1 = new Scanner(System.in);
    private Scanner reader2 = new Scanner(System.in);
    private Scanner reader3 = new Scanner(System.in);
    private String winner;
    private String n;
    private String m;
    private String user1;
    private String user2;
    private String player1;
    private String player2;
    private String Player1 = "Not Playing";
    private String Player2 = "Not Playing";
    private int numTurns = 0;


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
    private void updatePrime() {

        if (Player1.equals("Playing")) {
            int x = n.charAt(0) - 48; //returns 0 of player 1
            int y = n.charAt(1) - 48; //returns 1
            if (board[x][y] == 'X') {
                System.out.println("Already Chosen, please try again: ");
                n = reader1.nextLine();
                updatePrime();
            }
            if (board[x][y] == '0') {
                System.out.println("Already Chosen, please try again: ");
                n = reader1.nextLine();
                updatePrime();
            }
            if (board[x][y] == SPACE) {
                board[x][y] = '0';
            }
        }
        if(Player2.equals("Playing")) {
            int x = m.charAt(0) - 48; //returns 0 of player 2
            int y = m.charAt(1) - 48; //returns 1
            if(board[x][y] == 'X') {
                System.out.println("Already Chosen, please try again: ");
                m = reader2.nextLine();
                updatePrime();
            }
            if(board[x][y] == '0') {
                System.out.println("Already Chosen, please try again: ");
                m = reader2.nextLine();
                updatePrime();
            }
            if(board[x][y] == SPACE) {
                board[x][y] = 'X';
            }
        }
    }
    //Unsure if this is even needed
    private void setPlayer() {
        System.out.println("Please Choose player 1(0) or 2(X) by typing 1 or 2: ");
        int z = reader3.nextInt();
        if(z < 1 || z > 2) { //Checking to see if the user selected any other number other than 1 or 2
            setPlayer();
        }
      /*if(z == 1) {
             player1 = user1; // '0'
             player2 = user2; // 'X'
        }
        if(z == 2) {
            player1 = user2; // 'X'
            player2 = user1; // '0'
        }*/

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

    private void startGame(){

        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Player 1 is Circle, Player 2 is X");
        System.out.println("Player 1 chooses first");
        System.out.println("In order to answer, you need to use numbers for the position in terms of x and y.");
        System.out.println("Example: 00 is top left, 02 is top right, 01 is top middle");
        System.out.println("Good luck! \n \n");
        setPlayer();
        initBoard(); // creates board and sets locations to SPACE
        printBoard();
        while(true) { // run's until either play 1 or 2 win
            Player1 = "Playing";
            System.out.println("Player 1: ");
            n = reader1.nextLine();
            //Set user 1 Guess to location
            updatePrime();
            Player1 = "Not Playing";
            printBoard();
            numTurns++;
            user1 = userWon('0');
            if(user1.equals("won")){
                winner = "Player 1";
                break;
            }
            if(numTurns == 9) {
                user1 = "tie";
                break;
            }

            Player2 = "Playing";
            System.out.println("Player 2: ");
            m = reader2.nextLine();
            //Set user 2 Guess to location
            updatePrime();
            Player2 = "Not Playing";
            printBoard();
            numTurns++;
            user2 = userWon('X');
            if(user2.equals("won")){
                winner = "Player 2";
                break;
            }
            if(numTurns == 9) {
                user2 = "tie";
                break;
            }
            printBoard(); 
        }
    }

    // Extra Credit : Need to Do
    // check if guess is valid so we don't need to recursively call updateBoard

    // Extra Credit : DONE
    // save which player's turn is which
    // have 1 update Board method
    // set a player 1 0 or player 2 X function
    // make a condition if there is a tie, make a turn count, if it hits 9 turns overall its a tie.

    private void endGame(){
        if(user1.equals("tie") || user2.equals("tie")) {
            System.out.println("You both Tied!");
        } else {System.out.println(winner + " won");}
    }
    public static void main(String[] args){
        runGame game = new runGame();
        game.startGame();
        game.endGame();
    }
}
