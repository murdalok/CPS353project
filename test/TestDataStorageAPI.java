import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;
import project.datastore.DataStorage;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;
import project.processapi.IntegerData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDataStorageAPI {

    @Test
    public void testRead(@TempDir Path tempDir) throws IOException {

        // Creates a temporary input file
        Path inputPath = tempDir.resolve("input.txt");
        Files.writeString(inputPath, "1\n10\n25");

        // Mocks the input source
        InputSource input = Mockito.mock(InputSource.class);
        Mockito.when(input.getPath()).thenReturn(inputPath);

        // Creates the real storage implementation
        DataStorage storage = new DataStorage();

        // Reads the file
        IntegerData result = storage.read(input);

        // Verifys the contents
        assertEquals(List.of(1, 10, 25), result.getIntegers());
    }

    @Test
    public void testWrite(@TempDir Path tempDir) throws IOException {

        OutputDestination output = Mockito.mock(OutputDestination.class);
        IntegerData data = Mockito.mock(IntegerData.class);
        Delimiter delimiter = Mockito.mock(Delimiter.class);

        Path outputPath = tempDir.resolve("output.txt");

        Mockito.when(output.getPath()).thenReturn(outputPath);
        Mockito.when(data.getIntegers()).thenReturn(List.of(2, 29, 97));
        Mockito.when(delimiter.getDelimiter()).thenReturn(";");

        DataStorage storage = new DataStorage();

        storage.write(output, data, delimiter);

        assertEquals("2;29;97", Files.readString(outputPath));
    }
}