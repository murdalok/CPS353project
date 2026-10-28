package project.networkapi;

import project.annotations.NetworkAPIPrototype;

import java.nio.file.Path;

public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine) {
        InputSource  inputSource = new InputSource() {
            @Override
            public Path getPath() {
                return null;
            }
        };

        OutputDestination outputDestination = new OutputDestination() {
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
        JobResponse response = computeEngine.submitJobRequest(inputSource, outputDestination,delimiter);




    }
}
