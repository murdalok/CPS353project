package project.networkapi;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngineAPI {
    JobResponse submitJobRequest(JobRequest jobRequest);
}
