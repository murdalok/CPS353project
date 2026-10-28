package integration;

import project.networkapi.InputSource;

import java.nio.file.Path;
import java.util.List;

public class InMemoryInputSource implements InputSource {

    private final List<Integer> input;

    public InMemoryInputSource(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getInput() {
        return input;
    }

    @Override
    public Path getPath() {
        return null;
    }
}