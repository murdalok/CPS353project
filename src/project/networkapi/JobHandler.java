package project.networkapi;

import project.conceptualapi.ComputationAPI;
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

        IntegerData input = this.storage.read(inputSource);

        IntegerData result = this.computation.compute(input);

        this.storage.write(outputDestination, result, delimiter);

        return new ComputeJobResponse(JobResponseCode.SUCCESS, "Job completed successfully");
    }
}
