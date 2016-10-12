package ChessGame;


import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JMenuBar;




/**
 * Created by Amy on 9/14/16.
 */
public class ChessGameGUI extends JPanel {
    //Create each piece grid using JButton
    JButton[][] chessPieceGrids = new JButton[8][8];
    ChessGameBoard currentBoard;
    JPanel main_panel = new JPanel();
    JFrame chessBoardFrame;
    ChessGamePieces currentPiece;
    ChessGamePieces[][] chessPieceBoard;
    boolean playerWhiteFlag = true;
    boolean playerBlackFlag = false;

    int white_score = 0;
    int black_score = 0;

    private Stack<ChessGameBoard> whiteUndoStack;
    private Stack<ChessGameBoard> blackUndoStack;
    /**
     * ChessGameGui function will create the board by using the Jbutton
     * Have chessGrindCount to keep track of the creating piece, if the
     * current grid is divisible by 2, then it is white, otherwise it is
     * black grid
     */
    public ChessGameGUI() {

        chessBoardFrame = new JFrame();
        chessBoardFrame.setSize(800, 800);
        chessBoardFrame.setLocationRelativeTo(null);
        chessBoardFrame.add(main_panel);
        //new game button
        JMenuBar chessGameMenu = new JMenuBar();
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(restartANewGame());
        restartButton.setForeground(Color.RED);
        chessGameMenu.add(restartButton);
        //Forfeit Button
        JButton forfeitButton = new JButton("Forfeit");
        forfeitButton.setForeground(Color.BLUE);
        chessGameMenu.add(forfeitButton);
        //Undo Button
        JButton undoButton = new JButton("Undo");
       // undoButton.addActionListener(undoTheMove());
        undoButton.setForeground(Color.BLUE);
        chessGameMenu.add(undoButton);
        //Add player name
        JLabel playerOneName = new JLabel("Player 1");
        chessGameMenu.add(playerOneName, BorderLayout.WEST);
        String player1Name = JOptionPane.showInputDialog("Player 1 enter your name");
        playerOneName.setText("Player 1: "+ player1Name + " Score: ");
        playerOneName.setForeground(Color.GREEN);

        JLabel score_white = new JLabel("");
        score_white.setText(String.valueOf(white_score));
        chessGameMenu.add(score_white, BorderLayout.WEST);
        //Add player two
        JLabel playerTwoName = new JLabel("Player 1");
        chessGameMenu.add(playerTwoName, BorderLayout.WEST);
        String player2Name = JOptionPane.showInputDialog("Player 2 enter your name, and please do not enter "+ player1Name);
        playerTwoName.setText(" Player 2: "+ player2Name + " Score: ");
        playerTwoName.setForeground(Color.GREEN);

        JLabel score_black = new JLabel("");
        score_black.setText(String.valueOf(black_score));
        chessGameMenu.add(score_black, BorderLayout.WEST);
        JOptionPane.showMessageDialog(chessBoardFrame, "White piece will move first.");

        chessBoardFrame.setJMenuBar(chessGameMenu);
        currentBoard = new ChessGameBoard();

        updateBoard();
        chessBoardFrame.setVisible(true);
        chessBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateBoard() {
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();

        main_panel.setLayout(new GridLayout(8, 8));
//        currentBoard = new ChessGameBoard();
        chessPieceBoard = currentBoard.currentChessBoard();
        int chessGridCount = 0;

        for (int piece_row = 0; piece_row < 8; piece_row++, chessGridCount++) {
            for (int piece_col = 0; piece_col < 8; piece_col++) {
                chessPieceGrids[piece_row][piece_col] = new JButton();
                chessPieceGrids[piece_row][piece_col].setOpaque(true);
                chessPieceGrids[piece_row][piece_col].setBorder(null);
                if (chessGridCount % 2 == 0) {
                    chessPieceGrids[piece_row][piece_col].setBackground(Color.white);
                } else {
                    chessPieceGrids[piece_row][piece_col].setBackground(Color.black);
                }
                if (chessPieceBoard[piece_row][piece_col] != null) {
                    ImageIcon pieceImage = chessPieceBoard[piece_row][piece_col].getPieceImage();
                    Image theNewImage = pieceImage.getImage();
                    theNewImage = theNewImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                    ImageIcon finalNewImage = new ImageIcon(theNewImage);
                    chessPieceGrids[piece_row][piece_col].setIcon(finalNewImage);
                }
                main_panel.add(chessPieceGrids[piece_row][piece_col]);
                chessPieceGrids[piece_row][piece_col].addActionListener(moveThePiece(piece_row,piece_col));
                chessGridCount++;
            }
        }
    }

    /**
     * This function will do the actual movement on the chess game board
     * it will also block the user to click any empty space at the first time
     * It also contains function that will make sure the user can move one step each time
     * and switch to the other user.
     * @param current_row The current piece row
     * @param current_col The current piece col
     * @return
     */
    private ActionListener moveThePiece(final int current_row, final int current_col) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChessGamePieces targetPiece;

                if(currentPiece == null) {
                    if (chessPieceBoard[current_row][current_col] == null) {
                        JOptionPane.showMessageDialog(chessBoardFrame, "You cannot click empty first!!!");
                        return;
                    }
                    else {
                        currentPiece = chessPieceBoard[current_row][current_col];

                        if (playerWhiteFlag) {
                            if (currentPiece.pieceColor != 0) {
                                JOptionPane.showMessageDialog(chessBoardFrame, "Please do not touch others piece!");
                                currentPiece = null;
                                return;
                            }
                        }

                        if (playerBlackFlag) {
                            if (currentPiece.pieceColor != 1) {
                                JOptionPane.showMessageDialog(chessBoardFrame, "Please do touch others piece!");
                                currentPiece = null;
                                return;
                            }
                        }
                        return;
                    }
                }

                if (chessPieceBoard[currentPiece.position_row][currentPiece.position_col].ableToMove(current_row, current_col) && currentBoard.pathContainOtherPieceOrNot(currentPiece.position_row, currentPiece.position_col, current_row, current_col)) {
                    currentBoard.movingPiece(currentPiece.position_row, currentPiece.position_col, current_row, current_col);

//                    if(currentBoard.EndingConditionCheck(currentPiece.pieceColor)) {
//                        if (currentBoard.whiteFlag)
//                            white_score++;
//                        else
//                            black_score++;
//                    }
//
                    if(currentPiece.pieceColor == 0) {
                        playerWhiteFlag = false;
                        playerBlackFlag = true;
                    }
                    else {
                        playerWhiteFlag = true;
                        playerBlackFlag = false;
                    }

                    updateBoard();
                }
                else {
                    JOptionPane.showMessageDialog(chessBoardFrame, "Invalid Move!");
                    return;
                }



//                updateBoard();
                currentPiece = null;
            }
        };
    }

    /**
     * This restart a new game function will basically restart a new game when the
     * player agree to restart when they press therestart button.
     * @return
     */
    private ActionListener restartANewGame() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int agreement;
                if (playerWhiteFlag) {
                    agreement = JOptionPane.showConfirmDialog(chessBoardFrame, "White piece want to restart the game. Do you agree?", "Restart", JOptionPane.YES_NO_OPTION);
                }
                else {
                    agreement = JOptionPane.showConfirmDialog(chessBoardFrame, "Black piece want to restart the game. Do you agree?", "Restart", JOptionPane.YES_NO_OPTION);
                }
                if(agreement == JOptionPane.YES_OPTION) {
                    currentBoard = new ChessGameBoard();
                    playerWhiteFlag = true;
                    playerBlackFlag = false;
                    updateBoard();
                }
            }
        };
    }

//    /**
//     * This function will help the user to undo what they just moved
//     * so the piece can go back to its last position.
//     * @return
//     */
//    private ActionListener undoTheMove() {
//        return new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(currentPiece.pieceColor == 0) {
//                    if(whiteUndoStack.empty()) {
//                        JOptionPane.showMessageDialog(chessBoardFrame, "There is nothing to undo!");
//                        return;
//                    }
//                    else {
//                        currentBoard = whiteUndoStack.pop().copy();
//                        updateBoard();
//                    }
//
//                }
//                if(currentPiece.pieceColor == 1) {
//                    if(blackUndoStack.empty()) {
//                        JOptionPane.showMessageDialog(chessBoardFrame, "There is nothing to undo!");
//                        return;
//                    }
//                    else {
//                        currentBoard = blackUndoStack.pop().copy();
//                        updateBoard();
//                    }
//                }
//            }
//        };
//
//    }


    /**
     * The main function for the chess game. It will mainly set up the board size for the chess board.
     * @param args
     */
    public static void main(String[] args) {
        new ChessGameGUI();
    }

}