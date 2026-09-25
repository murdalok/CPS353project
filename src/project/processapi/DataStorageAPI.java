package project.processapi;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {

    IntegerData read(DataInputSource inputSource);

    void write(DataOutputDestination destination, IntegerData data);
}
