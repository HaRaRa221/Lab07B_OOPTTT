import javax.swing.*;

public class TicTacToeGame {

    private static final int ROW = 3;
    private static final int COL = 3;

    private static String[][] board = new String[ROW][COL];

    public static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++){
                board[row][col] = " ";
            }
        }
    }

    public static void updateGame(String contender, int row, int col)
    {
        board[row][col] = contender;
    }
    public static boolean isWin(String contender) {
        if(isColWin(contender) || isRowWin(contender) || isDiagnalWin(contender))
        {
            return true;
        }
        return false;
    }
    private static boolean isDiagnalWin(String contender) {
        if(board[0][0].equals(contender) &&
                board[1][1].equals(contender) &&
                board[2][2].equals(contender) )
        {
            return true;
        }
        if(board[0][2].equals(contender) &&
                board[1][1].equals(contender) &&
                board[2][0].equals(contender) )
        {
            return true;
        }
        return false;
    }
    private static boolean isRowWin(String contender) {
        // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals(contender) &&
                    board[row][1].equals(contender) &&
                    board[row][2].equals(contender))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isColWin(String contender) {
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals(contender) &&
                    board[1][col].equals(contender) &&
                    board[2][col].equals(contender))
            {
                return true;
            }
        }
        return false; // no col win
    }
    public static boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X") )
        {
            xFlag = true;
        }
        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }

        // Checked every vector so I know I have a tie
        return true;
    }
}
