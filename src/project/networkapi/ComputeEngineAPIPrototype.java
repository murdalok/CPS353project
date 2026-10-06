package project.networkapi;

import project.annotations.NetworkAPIPrototype;

public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine) {
        //job arrives from user
        JobRequest jobRequest;
        //submit job request to compute engine
        JobResponse response = computeEngine.submitJobRequest(jobRequest);




    }
}
