import org.apache.commons.cli.Options;
import processing.NQueens;

public class Main {

    public static void main(String args[]) {
        Options defaultOptions = Utils.getDefaultOptions();
        int size = Utils.getOrDefault(args, defaultOptions, "n", Config.N_SIZE);
        int dots = Utils.getOrDefault(args, defaultOptions, "dots", Config.DOTS_IN_LINE);
        Long a = System.currentTimeMillis();
        NQueens qns = new NQueens(size, dots);
        Long b = System.currentTimeMillis();

        boolean result = qns.isSolvable();
        Long c = System.currentTimeMillis();
        if (result) {
            Utils.printMatrix(qns.getBoard());
        } else {
            System.out.println("There is no solution for given parameters");
        }
        System.out.println("Field initialisation time (ms):" + (b - a));
        System.out.println("Execution time (ms):" + (c - b));
    }
}
