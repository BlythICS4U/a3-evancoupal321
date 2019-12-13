/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
/**
 * Class contains the player's impossible AI opponent.
 * 
 * @author Evan
 */
public class TicTacToeAI
{
    int moveNum = 1;
    public TicTacToeAI(){}
    
    public void AIMove(TicTacToe board)
    {
        if (moveNum == 1) //Prioritize the center on the first move
        {
            moveNum++;
            if (board.playerAt(1, 1) == 'X')
            {
                board.playMove('O', 0, 0);
                return;
            }
            else
            {
                board.playMove('O', 1, 1);
                return;
            }
        }
        if (moveNum == 2) //Covers some cases where the player can still win because there is no need to block and the AI picks a bad spot
        {
            moveNum++;
            if (board.playerAt(0, 0) == 'O' && board.playerAt(1, 1) == 'X' && board.playerAt(2, 2) == 'X') //X in the middle, all 3 in one row
            {
                board.playMove('O', 0, 2);
                return;
            }
            if (board.playerAt(1, 1) == 'O') //O in the middle, all 3 in one row
            {
                if (board.playerAt(0, 0) == 'X' && board.playerAt(2, 2) == 'X')
                {
                    board.playMove('O', 0, 1);
                    return;
                }
                if (board.playerAt(2, 0) == 'X' && board.playerAt(0, 2) == 'X')
                {
                    board.playMove('O', 0, 1);
                    return;
                }
            }
            if (board.playerAt(1, 1) == 'O') //Not 3 in a row, but no blocking
            {
                if (board.playerAt(1, 0) == 'X' && board.playerAt(0, 1) == 'X') //Two edges
                {
                    board.playMove('O', 2, 0);
                    return;
                }
                if (board.playerAt(1, 0) == 'X' && board.playerAt(2, 1) == 'X')
                {
                    board.playMove('O', 2, 2);  
                    return;
                }
                if (board.playerAt(1, 2) == 'X' && board.playerAt(2, 1) == 'X')
                {
                    board.playMove('O', 2, 0);
                    return;
                }
                if (board.playerAt(1, 2) == 'X' && board.playerAt(0, 1) == 'X')
                {
                    board.playMove('O', 2, 2);
                    return;
                }
                
                if (board.playerAt(1, 0) == 'X' && board.playerAt(2, 2) == 'X') //One edge, one corner
                {
                    board.playMove('O', 2, 0);
                    return;
                }
                if (board.playerAt(1, 0) == 'X' && board.playerAt(0, 2) == 'X')
                {
                    board.playMove('O', 0, 0);
                    return;
                }
                if (board.playerAt(2, 1) == 'X' && board.playerAt(0, 2) == 'X')
                {
                    board.playMove('O', 2, 2);
                    return;
                }
                if (board.playerAt(2, 1) == 'X' && board.playerAt(0, 0) == 'X')
                {
                    board.playMove('O', 2, 0);
                    return;
                }
                if (board.playerAt(1, 2) == 'X' && board.playerAt(0, 0) == 'X')
                {
                    board.playMove('O', 0, 2);
                    return;
                }
                if (board.playerAt(1, 2) == 'X' && board.playerAt(2, 0) == 'X')
                {
                    board.playMove('O', 2, 2);
                    return;
                }
                if (board.playerAt(0, 1) == 'X' && board.playerAt(2, 0) == 'X')
                {
                    board.playMove('O', 0, 0);
                    return;
                }
                if (board.playerAt(0, 1) == 'X' && board.playerAt(2, 2) == 'X')
                {
                    board.playMove('O', 0, 2);
                    return;
                }
                
            }      
        }
        //After the first move (and the second move if it was one of the hard-coded options)
        //OPTION 1: WIN THE GAME
        for(int i = 0; i < 3; i++) //Horizontal
        {
            if (board.playerAt(i, 0) == 'O' && board.playerAt(i, 1) == 'O' && board.playerAt(i, 2) == ' ')
            {
                board.playMove('O', i, 2);
                return;
            }
            if (board.playerAt(i, 0) == 'O' && board.playerAt(i, 1) == ' ' && board.playerAt(i, 2) == 'O')
            {
                board.playMove('O', i, 1);
                return;
            }
            if (board.playerAt(i, 0) == ' ' && board.playerAt(i, 1) == 'O' && board.playerAt(i, 2) == 'O')
            {
                board.playMove('O', i, 0);
                return;
            }
        }
        for(int i = 0; i < 3; i++) //Vertical
        {
            if (board.playerAt(0, i) == 'O' && board.playerAt(1, i) == 'O' && board.playerAt(2, i) == ' ')
            {
                board.playMove('O', 2, i);
                return;
            }
            if (board.playerAt(0, i) == 'O' && board.playerAt(1, i) == ' ' && board.playerAt(2, i) == 'O')
            {
                board.playMove('O', 1, i);
                return;
            }
            if (board.playerAt(0, i) == ' ' && board.playerAt(1, i) == 'O' && board.playerAt(2, i) == 'O')
            {
                board.playMove('O', 0, i);
                return;
            }
        }
        
        if (board.playerAt(0, 0) == 'O' && board.playerAt(1, 1) == 'O' && board.playerAt(2, 2) == ' ') //Top-Left Diagonal
        {
            board.playMove('O', 2, 2);
            return;
        }
        if (board.playerAt(0, 0) == 'O' && board.playerAt(1, 1) == ' ' && board.playerAt(2, 2) == 'O')
        {
            board.playMove('O', 1, 1);
            return;
        }
        if (board.playerAt(0, 0) == ' ' && board.playerAt(1, 1) == 'O' && board.playerAt(2, 2) == 'O')
        {
            board.playMove('O', 0, 0);
            return;
        }
        
        if (board.playerAt(0, 2) == 'O' && board.playerAt(1, 1) == 'O' && board.playerAt(2, 0) == ' ') //Top-Right diagonal
        {
            board.playMove('O', 2, 0);
            return;
        }
        if (board.playerAt(0, 2) == 'O' && board.playerAt(1, 1) == ' ' && board.playerAt(2, 0) == 'O')
        {
            board.playMove('O', 1, 1);
            return;
        }
        if (board.playerAt(0, 2) == ' ' && board.playerAt(1, 1) == 'O' && board.playerAt(2, 0) == 'O')
        {
            board.playMove('O', 0, 2);
            return;
        }
        
        
        //OPTION 2: BLOCK THE PLAYER FROM WINNING
        for(int i = 0; i < 3; i++) //Horizontal
        {
            if (board.playerAt(i, 0) == 'X' && board.playerAt(i, 1) == 'X' && board.playerAt(i, 2) == ' ')
            {
                board.playMove('O', i, 2);
                return;
            }
            if (board.playerAt(i, 0) == 'X' && board.playerAt(i, 1) == ' ' && board.playerAt(i, 2) == 'X')
            {
                board.playMove('O', i, 1);
                return;
            }
            if (board.playerAt(i, 0) == ' ' && board.playerAt(i, 1) == 'X' && board.playerAt(i, 2) == 'X')
            {
                board.playMove('O', i, 0);
                return;
            }
        }
        for(int i = 0; i < 3; i++) //Vertical
        {
            if (board.playerAt(0, i) == 'X' && board.playerAt(1, i) == 'X' && board.playerAt(2, i) == ' ')
            {
                board.playMove('O', 2, i);
                return;
            }
            if (board.playerAt(0, i) == 'X' && board.playerAt(1, i) == ' ' && board.playerAt(2, i) == 'X')
            {
                board.playMove('O', 1, i);
                return;
            }
            if (board.playerAt(0, i) == ' ' && board.playerAt(1, i) == 'X' && board.playerAt(2, i) == 'X')
            {
                board.playMove('O', 0, i);
                return;
            }
        }
        
        if (board.playerAt(0, 0) == 'X' && board.playerAt(1, 1) == 'X' && board.playerAt(2, 2) == ' ') //Top-Left Diagonal
        {
            board.playMove('O', 2, 2);
            return;
        }
        if (board.playerAt(0, 0) == 'X' && board.playerAt(1, 1) == ' ' && board.playerAt(2, 2) == 'X')
        {
            board.playMove('O', 1, 1);
            return;
        }
        if (board.playerAt(0, 0) == ' ' && board.playerAt(1, 1) == 'X' && board.playerAt(2, 2) == 'X')
        {
            board.playMove('O', 0, 0);
            return;
        }
        
        if (board.playerAt(0, 2) == 'X' && board.playerAt(1, 1) == 'X' && board.playerAt(2, 0) == ' ') //Top-Right diagonal
        {
            board.playMove('O', 2, 0);
            return;
        }
        if (board.playerAt(0, 2) == 'X' && board.playerAt(1, 1) == ' ' && board.playerAt(2, 0) == 'X')
        {
            board.playMove('O', 1, 1);
            return;
        }
        if (board.playerAt(0, 2) == ' ' && board.playerAt(1, 1) == 'X' && board.playerAt(2, 0) == 'X')
        {
            board.playMove('O', 0, 2);
            return;
        }
     
        //OPTION 3: CHOOSE FIRST AVAILABLE SQUARE
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                if (board.playerAt(r, c) == ' ')
                {
                    board.playMove('O', r, c);
                    return;
                }
            }
        }
    }
}
