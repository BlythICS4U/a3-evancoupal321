package tictactoe;
/**
 * Class contains the TicTacToe game.
 * 
 * @author Evan
 */
public class TicTacToe {
    
    private char[][] board; //The game board

    // Constructors
    /**
     * Create the TicTacToe board
     */
    public TicTacToe() {
        board = new char[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    // Accessor Methods
    /**
     * Detects if one of the players is the winner
     * 
     * @param p The player that you are checking for victory
     * @return True if the player has won, false if not
     */
    public boolean isWinner(char p) {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) //Horizontal
            {
                return true;
            }
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) //Vertical
            {
                return true;
            }
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) //Diagonal 1
        {
            return true;
        }
        if (board[2][0] == p && board[1][1] == p && board[0][2] == p) //Diagonal 2
        {
            return true;
        }
        return false;
    }

    /**
     * Checks if all nine spaces on the board are full
     * 
     * @return True if the board is full, false if not
     */
    public boolean isFull() {
        for (int r = 0; r < 3; r++) //Check all board spaces
        {
            for (int c = 0; c < 3; c++)
            {
                if (board[r][c] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the game is deadlocked
     * 
     * @return True if the board is full and neither player has won, false if not
     */
    public boolean isCat() {
        return (isFull() && !isWinner('X') && !isWinner('O'));
    }

    /**
     * Checks if a given move is a valid square on the board
     * 
     * @param r The row that the move is on
     * @param c The column that the move is on
     * @return True if the move is valid, false if not
     */
    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) { //If the square is on the board
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the character at a given space on the board
     * 
     * @param r The row that you are searching in
     * @param c The column that you are searching in
     * @return The character at the space on the board
     */
    public char playerAt(int r, int c) {
        if (isValid(r, c)) {
            return board[r][c];
        } else {
            return '@';
        }
    }

    /**
     * Displays the current state of the board
     */
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    /**
     * Allows the player to perform a move
     * 
     * @param p The player that is performing a move
     * @param r The row that the piece is being placed on
     * @param c The column that the piece is being placed on
     */
    public void playMove(char p, int r, int c) {
        board[r][c] = p;
    }

}
