package integration;

import project.networkapi.OutputDestination;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOutputDestination implements OutputDestination {

    private final List<String> output;

    public InMemoryOutputDestination() {
        this.output = new ArrayList<>();
    }

    public List<String> getOutput() {
        return output;
    }
}