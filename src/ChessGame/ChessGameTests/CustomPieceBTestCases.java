package ChessGame.ChessGameTests;

import ChessGame.ChessSixPieces.CustomPieceB;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class CustomPieceBTestCases {
    //Create a new King piece, so it have the position and color
    CustomPieceB customTestPieceB = new CustomPieceB(4, 4, 1);

    /**
     * Test for CustomPieceB ableToMoveFunction
     */
    @Test
    public void  ableToMoveTest() {
        /*
        Out of bound check for the customPieceB and not possible movements
         */
        boolean case1 = customTestPieceB.ableToMove(8, 8);
        assertEquals(case1, false);
        boolean case2 = customTestPieceB.ableToMove(2, 3);
        assertEquals(case2, false);
        boolean case3 = customTestPieceB.ableToMove(2, 5);
        assertEquals(case3, false);
        boolean case4 = customTestPieceB.ableToMove(6, 2);
        assertEquals(case4, false);
        boolean case5 = customTestPieceB.ableToMove(6, 6);
        assertEquals(case5, false);
        /*
        The only movement that works with this piece check
         */
        boolean case6 = customTestPieceB.ableToMove(4, 4);
        assertEquals(case6, true);
    }
}
