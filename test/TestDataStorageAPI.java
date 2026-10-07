import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.datastore.DataStorage;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;
import project.processapi.IntegerData;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDataStorageAPI {

    @Test
    public void testRead() {

        InputSource input =
                Mockito.mock(InputSource.class);

        DataStorage storage =
                new DataStorage();

        IntegerData data =
                storage.read(input);

        assertNotNull(data);
    }

    @Test
    public void testWrite() {

        OutputDestination output = Mockito.mock(OutputDestination.class);

        IntegerData data = Mockito.mock(IntegerData.class);

        DataStorage storage = new DataStorage();

        storage.write(output, data);
    }
}