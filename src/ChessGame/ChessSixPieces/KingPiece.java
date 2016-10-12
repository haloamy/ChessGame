package ChessGame.ChessSixPieces;

import ChessGame.ChessGameBoard;
import ChessGame.ChessGamePieces;
import javax.swing.ImageIcon;
import javax.swing.*;

import static java.lang.Math.abs;

/**
 * Created by Amy on 9/4/16.
 */
public class KingPiece extends ChessGamePieces{
    /**
     * (Called the super function from ChessGamPieces.
     * A constructor in order to help the King piece to settle the
     * color, it can possibly have two colors, either black or
     * white. And save its current location for future use.
     * @param position_row The row position of the king piece
     * @param position_col The col position of the King piece
     * @param pieceColor The color of the King piece, for future reference,
     *                   int 0 will represent white, and 1 will represent
     *                   color black.
     */
    public KingPiece(int position_row, int position_col, int pieceColor) {
        super(position_row, position_col, pieceColor);
    }

    public ImageIcon getPieceImage() {
        if (pieceColor == 1) {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/blackKing.jpg");
        }
        else
        {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/whiteKing.jpg");
        }
        return this.imageIcon;
    }

    /**
     * An abstract function from the ChessGamePiece abstrac class, the
     * main purpose for this function is to check if the King is abaliable
     * and if it is ok to move for the next step. Currently only doing the basic
     * such as go straight, side, and cross.
     * @param next_row The next move row position
     * @param next_col The next move col position
     * @return return a boolean either it is ok for king to move or not
     */
    public boolean ableToMove(int next_row, int next_col) {
        int currentRow = this.position_row;
        int currentCol = this.position_col;
        //int currentColor = this.pieceColor;

        if(next_row < 0 || next_row > 7 || next_col < 0 || next_col > 7) {
            return false;
        }
        else {
            if((next_row == currentRow) && (next_col == currentCol)) {
                return false;
            }
            else if((next_row == currentRow) && (next_col == currentCol + 1)) return true;
            else if((next_row == currentRow) && (next_col == currentCol -1)) return true;
            else if((next_col == currentCol) && (next_row == currentRow + 1)) return true;
            else if((next_col == currentCol) && (next_row == currentRow - 1))return true;
            else if((next_row == currentRow + 1) && (next_col == currentCol + 1)) return true;
            else if((next_row == currentRow + 1) && (next_col == currentCol - 1)) return true;
            else if((next_row == currentRow - 1) && (next_col == currentCol + 1)) return true;
            else if((next_row == currentRow - 1) && (next_col == currentCol - 1)) return true;
            else {
                return false;
            }
        }
    }
}
