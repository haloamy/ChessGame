package ChessGame;

import javax.swing.JPanel;

/**
 * Created by Amy on 9/4/16.
 */

public class ChessGameBoard extends JPanel {

    //Constructor while creating new Board
    ChessGamePieces [][] Board;
    //Keep track the king's position
    int[] whiteKing = new int[2];
    int[] blackKing = new int[2];
    boolean whiteFlag = false;
    boolean blackFlag = false;

    /**
     * Function to create the board for the Chess Game, it will be an 8 by 8 board,
     * and with black/white background.
     */
    public  ChessGameBoard() {
        //Creating the board of size 8 * 8
        this.Board = new ChessGamePieces[8][8];
//        for (int row = 0; row < 8; row++) {
//            for (int col = 0; col < 8; col++) {
//                this.Board[row][col] = null;
//            }
//        }

        // Adding White Pieces (Starting Position), 0 stands color WHITE
        this.Board[0][0] = new ChessGame.ChessSixPieces.RookPiece(0,0,0);
        this.Board[0][1] = new ChessGame.ChessSixPieces.KnightPiece(0,1,0);
        this.Board[0][2] = new ChessGame.ChessSixPieces.BishopPiece(0,2,0);
        this.Board[0][3] = new ChessGame.ChessSixPieces.QueenPiece(0,3,0);
        this.Board[0][4] = new ChessGame.ChessSixPieces.KingPiece(0,4,0);
        whiteKing[0] = 0;
        whiteKing[1] = 4;
        this.Board[0][5] = new ChessGame.ChessSixPieces.BishopPiece(0,5,0);
        this.Board[0][6] = new ChessGame.ChessSixPieces.KnightPiece(0,6,0);
        this.Board[0][7] = new ChessGame.ChessSixPieces.RookPiece(0,7,0);
        for (int i = 0; i < 8; i ++) {
            this.Board[1][i] = new ChessGame.ChessSixPieces.PawnPiece(1, i, 0);
        }
        this.Board[2][0] = new ChessGame.ChessSixPieces.CustomPieceW(2, 0, 0);


        // Adding Black Pieces (Starting Position), 1 stands color BLACK
        this.Board[7][0] = new ChessGame.ChessSixPieces.RookPiece(7,0,1);
        this.Board[7][1] = new ChessGame.ChessSixPieces.KnightPiece(7,1,1);
        this.Board[7][2] = new ChessGame.ChessSixPieces.BishopPiece(7,2,1);
        this.Board[7][3] = new ChessGame.ChessSixPieces.QueenPiece(7,3,1);
        this.Board[7][4] = new ChessGame.ChessSixPieces.KingPiece(7,4,1);
        blackKing[0] = 7;
        blackKing[1] = 4;
        this.Board[7][5] = new ChessGame.ChessSixPieces.BishopPiece(7,5,1);
        this.Board[7][6] = new ChessGame.ChessSixPieces.KnightPiece(7,6,1);
        this.Board[7][7] = new ChessGame.ChessSixPieces.RookPiece(7,7,1);
        for (int j = 0; j < 8; j ++) {
            this.Board[6][j] = new ChessGame.ChessSixPieces.PawnPiece(6,j,1);
        }

        this.Board[4][4] = new ChessGame.ChessSixPieces.CustomPieceB(4, 4, 1);
    }

    /**
     * Function in order to get the current Board
     * @return the current board.
     */
    public ChessGamePieces[][] currentChessBoard() {
        return this.Board;
    }

    /**
     * Helper function in order to check if the next moving step has been
     * blocked or not, if yes return true, if not return false.
     * @param x Aming position row
     * @param y Aming position col
     * @return Boolean type
     */
    public boolean pieceBlocked(int x, int y) {
        if(this.Board[x][y] == null) {
            return false;
        }
        else return true;
    }

    public void movingPiece(int row, int col, int target_row, int target_col) {

//        &&(!pathContainOtherPieceOrNot(row, col, target_row, target_col))

//        System.out.println(this.Board[target_row][target_col] == null);
        System.out.println(pathContainOtherPieceOrNot(row, col, target_row, target_col));
        System.out.println(this.Board[row][col].ableToMove(target_row, target_col));

        if (pieceBlocked(target_row, target_col)) {
            if (this.Board[row][col].pieceColor != this.Board[target_row][target_col].pieceColor) {
                if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.KingPiece) {
                    if (this.Board[row][col].pieceColor == 0) {
                        whiteKing[0] = target_row;
                        whiteKing[1] = target_col;
                    } else {
                        blackKing[0] = target_row;
                        blackKing[1] = target_col;
                    }
                }
                chessCapture(row, col, target_row, target_col);
            }
        }
        else if ((this.Board[target_row][target_col] == null) && (pathContainOtherPieceOrNot(row, col, target_row, target_col))&& (this.Board[row][col].ableToMove(target_row, target_col))) {
            if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.KingPiece) {
                if (this.Board[row][col].pieceColor == 0) {
                    whiteKing[0] = target_row;
                    whiteKing[1] = target_col;
                } else {
                    blackKing[0] = target_row;
                    blackKing[1] = target_col;
                }
            }

            if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.KingPiece) {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.KingPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            } else if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.QueenPiece) {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.QueenPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            } else if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.BishopPiece) {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.BishopPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            } else if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.KnightPiece) {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.KnightPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            } else if (this.Board[row][col] instanceof ChessGame.ChessSixPieces.RookPiece) {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.RookPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            } else {
                this.Board[target_row][target_col] = new ChessGame.ChessSixPieces.PawnPiece(target_row, target_col, (this.Board[row][col].pieceColor));
            }

            this.Board[row][col] = null;
        }
    }

//    // deep copy board
//    public ChessGameBoard[][] copy() {
//        ChessGamePieces [][] copy_board = new ChessGamePieces[8][8];
//
//        for (int i = 0; i < 8; i ++) {
//            for (int j = 0; j < 8; j++) {
//                if (this.Board[i][j] != null) {
//                    if (this.Board[i][j] instanceof ChessGame.ChessSixPieces.KingPiece) {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.KingPiece(i, j, (this.Board[i][j].pieceColor));
//                    } else if (this.Board[i][j] instanceof ChessGame.ChessSixPieces.QueenPiece) {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.QueenPiece(i, j, (this.Board[i][j].pieceColor));
//                    } else if (this.Board[i][j] instanceof ChessGame.ChessSixPieces.BishopPiece) {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.BishopPiece(i, j, (this.Board[i][j].pieceColor));
//                    } else if (this.Board[i][j] instanceof ChessGame.ChessSixPieces.KnightPiece) {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.KnightPiece(i, j, (this.Board[i][j].pieceColor));
//                    } else if (this.Board[i][j] instanceof ChessGame.ChessSixPieces.RookPiece) {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.RookPiece(i, j, (this.Board[i][j].pieceColor));
//                    } else {
//                        copy_board[i][j] = new ChessGame.ChessSixPieces.PawnPiece(i, j, (this.Board[i][j].pieceColor));
//                    }
//                }
//                else {
//                    copy_board[i][j] = null;
//                }
//            }
//        }
//
//        return copy_board;
//    }

    /**
     * When there is a position a piece want to move to, pathContainOtherPieceOrNot will
     * check if there is any piece in between the current position and the target position.
     *  It will check vertical, horizontal, upleft, upright, downleft, and downright
     * direction.
     * @param row Current row position
     * @param col Current col position
     * @param targetRow Target row position
     * @param targetCol Target col position
     * @return Boolean. If there is nothing in between the current piece and target piece, return true, otherwise,
     * return false.
     */
    public boolean pathContainOtherPieceOrNot(int row, int col, int targetRow, int targetCol) {
        if(this.Board[row][col].ableToMove(targetRow, targetCol)) {
            //Vertical wise check
            if((col == targetCol) && (row != targetRow)) {
                if (targetRow > row) {
                    for(int i_down = row + 1; i_down < targetRow; i_down++) {
                        if(this.Board[i_down][col] != null) return false;
                    }
                    return true;
                }
                else {
                    for(int i_up = row - 1; i_up > targetRow; i_up--) {
                        if(this.Board[i_up][col] != null) return false;
                    }
                    return true;
                }

            }
            //Horizontal wise check
            else if((row == targetRow) && (col != targetCol)) {
                if(targetCol > col) {
                    for (int j_right = col + 1; j_right < targetCol; j_right++) {
                        if (this.Board[row][j_right] != null) return false;
                    }
                    return true;
                }
                else {
                    for (int j_left = col - 1; j_left > targetCol; j_left--) {
                        if(this.Board[row][j_left] != null) return false;
                    }
                    return true;
                }
            }
            //Diagnal wise check
            else {
                //Upright check
                if((targetRow < row) && (targetCol > col)) {
                    for (int i_upright = row - 1; i_upright < targetRow; i_upright--) {
                        for(int j_upright = col + 1; j_upright > targetCol; j_upright++) {
                            if(this.Board[i_upright][j_upright] != null) return false;
                        }
                    }
                    return true;
                }
                //Upleft check
                else if((targetRow < row) && (targetCol < col)) {
                    for(int i_upleft = row - 1; i_upleft < targetRow; i_upleft--) {
                        for(int j_upleft = col - 1; j_upleft < targetCol; j_upleft--) {
                            if(this.Board[i_upleft][j_upleft] != null) return false;
                        }
                    }
                    return true;
                }
                //Downleft check
                else if((targetRow > row) && (targetCol < col)) {
                    for(int i_downleft = row + 1; i_downleft < targetRow; i_downleft++) {
                        for (int j_downleft = col - 1; j_downleft > targetCol; j_downleft--) {
                            if(this.Board[i_downleft][j_downleft] != null) return false;
                        }
                    }
                    return true;
                }
                //Downright check
                else {
                    for(int i_downright = row + 1; i_downright > targetRow; i_downright++) {
                        for (int j_downright = col + 1; j_downright > targetCol; j_downright++) {
                            if(this.Board[i_downright][j_downright] != null)return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Helper function: when there is a piece at the aiming position, check
     * the piece and see if it is the same team piece or not, if it is,return
     * false, otherwise, return true.
     * @param moveToX Aming position row
     * @param moveToY Aming position col
     * @param teamColor Determine if it is black or white, 1: black. 0: white.
     * @return Boolean type
     */
    public boolean enemyOrNot(int moveToX, int moveToY, int teamColor) {
        if(pieceBlocked(moveToX, moveToY)) {
            if(teamColor == this.Board[moveToX][moveToY].pieceColor) return false;
            else return true;
        }
        else return false;
    }

    /**
     * Function for pieces to capture if there is another piece at the target
     * position. If it is enemy, clean the position and re-assign it to teammate.
     * And then free up the memory at the previous position
     * @param X Current teammate row
     * @param Y Current teammate col
     * @param enemyX Enemy/target position row
     * @param enemyY Enemy/target position col
     */
    public void chessCapture(int X, int Y, int enemyX, int enemyY) {
        if(enemyOrNot(enemyX, enemyY, this.Board[X][Y].pieceColor) && pathContainOtherPieceOrNot(X, Y, enemyX, enemyY)) {

            if (Board[enemyX][enemyY] instanceof ChessGame.ChessSixPieces.KingPiece) {
                if (Board[enemyX][enemyY].pieceColor == 0) {
                    whiteFlag = true;
                }
                else {
                    blackFlag = true;
                }
            }

            this.Board[enemyX][enemyY] = null;
            if(this.Board[X][Y] instanceof ChessGame.ChessSixPieces.KingPiece) {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.KingPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            else if(this.Board[X][Y] instanceof ChessGame.ChessSixPieces.QueenPiece) {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.QueenPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            else if(this.Board[X][Y] instanceof ChessGame.ChessSixPieces.BishopPiece) {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.BishopPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            else if(this.Board[X][Y] instanceof ChessGame.ChessSixPieces.KnightPiece) {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.KnightPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            else if(this.Board[X][Y] instanceof ChessGame.ChessSixPieces.RookPiece) {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.RookPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            else {
                this.Board[enemyX][enemyY] = new ChessGame.ChessSixPieces.PawnPiece(enemyX, enemyY,(this.Board[X][Y].pieceColor));
            }
            this.Board[X][Y] = null;
        }
    }

    /**
     * For this kingStatus function, it will check if ther king can move or not
     * if the target position is the same team, return false, otherwise return
     * true. And will take consideration when it is possible to move, the target
     * position is in dangerous or not.
     * @param row current row position
     * @param col current col position
     * @return
     */
    public boolean kingStatus(int row, int col) {
        for(int row_i = row - 1; row_i < row + 1; row_i++) {
            for (int col_j = col - 1; col_j < col + 1; col_j++) {
                if((row_i != row) && (col_j != col)) {
                    if(pieceBlocked(row_i, col_j)) {
                        if(enemyOrNot(row_i, col_j, this.Board[row_i][col_j].pieceColor)) {
                            if(kingSafeToMove(row_i, col_j, this.Board[row_i][col_j].pieceColor)) return true;
                        }
                    }
                    else {
                        if(kingSafeToMove(row_i, col_j, this.Board[row_i][col_j].pieceColor)) return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check if the king is safe to move to the certain position, if move to
     * the position have the danger to be captured by the enemy return false,
     * if it is safe to go to the position, then return true
     * @param row Current position for row
     * @param col Current position for col
     * @return Boolean
     */
    public boolean kingSafeToMove(int row, int col, int piece_color){
       for(int i = 0; i< 8; i++) {
           for(int j = 0; j < 8; j++) {
               if(this.Board[i][j].pieceColor != piece_color) {
                   if(pathContainOtherPieceOrNot(i, j, row, col) && this.Board[i][j].ableToMove(row, col)) {
                       return false;
                   }
               }
           }
       }
       return true;
    }

    /**
     * Function to check if the king is currently under the check condition,
     * if yes return true, otherwise return true
     * @param row Current row position
     * @param row Current col position
     * @return Boolean
     */
    public boolean isKingUnderCheckMateCondition(int row, int col) {
        for(int row_i = 0; row_i < 8; row_i++) {
            for(int col_j = 0; col_j < 8; col_j++) {
                if(enemyOrNot(row_i, col_j, this.Board[row_i][col_j].pieceColor)) {
                    if(this.Board[row_i][col_j].ableToMove(row, col)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Checkmate function checks if the game is under the checkmate condition,
     * which means it is the king is under the checkmate condition and it is
     * not safe to move at the same time
     * @param row King's current row
     * @param col King's current col
     * @return Boolean if under checkmate return true, else return false
     */
    public boolean checkMate(int row, int col) {
       if(isKingUnderCheckMateCondition(row, col) && (!kingSafeToMove(row, col, this.Board[row][col].pieceColor))) return true;
        else return false;
    }

    /**
     * Stalemate function checks if the game is under stalemate condition,
     * if the king is not under checkmate condition but it is not safe to move
     * at the same time, then it is under the stalemate condition
     * @param row Current king's row
     * @param col Current King's col
     * @return
     */
    public boolean stalemate(int row, int col) {
        if((!isKingUnderCheckMateCondition(row, col)) && (!kingSafeToMove(row, col, this.Board[row][col].pieceColor))) return true;
        else return false;
    }

    public int[] getKingPosition(int color) {
        if(color == 0) {
            return whiteKing;
        }
        else return blackKing;
    }

    /**
     *
     * @param color
     * @return
     */
    public boolean EndingConditionCheck(int color) {

        int [] king_pos = getKingPosition(1-color);


        if(checkMate(king_pos[0], king_pos[1])) {
            if (color == 0)
                System.out.println("White Win");
            else
                System.out.println("Black Win");
            return true;
        }
        else if (stalemate(king_pos[0], king_pos[1])) {
            System.out.println("Draw");
            return true;
        }
        else if (whiteFlag || blackFlag) {
            return true;
        }
        else return false;
    }


}