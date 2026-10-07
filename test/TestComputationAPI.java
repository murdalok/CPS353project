import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.computation.ComputationHandler;
import project.processapi.IntegerData;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestComputationAPI {

    @Test
    public void testCompute() {

        IntegerData input = Mockito.mock(IntegerData.class);

        ComputationHandler computation = new ComputationHandler();

        IntegerData result = computation.compute(input);

        assertNotNull(result);
    }
}