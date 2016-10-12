package ChessGame.ChessGameTests;


import ChessGame.ChessSixPieces.KingPiece;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class KingTestCases {
    //Create a new King piece, so it have the position and color
    KingPiece kingTestPiece = new KingPiece(3, 3, 0);

    /**
     * Test for KingPiece ableToMoveFunction
     */
    @Test
    public void  ableToMoveTest() {
        /*
        Out of bound cases collection
         */
        boolean case1 = kingTestPiece.ableToMove(1, 1);
        assertEquals(case1, false);
        boolean case2 = kingTestPiece.ableToMove(5, 5);
        assertEquals(case2, false);
        boolean case3 = kingTestPiece.ableToMove(5, 1);
        assertEquals(case3, false);

        /*
        Moves that are possible for king piece
         */
        boolean case4 = kingTestPiece.ableToMove(2, 3);
        assertEquals(case4, true);
        boolean case5 = kingTestPiece.ableToMove(3, 4);
        assertEquals(case5, true);
        boolean case6 = kingTestPiece.ableToMove(2, 2);
        assertEquals(case6, true);
    }
}

