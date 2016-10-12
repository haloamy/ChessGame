package ChessGame.ChessSixPieces;

import ChessGame.ChessGamePieces;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * Created by Amy on 9/4/16.
 */
public class PawnPiece extends ChessGamePieces {
    /**
     * (Called the super function from ChessGamPieces.
     * A constructor in order to help the Pawn piece to settle the
     * color, it can possibly have two colors, either black or
     * white. And save its current location for future use.
     *
     * @param position_row The row position of the Pawn piece
     * @param position_col The col position of the Pawn piece
     * @param pieceColor   The color of the Pawn piece, for future reference,
     *                     int 0 will represent white, and 1 will represent
     *                     color black.
     */
    public PawnPiece(int position_row, int position_col, int pieceColor) {
        super(position_row, position_col, pieceColor);
    }

    public ImageIcon getPieceImage() {
        if (pieceColor == 1) {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/blackPawn.jpg");
        }
        else
        {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/whitePawn.jpg");
        }
        return this.imageIcon;
    }

    public boolean ableToMove(int next_row, int next_col) {
        int currentRow = this.position_row;
        int currentCol = this.position_col;
        int currentColor = this.pieceColor;

        //Check if the next row or col out of the board
        if (next_row < 0 || next_row > 7 || next_col < 0 || next_col > 7) {
            return false;
        }
        else {
            if ((next_row == currentRow) && next_col == currentCol) return false;
             /*When the pawn is white, and it is at the first position, it can only move downward
                one or two steps.
                */
            else if (currentRow == 1) {
                if (((next_row == 2) || (next_row == 3)) && (next_col == currentCol)) return true;
                else return false;
            }
            else if ((currentColor == 0) && (next_row == currentRow + 1)) { //When it is white and not at the first step
                if (((next_col == currentCol) || (next_col == currentCol + 1) || (next_col == currentCol - 1))) return true;
                else return false;
            }
                 /*When the pawn is black, and it is at the first position, it can only move upward
                one or two steps.
                */
            else if (currentRow == 6) {
                if (((next_row == 5) || (next_row == 4)) && (next_col == currentCol)) return true;
                else return false;
            }
            else if((currentColor == 1) && (next_row == currentRow - 1)) { //When it is black and not at the first step
                if(((next_col == currentCol) || (next_col == currentCol + 1) || (next_col == currentCol - 1))) return true;
                else return false;
            }
            else return false;
        }
    }
}
