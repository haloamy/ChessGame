package ChessGame.ChessGameTests;

import ChessGame.ChessSixPieces.BishopPiece;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Amy on 9/14/16.
 */
public class BishopTestCases {
    //Create a new bishop test piece for testing
    BishopPiece bishopTestPiece = new BishopPiece(3, 3, 0);

    /**
     * Test the ableToMove function in BishopPiece
     */
    @Test
    public void ableToMoveTest() {
        /*
        At current position and out of bound
         */
        boolean case1 = bishopTestPiece.ableToMove(3, 3);
        assertEquals(case1, false);
        boolean case2 = bishopTestPiece.ableToMove(8, 8);
        assertEquals(case2, false);
        /*
         Possible moving position
         */
        boolean case3 = bishopTestPiece.ableToMove(5, 1);
        assertEquals(case3, true);
        boolean case4 = bishopTestPiece.ableToMove(1, 5);
        assertEquals(case4, true);
        boolean case5 = bishopTestPiece.ableToMove(1, 1);
        assertEquals(case5, true);
        boolean case6 = bishopTestPiece.ableToMove(5, 5);
        assertEquals(case6, true);
        /*
        Not possible moving position
         */
        boolean case7 = bishopTestPiece.ableToMove(0, 3);
        assertEquals(case7, false);
        boolean case8 = bishopTestPiece.ableToMove(6, 3);
        assertEquals(case8, false);
        boolean case9 = bishopTestPiece.ableToMove(3, 0);
        assertEquals(case9, false);
        boolean case10 = bishopTestPiece.ableToMove(3, 6);
        assertEquals(case10, false);

    }
}
