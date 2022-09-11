package staff;

import adt.CircularQueue;
import general.Person;
import main.TARCatering;

/**
 * Customer
 */
public class Staff extends Person implements Comparable<Staff>{
    private String position;
    private double salary;

    public Staff(String name, String email){
        this(name, email, "", "", "", 0.0);
    }

    //Constructor
    public Staff(String name, String email, String gender, String phoneNum, String position, double salary){
        super(name, email, gender, phoneNum);
        this.position = position;
        this.salary = salary;
    }

    //Getter for position
    public String getPosition(){
        return position;
    }

    //Setter for position
    public void setPosition(String position){
        this.position = position;
    }

    //Getter for salary
    public double getSalary(){
        return salary;
    }

    //Setter for salary
    public void setSalary(double salary){
        this.salary = salary;
    }

    //Function for create new staff
    public static Staff createStaff(){
        System.out.println("Creating new staff account:-");

        System.out.print("Name: ");
        String name = TARCatering.scan.nextLine();

        System.out.print("Email: ");
        String email = TARCatering.scan.next();

        System.out.print("Gender (M/F): ");
        String gender = (TARCatering.scan.next().charAt(0) == 'M') ? "Male" : "Female";

        System.out.print("Phone No. (01x-xxxxxxx): ");
        String phoneNum = TARCatering.scan.next();

        System.out.print("Position: ");
        String position = TARCatering.scan.nextLine();

        System.out.print("Salary (XXXX.XX) :");
        double salary = TARCatering.scan.nextDouble();

        return new Staff(name, email, gender, phoneNum, position, salary);
    }

    @Override
    public int compareTo(Staff o) {
        if(this.getName().equals(o.getName()) && this.getEmail().equals(o.getEmail())){
            return 0;
        }
        return -1;
    }

}
