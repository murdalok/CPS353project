package integration;

import project.processapi.IntegerData;

import java.util.List;

public class InMemoryIntegerData implements IntegerData {

    private final List<Integer> data;

    public InMemoryIntegerData(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }
}