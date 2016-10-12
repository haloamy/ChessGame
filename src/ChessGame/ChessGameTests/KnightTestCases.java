package ChessGame.ChessGameTests;


import ChessGame.ChessSixPieces.KingPiece;
import ChessGame.ChessSixPieces.KnightPiece;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class KnightTestCases {
    //Create a new KnightTest piece for testing.
    KnightPiece knightTestPiece = new KnightPiece(2, 2, 0);

    /**
     * Test ableToMove function in knightpiece class
     */
    @Test
    public void ableToMoveTest() {
        /*
        Test at current position and out of bound
         */
        boolean case1 = knightTestPiece.ableToMove(2, 2);
        assertEquals(case1, false);
        boolean case2 = knightTestPiece.ableToMove(8, 8);
        assertEquals(case2, false);
        /*
        Test position that are not able to move
         */
        boolean case3 = knightTestPiece.ableToMove(1, 2);
        assertEquals(case3, false);
        boolean case4 = knightTestPiece.ableToMove(0, 4);
        assertEquals(case4, false);
        boolean case5 = knightTestPiece.ableToMove(2, 0);
        assertEquals(case5, false);
        boolean case6 = knightTestPiece.ableToMove(4, 0);
        assertEquals(case6, false);
        boolean case7 = knightTestPiece.ableToMove(3, 3);
        assertEquals(case7, false);
        boolean case8 = knightTestPiece.ableToMove(2, 4);
        assertEquals(case8, false);
        /*
        Test position that are ablr to move
         */
        boolean case9 = knightTestPiece.ableToMove(0, 1);
        assertEquals(case9, true);
        boolean case10 = knightTestPiece.ableToMove(1, 4);
        assertEquals(case10, true);
        boolean case11 = knightTestPiece.ableToMove(3, 0);
        assertEquals(case11, true);
        boolean case12 = knightTestPiece.ableToMove(3, 4);
        assertEquals(case12, true);
    }
}
