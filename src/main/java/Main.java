import org.apache.commons.cli.Options;
import org.apache.commons.lang3.time.StopWatch;
import processing.NQueens;

public class Main {

    public static void main(String args[]) {
        Options defaultOptions = Utils.getDefaultOptions();
        int size = Utils.getOrDefault(args, defaultOptions, "n", Config.N_SIZE);
        int dots = Utils.getOrDefault(args, defaultOptions, "dots", Config.DOTS_IN_LINE);
        StopWatch watchInit = new StopWatch();
        StopWatch watchProcess = new StopWatch();
        watchInit.start();
        NQueens qns = new NQueens(size, dots);
        watchInit.stop();
        watchProcess.start();
        boolean result = qns.isSolvable();
        watchProcess.stop();
        if (result) {
            Utils.printMatrix(qns.getBoard());
        } else {
            System.out.println("There is no solution for given parameters");
        }
        System.out.println("Field initialisation time (ms):" + watchInit.getTime());
        System.out.println("Execution time (ms):" + watchProcess.getTime());
    }
}
