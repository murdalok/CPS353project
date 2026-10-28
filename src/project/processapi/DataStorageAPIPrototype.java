package project.processapi;

import project.IntegerDataset;
import project.annotations.ProcessAPIPrototype;
import project.networkapi.Delimiter;
import project.networkapi.InputSource;
import project.networkapi.OutputDestination;

import java.nio.file.Path;
import java.util.List;

public class DataStorageAPIPrototype {

    @ProcessAPIPrototype
    public void prototype(DataStorageAPI storage) {
        InputSource input = new InputSource() {
            @Override
            public Path getPath() {
                return null;
            }
        };

        OutputDestination output = new OutputDestination() {
            @Override
            public Path getPath() {
                return null;
            }
        };

        Delimiter delimiter = new Delimiter() {
            @Override
            public String getDelimiter() {
                return "";
            }
        };

        IntegerData integerData = storage.read(input);

        IntegerData result = new IntegerDataset(List.of(2, 29, 97));

        storage.write(output, result, delimiter);
    }
}
