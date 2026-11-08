package project.networkapi;

import project.conceptualapi.ComputationAPI;
import project.processapi.DataStorageAPI;
import project.processapi.IntegerData;
import java.io.UncheckedIOException;
import java.util.Objects;

public class JobHandler implements ComputeEngineAPI {
    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public JobHandler(DataStorageAPI storage, ComputationAPI computation) {
        this.storage = Objects.requireNonNull(storage, "Storage API object cannot be null.");
        this.computation = Objects.requireNonNull(computation, "Computation API object cannot be null.");
    }

    @Override
    public JobResponse submitJobRequest(InputSource inputSource, OutputDestination outputDestination, Delimiter delimiter) {
        if (inputSource == null) {
            return new ComputeJobResponse(JobResponseCode.INVALID, "inputSource can not be null");
        }
        if (outputDestination == null) {
            return new ComputeJobResponse(JobResponseCode.INVALID, "outputDestination can not be null");
        }
        //Null delimiter is treated as default

        try {
            IntegerData input = this.storage.read(inputSource);

            IntegerData result = this.computation.compute(input);

            this.storage.write(outputDestination, result, delimiter);

            return new ComputeJobResponse(JobResponseCode.SUCCESS, "Job completed successfully");
        } catch (UncheckedIOException e) {
            return new ComputeJobResponse(JobResponseCode.FAILURE, "File operation failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return new ComputeJobResponse(JobResponseCode.FAILURE, "Invalid input: " + e.getMessage());
        } catch (ArithmeticException e) {
            return new ComputeJobResponse(JobResponseCode.FAILURE, "Computation failed: " + e.getMessage());
        } catch (RuntimeException e) {
            return new ComputeJobResponse(JobResponseCode.FAILURE, "An unexpected error occurred while processing the job");
        }
    }
}
