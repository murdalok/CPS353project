package project.networkapi;

public class ComputeJobResponse implements JobResponse {
    private final JobResponseCode code;
    private final String message;

    public ComputeJobResponse(JobResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public JobResponseCode getResponseCode() {
        return code;
    }
}
