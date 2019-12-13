package tictactoe;

import java.util.Scanner;

/**
 * Main class
 * 
 * @author Evan
 */
public class TicTacToeRunner {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X'; //Current player
        TicTacToe ttt = new TicTacToe(); //Game board
        TicTacToeAI ai = new TicTacToeAI(); //AI opponent
        int r, c; //Row and column position

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            if (p == 'X') //Player's move
            {
                System.out.print("Choose your location (i.e. 0 0): ");
                r = keyboard.nextInt();
                c = keyboard.nextInt();

                while (ttt.isValid(r, c) == false || ttt.playerAt(r, c) != ' ') {
                    if (ttt.isValid(r, c) == false) {
                        System.out.println("That is not a valid location. Try again.");
                    } else if (ttt.playerAt(r, c) != ' ') {
                        System.out.println("That location is already full. Try again.");
                    }

                    System.out.print("Choose your location (row, column): ");
                    r = keyboard.nextInt();
                    c = keyboard.nextInt();
                }
                ttt.playMove(p, r, c);
            }
            else
            {
                System.out.println("The AI is choosing its location...");
                ai.AIMove(ttt);
                
            }

            if (p == 'X') {
                p = 'O';
            } else {
                p = 'X';
            }

        }

        ttt.displayBoard();

        if (ttt.isWinner('X')) {
            System.out.println("X is the winner!");
        }
        if (ttt.isWinner('O')) {
            System.out.println("O is the winner!");
        }
        if (ttt.isCat()) {
            System.out.println("The game is a tie.");
        }

    }
}
