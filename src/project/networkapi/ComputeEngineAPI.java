package project.networkapi;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngineAPI {
    JobResponse submitJobRequest(InputSource inputSource, OutputDestination outputDestination, Delimiter delimiter);
}
