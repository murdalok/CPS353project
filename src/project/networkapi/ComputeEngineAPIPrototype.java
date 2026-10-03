package project.networkapi;

import project.annotations.NetworkAPIPrototype;

public class ComputeEngineAPIPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine, JobRequest request) {
        //job arrives from user

        //submit job request to compute engine
        JobResponse response = computeEngine.submitJobRequest(request);




    }
}
