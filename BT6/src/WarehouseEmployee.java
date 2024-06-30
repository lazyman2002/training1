import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class WarehouseEmployee extends Employee{
    private Stack<Date> dates;
    private List<DayOfWeek> daysOfWeek;

    public WarehouseEmployee(String name, String Id, Gender gender) {
        super(name, Id, gender);
        this.dates = new Stack<>();
        this.daysOfWeek  = new ArrayList<>();
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}
