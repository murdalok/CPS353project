package project.networkapi;

import project.annotations.NetworkAPIPrototype;

public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine) {

        //specify input and output sources
        InputSource inputSource;
        OutputDestination outputDestination;

        //specify delimiter or use default if one is not specified
        Delimiter delimiter;

        //build job request
        JobRequest jobRequest = null;

        //submit job and get response
        JobResponse jobResponse = computeEngine.submitJob(jobRequest);

    }
}
