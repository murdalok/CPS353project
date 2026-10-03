package project.jobhandler;

import project.conceptualapi.ComputationAPI;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.JobRequest;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;

public class JobHandler {


    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public JobHandler(DataStorageAPI storage, ComputationAPI computation) {
        this.storage = storage;
        this.computation = computation;
    }

    public void handleJob(JobRequest jobRequest) {
        //get input source from jobRequest
        InputSource inputSource;
        // get output source
        OutputDestination outputDestination;
        //get Delimiter
        Delimiter delimiter;

        // Job Handler asks storage to read input source
       IntegerData integerData = storage.read();

       // Job handler asks for result
        computation.compute(integerData);

        // Job Handler asks storage to write the result
        storage.write();
    }
}
