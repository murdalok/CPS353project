package project.jobhandler;

import project.conceptualapi.ComputationAPI;
import project.networkapi.ComputeEngineAPI;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.JobResponse;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

public class JobHandler implements ComputeEngineAPI {


    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public JobHandler(DataStorageAPI storage, ComputationAPI computation) {
        this.storage = storage;
        this.computation = computation;
    }

    @Override
    public JobResponse submitJobRequest(InputSource inputSource, OutputDestination outputDestination, Delimiter delimiter) {
        return null;
    }
}
