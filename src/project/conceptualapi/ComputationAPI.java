package project.conceptualapi;

import project.annotations.ConceptualAPI;
import project.processapi.IntegerData;

@ConceptualAPI
public interface ComputationAPI {
    IntegerData compute(IntegerData input);
}
