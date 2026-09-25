package project.networkapi;

public enum JobResponseCode {
    // response states for job
    SUCCESS(true),
    FAILURE(true),
    PENDING(false),
    INVALID(true);

    private boolean success;

    private JobResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}
