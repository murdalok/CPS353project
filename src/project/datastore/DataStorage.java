package project.datastore;

import project.networkapi.InputSource;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

public class DataStorage implements DataStorageAPI {

    @Override
    public IntegerData read(InputSource input) {
        return null;
    }

    @Override
    public void write(OutputDestination output, IntegerData data) {

        // logic
    }
}