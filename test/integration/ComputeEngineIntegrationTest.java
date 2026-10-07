package integration;

import org.junit.jupiter.api.Test;
import project.computation.ComputationHandler;
import project.jobhandler.JobHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngine() {

        // Test only Process API implementation
        InMemoryDataStorage storage = new InMemoryDataStorage();

        // Conceptual API implementation
        ComputationHandler computation = new ComputationHandler();

        // Network API implementation
        JobHandler jobHandler = new JobHandler(storage, computation);

        // Required test input
        InMemoryInputSource input = new InMemoryInputSource(List.of(1, 10, 25));

        InMemoryOutputDestination output = new InMemoryOutputDestination();

        // No delimiter specified
        jobHandler.submitJobRequest(input, output, null);

        assertEquals(List.of("2", "29", "97"), output.getOutput());
    }
}
