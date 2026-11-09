package integration;

import org.junit.jupiter.api.Test;
import project.conceptualapi.ComputationHandler;
import project.networkapi.Delimiter;
import project.networkapi.JobHandler;
import project.networkapi.JobResponse;
import project.networkapi.ResultDelimiter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

        Delimiter delimiter = new ResultDelimiter();

        jobHandler.submitJobRequest(input, output, delimiter);

        assertEquals(List.of("2", "29", "97"), output.getOutput());
    }

    @Test
    public void testComputationExceptionBecomesFailureResponse() {
        InMemoryDataStorage storage = new InMemoryDataStorage();
        ComputationHandler computation = new ComputationHandler();
        JobHandler jobHandler = new JobHandler(storage, computation);

        // Rank 0 is invalid, so ComputationHandler throws IllegalArgumentException
        InMemoryInputSource input = new InMemoryInputSource(List.of(1, 0, 25));
        InMemoryOutputDestination output = new InMemoryOutputDestination();

        JobResponse response = jobHandler.submitJobRequest(input, output, new ResultDelimiter());

        assertNotNull(response);
        assertFalse(response.getResponseCode().success());
        assertTrue(output.getOutput().isEmpty(), "No partial output should be written");
    }
}
