package ChessGame.ChessSixPieces;

import  ChessGame.ChessGamePieces;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * Created by Amy on 9/14/16.
 */


public class CustomPieceB extends ChessGamePieces{

    /**
     * Special piece for black player, get the position for the
     * customPieceB's row and col, and the pieceColor should be
     * 0 since it is for black player
     * @param position_row CustomPieceB's row position
     * @param position_col CustomPieceB's col position
     * @param pieceColor customePieceB's color indicate which team it belongs to
     */
    public CustomPieceB(int position_row, int position_col, int pieceColor) {
        super(position_row, position_col, pieceColor);
    }
    public ImageIcon getPieceImage() {
        if (pieceColor == 1) {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/imNotMoving.jpg");
        }
        else
        {
            this.imageIcon = new ImageIcon("src/ChessGame/ChessPieceImage/imNotMoving.jpg");
        }
        return this.imageIcon;
    }
    /**
     * For this custom piece for the black player, the rule for this particular
     * piece is it will locate at the center of the game board when it starts, and
     * it will stay at the same position until the game finished
     * @param next_row CustomPieceB's row
     * @param next_col CustomPieceB's col
     * @return Boolean true/false
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
            else return false;
        }
    }
}
