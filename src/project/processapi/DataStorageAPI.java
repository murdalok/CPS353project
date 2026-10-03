package project.processapi;

import project.annotations.ProcessAPI;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

@ProcessAPI
public interface DataStorageAPI {

    IntegerData read();

    void write();
}
