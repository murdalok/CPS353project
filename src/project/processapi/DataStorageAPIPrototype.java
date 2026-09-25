package project.processapi;

import project.annotations.ProcessAPIPrototype;

public class DataStorageAPIPrototype {

    @ProcessAPIPrototype
    public void prototype(DataStorageAPI storage) {
        //specify the data input source
        DataInputSource inputSource = null;

        //read integer data
        IntegerData input = storage.read(inputSource);

        //specify output destination
        DataOutputDestination outputDestination = null;

        //write inter data to data storage
        storage.write(outputDestination, input);

    }
}
