package entity;

public class Staff extends Person{
    private String position;
    private double salary;
    private StaffSchedule schedules;

    public Staff(String position, double salary, StaffSchedule schedules, String name, String gender, String userID, String email, String phoneNum) {
        super(name, gender, userID, email, phoneNum);
        this.position = position;
        this.salary = salary;
        this.schedules = schedules;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public StaffSchedule getSchedules() {
        return schedules;
    }

    public void setSchedules(StaffSchedule schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Staff{" + "position=" + position + ", salary=" + salary + ", schedules=" + schedules + '}';
    }
    
    
}
