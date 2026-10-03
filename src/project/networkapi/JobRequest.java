package project.networkapi;

public interface JobRequest {
    InputSource getInputSource();
    OutputDestination getOutputDestination();
    Delimiter getDelimiter();
}