import java.util.Date;
import java.util.Stack;

public class Employee {
    private String name;
    private String Id;
    private Gender gender;
    private Stack<Date> dates;
    public Employee(String name, String Id, Gender gender) {
        this.name = name;
        this.Id = Id;
        this.gender = gender;
        this.dates = new Stack<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Stack<Date> getDates() {
        return dates;
    }

    public void setDates(Stack<Date> dates) {
        this.dates = dates;
    }
}
