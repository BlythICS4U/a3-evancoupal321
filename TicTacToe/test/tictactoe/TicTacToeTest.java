package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Evan
 */
public class TicTacToeTest {

    TicTacToe ttt;
    /**
     * Test of IsWinner method, of class TicTacToe.
     */
    @Test
    public void testIsWinner()
    {
        ttt = new TicTacToe(); //Horizontal
        for (int i = 0; i < 3; i++)
        {
            ttt.playMove('X', 0, i);
        }
        assertTrue(ttt.isWinner('X'));
        
        ttt = new TicTacToe(); //Vertical
        for (int i = 0; i < 3; i++)
        {
            ttt.playMove('X', i, 0);
        }
        assertTrue(ttt.isWinner('X'));
        
        ttt = new TicTacToe(); //Diagonal 1
        for (int i = 0; i < 3; i++)
        {
            ttt.playMove('X', i, i);
        }
        assertTrue(ttt.isWinner('X'));
        ttt = new TicTacToe(); //Diagonal 2
        for (int i = 0; i < 3; i++)
        {
            ttt.playMove('X', i, 2-i);
        }
        assertTrue(ttt.isWinner('X'));
    }

    /**
     * Test of IsFull method, of class TicTacToe.
     */
    @Test
    public void testIsFull()
    {
        ttt = new TicTacToe();
        assertFalse(ttt.isFull());
        for (int r = 0; r < 3; r++) //Fills the board
        {
            for (int c = 0; c < 3; c++)
            {
                ttt.playMove('X', r, c);
            }
        }
        assertTrue(ttt.isFull());
    }

    /**
     * Test of IsCat method, of class TicTacToe.
     */
    @Test
    public void testIsCat()
    {
        ttt = new TicTacToe();
        assertFalse(ttt.isCat());
        for (int r = 0; r < 3; r++) //Full with winner
        {
            for (int c = 0; c < 3; c++)
            {
                ttt.playMove('X', r, c);
            }
        }
        assertFalse(ttt.isCat());
        ttt = new TicTacToe();
        ttt.playMove('X', 0, 0); //Full without winner
        ttt.playMove('O', 0, 1);
        ttt.playMove('X', 0, 2);
        ttt.playMove('X', 1, 0);
        ttt.playMove('O', 1, 1);
        ttt.playMove('X', 1, 2);
        ttt.playMove('O', 2, 0);
        ttt.playMove('X', 2, 1);
        ttt.playMove('O', 2, 2);
        assertTrue(ttt.isCat());        
    }

    /**
     * Test of IsValid method, of class TicTacToe.
     */
    @Test
    public void testIsValid()
    {
        ttt = new TicTacToe();
        assertTrue(ttt.isValid(0, 0)); //All valid spaces
        assertTrue(ttt.isValid(0, 1));
        assertTrue(ttt.isValid(0, 2));
        assertTrue(ttt.isValid(1, 0));
        assertTrue(ttt.isValid(1, 1));
        assertTrue(ttt.isValid(1, 2));
        assertTrue(ttt.isValid(2, 0));
        assertTrue(ttt.isValid(2, 1));
        assertTrue(ttt.isValid(2, 2));
        
        assertFalse(ttt.isValid(3, 3)); //Some invalid spaces
        assertFalse(ttt.isValid(3, -1));
        assertFalse(ttt.isValid(-1, 3));
        assertFalse(ttt.isValid(-1, -1));
        
    }

    /**
     * Test of PlayerAt method, of class TicTacToe.
     */
    @Test
    public void testPlayerAt()
    {
        ttt = new TicTacToe();
        ttt.playMove('X', 0, 0); //Set all squares and check them
        ttt.playMove('O', 0, 1);
        ttt.playMove('X', 0, 2);
        ttt.playMove('X', 1, 0);
        ttt.playMove('O', 1, 1);
        ttt.playMove('X', 1, 2);
        ttt.playMove('O', 2, 0);
        ttt.playMove('X', 2, 1);
        ttt.playMove('O', 2, 2);
        assertEquals(ttt.playerAt(0, 0), 'X');
        assertEquals(ttt.playerAt(0, 1), 'O');
        assertEquals(ttt.playerAt(0, 2), 'X');
        assertEquals(ttt.playerAt(1, 0), 'X');
        assertEquals(ttt.playerAt(1, 1), 'O');
        assertEquals(ttt.playerAt(1, 2), 'X');
        assertEquals(ttt.playerAt(2, 0), 'O');
        assertEquals(ttt.playerAt(2, 1), 'X');
        assertEquals(ttt.playerAt(2, 2), 'O');
    }
}