package processing;

import java.util.Arrays;

public class NQueens {
    private final int[] board;
    private final boolean[] horizontal;
    private final boolean[] diag45;
    private final boolean[] diag135;
    private final LinesProcessor field;
    private final int n;

    public NQueens(int n, int dots) {
        board = new int[n];
        horizontal = new boolean[n];
        diag45 = new boolean[n * 2 - 1];
        diag135 = new boolean[n * 2 - 1];
        this.field = new LinesProcessor( n, dots);
        this.n = n;
        Arrays.fill(board, -1);
    }

    public int[] getBoard() {
        return board;
    }

    private boolean isSafe(int index, int value) {
        return !(horizontal[value] ||
                diag45[n + index - value - 1] ||
                diag135[n + n - index - value - 2] ||
                field.isFilled(index, value));
    }

    private void stepForward(int index, int value) {
        diag45[n + index - value - 1] = true;
        diag135[n + n - index - value - 2] = true;
        horizontal[value] = true;
        field.addDot(index, value);
    }

    private void stepBack(int index, int value) {
        diag45[n + index - value - 1] = false;
        diag135[n + n - index - value - 2] = false;
        horizontal[value] = false;
        board[index] = -1;
        field.remove(index, value);
    }

    public boolean isSolvable() {
        return run(0);
    }

    private boolean run(int index) {
        if (index >= this.n)
            return true;
        for (int i = 0; i < this.n; i++) {
            if (isSafe(index, i)) {
                stepForward(index, i);
                board[index] = i;
                if (run(index + 1))
                    return true;
                stepBack(index, i);
            }
        }
        return false;
    }

}
