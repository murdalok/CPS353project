package project;

import project.processapi.IntegerData;
import java.util.List;

public class IntegerDataset implements IntegerData {
    private final List<Integer> data;

    public IntegerDataset(List<Integer> data) {
        this.data = List.copyOf(data);
    }

    @Override
    public List<Integer> getIntegers() {
        return this.data;
    }
}
