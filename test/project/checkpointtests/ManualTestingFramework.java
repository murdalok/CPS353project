package project.checkpointtests;

import project.networkapi.FileInputSource;
import project.networkapi.FileOutputDestination;
import project.networkapi.ResultDelimiter;
import project.conceptualapi.ComputationHandler;
import project.conceptualapi.ComputationAPI;
import project.processapi.DataStorage;
import project.networkapi.JobHandler;
import project.networkapi.ComputeEngineAPI;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.JobResponse;
import project.networkapi.OutputDestination;
import project.processapi.DataStorageAPI;

import java.nio.file.Paths;

public class ManualTestingFramework {
    
    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        // TODO 1:
        // Instantiate a real (ie, class definition lives in the src/ folder) implementation 
        // of all 3 APIs
        ComputationAPI computationHandler = new ComputationHandler();
        DataStorageAPI dataStorage = new DataStorage();
        ComputeEngineAPI jobHandler = new JobHandler(dataStorage, computationHandler);
        //
        // TODO 2:
        // Run a computation with an input file of <root project dir>/manualTestInput.txt
        // and an output of <root project dir>/manualTestOutput.txt, with a delimiter of ','
        Delimiter delimiter = new ResultDelimiter(",");
        InputSource inputSource = new FileInputSource(Paths.get(INPUT));
        OutputDestination outputDestination = new FileOutputDestination(Paths.get(OUTPUT));
        JobResponse response = jobHandler.submitJobRequest(inputSource, outputDestination, delimiter);
        //
        //
        // Helpful hint: the working directory of this program is <root project dir>,
        // so you can refer to the files just using the INPUT/OUTPUT constants. You do not 
        // need to (and should not) actually create those files in your repo
    }
}
