package project.networkapi;

public class ResultDelimiter implements Delimiter {
    private final String delimiter;
    private static final String DEFAULT_DELIMITER = ";";

    public ResultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    public ResultDelimiter() {
        this(DEFAULT_DELIMITER);
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }
}
