package project.networkapi;

public interface JobRequest {

    Delimiter getDelimiter();

    InputSource getInputSource();

    OutputDestination getOutputDestination();
}
