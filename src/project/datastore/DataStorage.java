package project.datastore;

import project.IntegerDataset;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataStorage implements DataStorageAPI {

    @Override
    public IntegerData read(InputSource input) {
        try {
            Path path = input.getPath();
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