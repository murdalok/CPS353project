package project.processapi;

import project.IntegerDataset;
import project.annotations.ProcessAPIPrototype;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

import java.util.List;

public class DataStorageAPIPrototype {

    @ProcessAPIPrototype
    public void prototype(DataStorageAPI storage) {
        //input output information
        InputSource input = new InputSource() {};
        OutputDestination outputDestination= new OutputDestination() {};
        // Job handler asks for integer data
        IntegerData integerData = storage.read(input);

        //job Handler provides result
        IntegerData result = new IntegerDataset(List.of()) {};

        //Job handler asks to store result
        storage.write(outputDestination, result);

    }
}
