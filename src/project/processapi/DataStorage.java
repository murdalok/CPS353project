package project.processapi;

import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataStorage implements DataStorageAPI {

    @Override
    public IntegerData read(InputSource input) {
        try {
            Path path = Objects.requireNonNull(input.getPath(), "input can not be null");

            if (!Files.isRegularFile(path)) {
                throw new IllegalArgumentException("Input is not an existing file: " + path);
            }
            if (!Files.isReadable(path)) {
                throw new IllegalArgumentException("Input file is not readable: " + path);
            }

            List<String> lines = Files.readAllLines(path);
            List<Integer> integers = new ArrayList<>();


            for (String line : lines) {
                integers.add(Integer.parseInt(line.trim()));
            }

            return new IntegerDataset(integers);

        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read file", e);
        }
    }

    @Override
    public void write(OutputDestination output, IntegerData data, Delimiter delimiter) {
        Objects.requireNonNull(output, "output can not be null");
        Path path = Objects.requireNonNull(output.getPath(), "output path can not be null");
        Objects.requireNonNull(data, "data must not be null");
        Objects.requireNonNull(delimiter, "delimiter must not be null");

        List<String> results = new ArrayList<>();

        for (int number : data.getIntegers()) {
            results.add(Integer.toString(number));
        }

        String content = String.join(delimiter.getDelimiter(), results);

        try {
            Files.writeString(output.getPath(), content);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to write to file", e);
        }

    }
}