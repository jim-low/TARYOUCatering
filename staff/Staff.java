package staff;

import adt.CircularQueue;
import general.Person;
import main.TARCatering;

/**
 * Customer
 */
public class Staff extends Person{
    private String position;
    private double salary;
    private CircularQueue<StaffSchedule> scheduleList = new CircularQueue<>();
    
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
        
        System.out.print("Salary (XXX.XX) :");
        double salary = TARCatering.scan.nextDouble();

        return new Staff(name, email, gender, phoneNum, position, salary);
    }
    
    //Create new package
    public static Package createPackage(){
        System.out.println("Creating new package:-");
        
        System.out.print("Package ID: ");
        String packageID = TARCatering.scan.nextLine();
        
        System.out.print("Package Description: ");
        String desc = TARCatering.scan.nextLine();
        
        System.out.print("Package Size: ");
        char packageSize = TARCatering.scan.next().charAt(0);
        
        System.out.print("Price: ");
        double price = TARCatering.scan.nextDouble();
        
        System.out.print("Number of food in package: ");
        int noOfFood = TARCatering.scan.nextInt();
        String[] food = new String[noOfFood];
        for(int i = 0; i < noOfFood; i++){
            System.out.print("Food included: ");
            food[i] = TARCatering.scan.nextLine();
        }
        
        return new Package(packageID, desc, packageSize, price, food);
    }
    
    //Retrieve Staff Schedule
    public static CircularQueue<StaffSchedule> checkStaffSchedule)(){
    
    }
    
    /*
    i am not sure if need createPackage() and checkStaffSchedule or not but i'll just leave this here for now
    */
}
