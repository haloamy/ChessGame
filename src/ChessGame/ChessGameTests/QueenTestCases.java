package ChessGame.ChessGameTests;


import ChessGame.ChessSixPieces.QueenPiece;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class QueenTestCases{
    //Creat a new Queesn piece for test
    QueenPiece queenTestPiece = new QueenPiece(3, 3, 0);

    /*
    Test Queens's piece's ableToMove function
     */
    @Test
    public void ableToMoveTest() {
        //While at the same position
        boolean case1 = queenTestPiece.ableToMove(3, 3);
        assertEquals(case1, false);
        /*
        Horizontal wise ,vertical wise,and diagnal direction
         */
        boolean case2 = queenTestPiece.ableToMove(1, 3);
        assertEquals(case2, true);
        boolean case3 = queenTestPiece.ableToMove(5, 3);
        assertEquals(case3, true);
        boolean case4 = queenTestPiece.ableToMove(3, 0);
        assertEquals(case4, true);
        boolean case5 = queenTestPiece.ableToMove(3, 5);
        assertEquals(case5, true);
        boolean case6 = queenTestPiece.ableToMove(1, 1);
        assertEquals(case6, true);
        boolean case7 = queenTestPiece.ableToMove(6, 0);
        assertEquals(case7, true);
        boolean case8 = queenTestPiece.ableToMove(1, 5);
        assertEquals(case8, true);
        boolean case9 = queenTestPiece.ableToMove(5, 5);
        assertEquals(case9, true);
        /*
        Check out of bounds
         */
        boolean case10 = queenTestPiece.ableToMove(8, 8);
        assertEquals(case10, false);
        /*
        Check position that is not able to move
         */
        boolean case11 = queenTestPiece.ableToMove(2, 5);
        assertEquals(case11, false);
        boolean case12 = queenTestPiece.ableToMove(4, 0);
        assertEquals(case12, false);
        boolean case13 = queenTestPiece.ableToMove(2, 0);
        assertEquals(case13, false);
        boolean case14 = queenTestPiece.ableToMove(4, 6);
        assertEquals(case14, false);
    }
}
