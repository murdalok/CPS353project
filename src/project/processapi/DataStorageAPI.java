package project.processapi;

import project.annotations.ProcessAPI;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

@ProcessAPI
public interface DataStorageAPI {

    IntegerData read(InputSource input);

    void write(OutputDestination output, IntegerData data);
}
