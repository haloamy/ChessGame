package ChessGame.ChessGameTests;

import ChessGame.ChessSixPieces.RookPiece;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class RookTestCases {
    //Create a new rook piece for testing
    RookPiece rookTestPiece = new RookPiece(3, 3, 0);

    /*
    Test ableToMove function in RookPiece
     */
    @Test
    public void ableToMoveTest() {
        /*
        Current position and out of bound position
         */
        boolean case1 = rookTestPiece.ableToMove(3, 3);
        assertEquals(case1, false);
        boolean case2 = rookTestPiece.ableToMove(8, 8);
        assertEquals(case2, false);
        /*
        Possible moving position horizontal and vertical.
         */
        boolean case3 = rookTestPiece.ableToMove(3, 0);
        assertEquals(case3, true);
        boolean case4 = rookTestPiece.ableToMove(3, 5);
        assertEquals(case4, true);
        boolean case5 = rookTestPiece.ableToMove(1, 3);
        assertEquals(case5, true);
        boolean case6 = rookTestPiece.ableToMove(3, 5);
        assertEquals(case6, true);
        /*
        Unable to move position
         */
        boolean case7 = rookTestPiece.ableToMove(1, 1);
        assertEquals(case7, false);
        boolean case8 = rookTestPiece.ableToMove(2, 5);
        assertEquals(case8, false);
        boolean case9 = rookTestPiece.ableToMove(5, 2);
        assertEquals(case9, false);
        boolean case10 = rookTestPiece.ableToMove(5, 5);
        assertEquals(case10, false);
    }

}
