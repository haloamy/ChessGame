package ChessGame.ChessSixPieces;

import  ChessGame.ChessGamePieces;

import javax.swing.*;
import javax.swing.ImageIcon;

/**
 * Created by Amy on 9/14/16.
 */
public class CustomPieceW extends ChessGamePieces{
    /**
     * This custome piece will act like a pawn after the first move, however, when it
     * move the first step, it can move as far as it wants but only horizontally.
     * @param position_row current row position for customPieceW
     * @param position_col current col position for customPieceW
     * @param pieceColor
     */
    public CustomPieceW(int position_row, int position_col, int pieceColor) {
        super(position_row, position_col, pieceColor);
    }
    public ImageIcon getPieceImage() {
        if (pieceColor == 0) {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/imMovingHoriwise.jpg");
        }
        else
        {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/imMovingHoriwise.jpg");
        }
        return this.imageIcon;
    }
    /**
     * This ableToMove function will keep check if it is ok for the piece to move,
     * for this piece it is particular designed for white player, it can only move
     * to the right/horizontally. It has the ability to choose not to move
     * @param next_row next step of row position
     * @param next_col next step of col position
     * @return boolean true/false
     */
    public boolean ableToMove(int next_row, int next_col) {
        //Get the current position for this piece
        int currentRow = this.position_row;
        int currentCol = this.position_col;
        //Check if the piece is out of bound
        if(next_row < 0 || next_row > 7 || next_col < 0 || next_col > 7) {
            return false;
        }
        else {
            if ((next_row == currentRow) && (next_col == currentCol)) return true;
            else if ((next_row == currentRow) && (next_col < 7)) {
                return true;
            }
            else return false;
        }

    }
}
