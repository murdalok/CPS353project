package project.checkpointtests;

import project.FileInputSource;
import project.FileOutputDestination;
import project.ResultDelimiter;
import project.computation.ComputationHandler;
import project.datastore.DataStorage;
import project.jobhandler.JobHandler;
import project.processapi.IntegerData;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ManualTestingFramework {
    
    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        // TODO 1:
        // Instantiate a real (ie, class definition lives in the src/ folder) implementation 
        // of all 3 APIs
        ComputationHandler computationHandler = new ComputationHandler();
        DataStorage dataStorage = new DataStorage();
        JobHandler jobHandler = new JobHandler(dataStorage, computationHandler);
        //
        // TODO 2:
        // Run a computation with an input file of <root project dir>/manualTestInput.txt
        // and an output of <root project dir>/manualTestOutput.txt, with a delimiter of ','
        ResultDelimiter delimiter = new ResultDelimiter(",");
        Path inputPath = Paths.get(INPUT);
        Path outputPath = Paths.get(OUTPUT);
        FileInputSource inputSource = new FileInputSource(inputPath);
        FileOutputDestination outputDestination = new FileOutputDestination(outputPath);
        IntegerData result = computationHandler.compute(dataStorage.read(inputSource));
        dataStorage.write(outputDestination, result, delimiter);
        //
        //
        // Helpful hint: the working directory of this program is <root project dir>,
        // so you can refer to the files just using the INPUT/OUTPUT constants. You do not 
        // need to (and should not) actually create those files in your repo
    }
}
