import java.util.Date;
import java.util.List;
import java.util.Stack;

public class SalesEmployee extends Employee{
    private Stack<WorkShift> workShift;
    private Stack<Date> dates;

    public SalesEmployee(String name, String Id, Gender gender) {
        super(name, Id, gender);
        this.dates = new Stack<>();
        this.workShift = new Stack<>();
    }

    public Stack<WorkShift> getWorkShift() {
        return workShift;
    }

    public void setWorkShift(Stack<WorkShift> workShift) {
        this.workShift = workShift;
    }


}
