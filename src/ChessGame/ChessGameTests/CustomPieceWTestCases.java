package ChessGame.ChessGameTests;

import ChessGame.ChessSixPieces.CustomPieceW;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Amy on 9/14/16.
 */
public class CustomPieceWTestCases {
    //Create a new King piece, so it have the position and color
    CustomPieceW customTestPieceW = new CustomPieceW(2, 2, 0);

    /**
     * Test for CustomPieceW ableToMoveFunction
     */
    @Test
    public void  ableToMoveTest() {
        /*
        Check out of bound and impossible movements
         */
        boolean case1 = customTestPieceW.ableToMove(2, 8);
        assertEquals(case1, false);
        boolean case2 = customTestPieceW.ableToMove(3, 0);
        assertEquals(case2, false);
        boolean case3 = customTestPieceW.ableToMove(1, 0);
        assertEquals(case3, false);
        boolean case4 = customTestPieceW.ableToMove(1, 4);
        assertEquals(case4, false);
        /*
        Check the possible movements
         */
        boolean case5 = customTestPieceW.ableToMove(2, 2);
        assertEquals(case5, true);
        boolean case6 = customTestPieceW.ableToMove(2, 0);
        assertEquals(case6, true);
        boolean case7 = customTestPieceW.ableToMove(2, 5);
        assertEquals(case7, true);


    }

}
