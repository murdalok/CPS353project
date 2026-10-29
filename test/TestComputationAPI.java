import org.junit.jupiter.api.Test;
import project.processapi.IntegerDataset;
import project.conceptualapi.ComputationHandler;
import project.processapi.IntegerData;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestComputationAPI {

    @Test
    public void testCompute() {

        IntegerData input = new IntegerDataset(List.of(1, 10, 25));
        ComputationHandler computation = new ComputationHandler();
        IntegerData result = computation.compute(input);
        assertEquals(List.of(2, 29, 97), result.getIntegers());
    }

    @Test
    public void testInvalidPrimeRank() {

        ComputationHandler computation = new ComputationHandler();
        IntegerData input = new IntegerDataset(List.of(0));
        assertThrows(IllegalArgumentException.class, () -> computation.compute(input));
    }
}