package project.networkapi;

import project.annotations.NetworkAPIPrototype;

public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine) {
        InputSource  inputSource = new InputSource() {};
        OutputDestination outputDestination = new OutputDestination() {};
        Delimiter delimiter = new Delimiter() {};
        JobResponse response = computeEngine.submitJobRequest(inputSource, outputDestination,delimiter);




    }
}
