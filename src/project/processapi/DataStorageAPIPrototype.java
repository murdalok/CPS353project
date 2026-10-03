package project.processapi;

import project.annotations.ProcessAPIPrototype;

public class DataStorageAPIPrototype {

    @ProcessAPIPrototype
    public void prototype(DataStorageAPI storage) {
        // Job handler asks for integer data
        IntegerData integerData = storage.read();

        //job Handler provides result
        IntegerData result;

        //Job handler asks to store result
        storage.write();

    }
}
