package project.jobhandler;

import project.conceptualapi.ComputationAPI;
import project.processapi.DataInputSource;
import project.processapi.DataOutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

public class JobHandler {


    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public JobHandler(DataStorageAPI storage,
                      ComputationAPI computation) {
        this.storage = storage;
        this.computation = computation;
    }

    public void handleJob(DataInputSource inputSource, DataOutputDestination outputDestination) {

        // Job Handler asks storage to read the input
        IntegerData input = storage.read(inputSource);

        // Job Handler asks computation component to perform the math
        IntegerData result = computation.compute(input);

        // Job Handler asks storage to write the result
        storage.write(outputDestination, result);
    }
}
