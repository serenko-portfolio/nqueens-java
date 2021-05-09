package processing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinesContainerTest {

    @Test
    void canLineBePlaced_fail() {
        LinesContainer container = new LinesContainer();
        container.addLine(new Line(2, 2, 3));
        boolean duplicated = container.canLineBePlaced(2, 2);
        assertFalse(duplicated);

    }


    @Test
    void canLineBePlaced_success() {
        LinesContainer container = new LinesContainer();
        container.addLine(new Line(2, 2, 3));
        boolean duplicated = container.canLineBePlaced(1, 2);
        assertTrue(duplicated);
    }

    @Test
    void addDotToLines_check_filled_success() {
        LinesContainer container = new LinesContainer();
        container.addLine(new Line(2, 2, 3));
        container.addDotToLines();
        boolean filled = container.isFilled();
        assertFalse(filled);
        container.addDotToLines();
        filled = container.isFilled();
        assertTrue(filled);
    }


    @Test
    void addDotToLines_check_filled_fail() {
        LinesContainer container = new LinesContainer();
        container.addLine(new Line(2, 2, 3));
        container.addDotToLines();
        boolean filled = container.isFilled();
        assertFalse(filled);
    }

    @Test
    void removeDotFromLines() {
        LinesContainer container = new LinesContainer();
        container.addLine(new Line(2, 2, 3));
        container.addDotToLines();
        boolean filled = container.isFilled();
        assertFalse(filled);
        container.addDotToLines();
        filled = container.isFilled();
        assertTrue(filled);
        container.removeDotFromLines();
        filled = container.isFilled();
        assertFalse(filled);
    }
}