package ChessGame.ChessGameTests;

import ChessGame.ChessSixPieces.PawnPiece;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Amy on 9/14/16.
 */
public class PawnTestCases {
    /*
    Create a pawnTestPiece for testing the ableToMoveFunction,
    only testing white piece, the balck piece have the same logic.
     */

    PawnPiece pawnTestPieceAtBeginning = new PawnPiece(1, 1, 0);
    PawnPiece pawnTestPieceAtOtherPosition = new PawnPiece(2, 2, 0);

    /**
     * Unit test for ableToMove function in PawnPiece
     */
    @Test
    public void ableToMoveTest() {
        /*
        At the beginning position while the row is 1 for white pawn piece
         */
        boolean case1 = pawnTestPieceAtBeginning.ableToMove(1, 1);
        assertEquals(case1, false);
        boolean case2 = pawnTestPieceAtBeginning.ableToMove(0, 1);
        assertEquals(case2, false);
        boolean case3 = pawnTestPieceAtBeginning.ableToMove(2, 0);
        assertEquals(case3, false);
        boolean case4 = pawnTestPieceAtBeginning.ableToMove(2, 2);
        assertEquals(case4, false);
        boolean case5 = pawnTestPieceAtBeginning.ableToMove(4, 1);
        assertEquals(case5, false);
        boolean case6 = pawnTestPieceAtBeginning.ableToMove(8, 8);
        assertEquals(case6, false);
        boolean case7 = pawnTestPieceAtBeginning.ableToMove(2, 1);
        assertEquals(case7, true);
        boolean case8 = pawnTestPieceAtBeginning.ableToMove(3, 1);
        assertEquals(case8, true);
        /*
        Not at the beginning position
         */
        boolean case9 = pawnTestPieceAtOtherPosition.ableToMove(2, 2);
        assertEquals(case9, false);
        boolean case10 = pawnTestPieceAtOtherPosition.ableToMove(1, 2);
        assertEquals(case10, false);
        boolean case11 = pawnTestPieceAtOtherPosition.ableToMove(2, 1);
        assertEquals(case11, false);
        boolean case12 = pawnTestPieceAtOtherPosition.ableToMove(2, 3);
        assertEquals(case12, false);
        boolean case13 = pawnTestPieceAtOtherPosition.ableToMove(4, 2);
        assertEquals(case13, false);
        boolean case14 = pawnTestPieceAtOtherPosition.ableToMove(3, 1);
        assertEquals(case14, true);
        boolean case15 = pawnTestPieceAtOtherPosition.ableToMove(3, 2);
        assertEquals(case15, true);
        boolean case16 = pawnTestPieceAtOtherPosition.ableToMove(3, 3);
        assertEquals(case16, true);

    }
}
