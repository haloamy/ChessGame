package ChessGame.ChessSixPieces;

import ChessGame.ChessGamePieces;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * Created by Amy on 9/4/16.
 */
public class RookPiece extends ChessGamePieces{
    /**
     * (Called the super function from ChessGamPieces.
     * A constructor in order to help the Rook piece to settle the
     * color, it can possibly have two colors, either black or
     * white. And save its current location for future use.
     * @param position_row The row position of the Rook piece
     * @param position_col The col position of the Rook piece
     * @param pieceColor The color of the Rook piece, for future reference,
     *                   int 0 will represent white, and 1 will represent
     *                   color black.
     */
    public RookPiece(int position_row, int position_col, int pieceColor) {
        super(position_row, position_col, pieceColor);
    }

    public ImageIcon getPieceImage() {
        if (pieceColor == 1) {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/blackRook.jpg");
        }
        else
        {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/whiteRook.jpg");
        }
        return this.imageIcon;
    }

    @Override
    public boolean ableToMove(int next_row, int next_col) {
        int currentRow = this.position_row;
        int currentCol = this.position_col;
        //Check if the next row or col out of the board
        if(next_row < 0 || next_row > 7 || next_col < 0 || next_col > 7) {
            return false;
        }
        else {
            if((next_row == currentRow) && (next_col == currentCol)) return false;
            else if((next_row == currentRow) && (next_col != currentCol)) return true;
            else if((next_col == currentCol) && (next_row != currentRow)) return true;
            else return false;
        }
    }
}
