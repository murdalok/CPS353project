package project.conceptualapi;

import project.annotations.ConceptualAPIPrototype;
import project.processapi.IntegerData;

public class ComputationAPIPrototype {

    @ConceptualAPIPrototype
    public void prototype(ComputationAPI job){
        //start job
        job.startJob();

        //read in integer data
        IntegerData data = job.read();

        //computation logic for nth prime

        //write data
        job.write();
    }
}
