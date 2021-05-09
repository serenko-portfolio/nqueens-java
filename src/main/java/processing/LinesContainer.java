package processing;

import java.util.ArrayList;
import java.util.List;

public class LinesContainer {
    private final List<Line> lines;

    public LinesContainer() {
        lines = new ArrayList<>();
    }

    public boolean canLineBePlaced(int dX, int dY) {
        return lines.stream().noneMatch(t -> checkDuplicatesAndReflections(t, dX, dY));
    }

    private boolean checkDuplicatesAndReflections(Line source, int dX, int dY) {
        return source.getDX() == -dX && source.getDY() == -dY || source.getDX() == dX && source.getDY() == dY;
    }

    public boolean isFilled() {
        return lines.stream().anyMatch(Line::isLineBusy);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void addDotToLines() {
        lines.forEach(Line::add);
    }

    public void removeDotFromLines() {
        lines.forEach(Line::remove);
    }

}
