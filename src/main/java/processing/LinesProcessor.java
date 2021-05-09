package processing;
import java.util.stream.IntStream;


public class LinesProcessor {
    private final LinesContainer[][] linesField;
    private final int n;
    private final int dots;

    public LinesProcessor(int n, int dots) {
        this.n = n;
        this.dots = dots;
        linesField = new LinesContainer[n][n];
        int spaceMax = 1 + (n - dots) / (dots - 1);
        if (spaceMax > 1) {
            IntStream.range(0, n).forEach(i ->
                    IntStream.range(0, n).forEach(j -> initLine(i, j, spaceMax)));
        }
    }

    private void initLine(int x, int y, int deltaMax) {
        if (canWePutAnyLine(x, y)) {
            IntStream.range(-deltaMax, deltaMax + 1).forEach(dX ->
                    IntStream.range(-deltaMax, deltaMax + 1).
                    filter(dy -> dX * dy != 0 && Math.abs(dX) != Math.abs(dy) && canWePutGivenLine(x, y, dX, dy)).
                    forEach(dY -> drawTheLine(x, y, dX, dY)));
        }
    }

    private boolean canWePutAnyLine(int x, int y) {
        int deltaMin = 4;
        return insideBorder(x + deltaMin) || insideBorder(x - deltaMin) ||
                insideBorder(y + deltaMin) || insideBorder(y - deltaMin);
    }

    private void drawTheLine(int x, int y, int dX, int dY) {
        int currentX = x;
        int currentY = y;
        LinesContainer items = getOrCreate(currentX, currentY);
        if (items.canLineBePlaced(dX, dY)) {
            Line d = new Line(dX, dY, dots);
            while (insideBorder(currentX) && insideBorder(currentY)) {
                items = getOrCreate(currentX, currentY);
                items.addLine(d);
                currentX += dX;
                currentY += dY;
            }
        }
    }

    private LinesContainer getOrCreate(int currentX, int currentY) {
        LinesContainer items = linesField[currentX][currentY];
        if (items == null) {
            items = new LinesContainer();
            linesField[currentX][currentY]= items;
        }
        return items;
    }

    private boolean insideBorder(int coordinate) {
        return coordinate >= 0 && coordinate < n;
    }

    private boolean canWePutGivenLine(int x, int y, int dx, int dy) {
        int finalX = x + dx * (dots - 1);
        int finalY = y + dy * (dots - 1);
        return finalX >= 0 && finalX <= n && finalY >= 0 && finalY <= n;
    }


    public boolean isFilled(int x, int y) {
        LinesContainer container = linesField[x][y];
        if (container != null) {
            return container.isFilled();
        }
        return false;
    }

    public void addDot(int x, int y) {
        LinesContainer container = linesField[x][y];
        if (container != null) {
            container.addDotToLines();
        }
    }

    public void remove(int x, int y) {
        LinesContainer container = linesField[x][y];
        if (container != null) {
            container.removeDotFromLines();
        }
    }
}
