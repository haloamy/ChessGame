package ChessGame;

import javax.swing.*;
import java.awt.image.*;
/**
 * Created by Amy on 9/6/16.
 */
public abstract class ChessGamePieces {

    public int position_row;
    public int position_col;
    public int pieceColor;
    public ImageIcon imageIcon;

    /**
     * Constructor in order to set the piece's color, two
     * possible color black or white
     * @param position_row position for piece's row
     * @param position_col pisition for piece's col
     * @param pieceColor an int indicate the piece's color
     */
    public ChessGamePieces(int position_row, int position_col, int pieceColor) {
        this.position_row = position_row;
        this.position_col = position_col;
        this.pieceColor = pieceColor;
    }

    /**
     * ableToMove function will check if the current piece is able to
     * move to the target position
     * @param next_row The target row
     * @param next_col The target col
     * @return Boolean true/false
     */
     public abstract boolean ableToMove(int next_row, int next_col);

    /**
     * getPieceImage will help the board get the current piece
     * image
     * @return the current piece image
     */
     public abstract ImageIcon getPieceImage();
}
