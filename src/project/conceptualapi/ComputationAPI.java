package project.conceptualapi;

import project.annotations.ConceptualAPI;
import project.processapi.IntegerData;

@ConceptualAPI
public interface ComputationAPI {
    //start job
    void startJob();

    //read job data
    IntegerData read();

    //write job data
    void write();
}
