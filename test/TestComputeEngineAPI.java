import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.conceptualapi.ComputationAPI;
import project.jobhandler.JobHandler;
import project.networkapi.*;
import project.processapi.DataStorageAPI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestComputeEngineAPI {

    @Test
    public void testSubmitJobRequest() {

        DataStorageAPI storage = Mockito.mock(DataStorageAPI.class);

        ComputationAPI computation = Mockito.mock(ComputationAPI.class);

        InputSource inputSource = Mockito.mock(InputSource.class);

        OutputDestination outputDestination = Mockito.mock(OutputDestination.class);

        Delimiter delimiter = Mockito.mock(Delimiter.class);

        JobHandler jobHandler = new JobHandler(storage, computation);

        JobResponse response = jobHandler.submitJobRequest(inputSource, outputDestination, delimiter);

        assertNotNull(response);
    }
}