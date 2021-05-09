import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;

public class Utils {


    public static Option addOption(String name, String description) {
        Option option = new Option(name, name, true, description);
        option.setRequired(false);
        return option;
    }

    public static Options getDefaultOptions() {
        Options options = new Options();
        options.addOption(Utils.addOption("n", "input N, integer "));
        options.addOption(Utils.addOption("dots", "number of dots, integer"));
        return options;
    }

    public static Integer getOrDefault(String[] args, Options options, String name, Integer defValue) {
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            String value = cmd.getOptionValue(name);
            if (StringUtils.isNumeric(value)) {
                return Integer.parseInt(value);
            }
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
        return defValue;
    }

    public static void printMatrix(int[] matrix) {
        for (int index : matrix) {
            int i = 0;
            while (i < matrix.length) {
                if (i == index) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
                i++;
            }
            System.out.println();
        }
    }
}
