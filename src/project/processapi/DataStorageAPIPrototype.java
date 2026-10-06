package project.processapi;

import project.annotations.ProcessAPIPrototype;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

public class DataStorageAPIPrototype {

    @ProcessAPIPrototype
    public void prototype(DataStorageAPI storage) {
        //input output information
        InputSource input;
        OutputDestination outputDestination;
        // Job handler asks for integer data
        IntegerData integerData = storage.read(input);

        //job Handler provides result
        IntegerData result;

        //Job handler asks to store result
        storage.write(outputDestination, result);

    }
}
