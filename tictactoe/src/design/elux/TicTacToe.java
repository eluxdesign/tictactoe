package design.elux;

public class TicTacToe {

    private final String[][] board;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private final String regex = "   ";

    public TicTacToe() {
        board = new String[ROWS][COLS];
    }

    //INITIALIZE BOARD
    public void initializeBoard() {
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                board[i][j] = "   ";
            }
        }
    }
    //PRINT BOARD
    public String printBoard() {
        String strBoard = "";
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(j != COLS-1) {
                    strBoard = strBoard + board[i][j] + "|";
                } else {
                    strBoard = strBoard + board[i][j];
                }
            }
            if (i != COLS - 1) {
                strBoard = strBoard + "\n___+___+___\n";
            }
        }
        return strBoard;
    }

    //SETTING PLAYER MOVE
    public boolean setPlay(int i, int j, String player) {
        if(this.board[i][j].matches(regex)) {
            board[i][j] = " " + player + " ";
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        //CHECK ROWS
        for(int i=0; i<ROWS; i++) {
                if(!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                    return true;
            }
        }
        //CHECK COLS
            for(int i=0; i<COLS; i++) {
                if(!board[0][i].matches(regex) && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                    return true;
            }
        }
        //CHECK DIAGONALS
        if(!board[2][0].matches(regex) && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            return true;
        }
        return !board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]);

    }

    public boolean isGameOverWithoutWinner() {
            for(int i=0; i<ROWS; i++) {
                for(int j=0; j<COLS; j++) {
                    if(board[i][j].matches(regex)) {
                        return false;
                    }
                }
            }
        return true;
    }
}