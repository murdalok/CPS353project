package integration;

import project.networkapi.InputSource;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

public class InMemoryDataStorage implements DataStorageAPI {

    @Override
    public IntegerData read(InputSource input) {

        InMemoryInputSource source = (InMemoryInputSource) input;

        return new InMemoryIntegerData(source.getInput());
    }

    @Override
    public void write(
            OutputDestination output, IntegerData data) {

        InMemoryOutputDestination destination = (InMemoryOutputDestination) output;

        InMemoryIntegerData integerData = (InMemoryIntegerData) data;

        for (Integer value : integerData.getData()) {
            destination.getOutput().add(
                    value.toString()
            );
        }
    }
}