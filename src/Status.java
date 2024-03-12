public enum Status {
    PASS("Pass"),
    FINISHED("Finished"),
    PLAYING("Playing");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
