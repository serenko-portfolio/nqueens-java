package processing;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LinesProcessorTest {

    @Test
    void constructor_test() {
        LinesProcessor processor = new LinesProcessor(4, 3);
        IntStream.range(0, 4).forEach(i ->
                IntStream.range(0, 4).forEach(j -> {
                    boolean filled = processor.isFilled(i, j);
                    assertFalse(filled);
                }));
    }

    @Test
    void isFilled_null_filled() {
        LinesProcessor processor = new LinesProcessor(4, 3);
        processor.addDot(1, 1);
        processor.addDot(2, 1);
        boolean filled = processor.isFilled(2, 1);
        assertFalse(filled);
    }

    @Test
    void isFilled_success() {
        LinesProcessor processor = new LinesProcessor(7, 3);
        processor.addDot(0, 0);
        processor.addDot(2, 1);
        boolean filled = processor.isFilled(2, 1);
        assertTrue(filled);
    }


    @Test
    void isFilled_false() {
        LinesProcessor processor = new LinesProcessor(7, 3);
        processor.addDot(0, 0);
        boolean filled = processor.isFilled(2, 1);
        assertFalse(filled);
    }


    @Test
    void addDot() {
    }

    @Test
    void remove() {
        LinesProcessor processor = new LinesProcessor(7, 3);
        processor.addDot(0, 0);
        processor.addDot(2, 1);
        boolean filled = processor.isFilled(2, 1);
        assertTrue(filled);
        processor.remove(0, 0);
        filled = processor.isFilled(2, 1);
        assertFalse(filled);

    }
}