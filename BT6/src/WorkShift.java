public class WorkShift {
    private DayOfWeek day;
    private Shift shift;
    public WorkShift(DayOfWeek day, Shift shift) {
        this.day = day;
        this.shift = shift;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
