public enum Shift {
    MORNING("Morning", 8, 12),
    AFTERNOON("Afternoon", 13, 17),
    EVENING("Evening", 18, 22);
    private final String name;
    private final int startTime;
    private final int endTime;

    Shift(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
