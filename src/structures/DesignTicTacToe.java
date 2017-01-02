package structures;

/**
 * Created by xuanwang on 1/1/17.
 */
public class DesignTicTacToe {
    int[] r;
    int[] c;
    int diag = 0;
    int adig = 0;
    int n;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        this.n = n;
        r = new int[n];
        c = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int pc =player == 1 ? -1 : 1;
        r[row] += pc;
        if(Math.abs(r[row]) == n) return player;

        c[col] += pc;
        if(Math.abs(c[col]) == n) return player;

        if(row == col) diag += pc;
        if(Math.abs(diag) == n) return player;

        if(row + col == n - 1) adig += pc;
        if(Math.abs(adig) ==  n) return player;
        return 0;
    }

}
