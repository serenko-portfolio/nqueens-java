package processing;


public class Line {
    private int occurrences = 0;
    private final int dX;
    private final int dY;
    private final int maxDotsAllowed;

    public Line(int dX, int dY, int maxDots) {
        this.dX = dX;
        this.dY = dY;
        this.maxDotsAllowed = maxDots - 1;
    }

    public int getDX() {
        return dX;
    }

    public int getDY() {
        return dY;
    }

    public boolean isLineBusy() {
        return occurrences == maxDotsAllowed;
    }

    public void add() {
        occurrences++;
    }

    public void remove() {
        occurrences--;
    }

}
