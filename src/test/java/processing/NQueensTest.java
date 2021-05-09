package processing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    @Test
    void isSolvable_success() {
        NQueens nQueens = new NQueens(9, 3);
        boolean result = nQueens.isSolvable();
        nQueens.getBoard();
        assertTrue(result);
        int[] source = {1, 3, 6, 0, 2, 8, 5, 7, 4};
        assertArrayEquals(source, nQueens.getBoard());
    }


    @Test
    void isSolvable_false() {
        NQueens nQueens = new NQueens(7, 3);
        boolean result = nQueens.isSolvable();
        nQueens.getBoard();
        assertFalse(result);

    }


    @Test
    void isSolvable_no_three_dot_line_success() {
        NQueens nQueens = new NQueens(4, 3);
        boolean result = nQueens.isSolvable();
        nQueens.getBoard();
        assertTrue(result);
        int[] source = {1, 3, 0, 2};
        assertArrayEquals(source, nQueens.getBoard());
    }


    @Test
    void isSolvable_custom_dots_success() {
        NQueens nQueens = new NQueens(9, 4);
        boolean result = nQueens.isSolvable();
        nQueens.getBoard();
        assertTrue(result);
        int[] source = {0, 2, 5, 7, 1, 3, 8, 6, 4};
        assertArrayEquals(source, nQueens.getBoard());
    }


    @Test
    void isSolvable_custom_dots_fail() {
        NQueens nQueens = new NQueens(3, 4);
        boolean result = nQueens.isSolvable();
        nQueens.getBoard();
        assertFalse(result);
    }
}