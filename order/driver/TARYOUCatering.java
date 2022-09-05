package driver;

import java.util.Scanner;
import java.util.Date;
import adt.LinkedQueue;
import adt.QueueInterface;
import entity.Order;
import entity.Person;
import entity.Package;
import entity.Payment;
import entity.Address;

public class TARYOUCatering {

    private Scanner inputScanner = new Scanner(System.in);
    private String[] foodArr;
    QueueInterface<Order> orderList = new LinkedQueue<>();
    int choice = 0;
    
    
    public static void initialize(){
        String[] foodArr = {"Fish", "Pork", "Steamed Buns"};
        
    }
    
    public int menu(){
        do{
            System.out.println("Choose the package to order: ");
            System.out.println("(1)Package 1: ");
            System.out.println("(2)Package 2: ");
            System.out.println("(3)Package 3: ");
            System.out.println("(4)Exit");
            choice = inputScanner.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("You chose package 1!");
                    break;
                }
                case 2:{
                    System.out.println("You chose package 2!");
                    break;
                }
                case 3:{
                    System.out.println("You chose package 3!");
                    break;
                }
                case 4:{
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Invalid choice, try again.");
                    break;
                }
            }
        
        }while(choice >4 || choice <1);
        
        return choice;
    }
    
    public void showInput(){
        orderList.enqueue(new Order("O0001", new Person("Brian", "Male", "C0001", "brian@gmail.com","011-12100350"), 
                new Package("PK001", "Random Desc here", "5 people", 100.00, foodArr), new Payment("PM001", 100.00, new Date(22/06/2022), "Credit Card"), "Not Done", 
                new Address(null, "Home", "addressline1", "addressLine2", "addressLine3"), new Date(22-6-2022), new Date(10-9-2022)));
        
        
        System.out.println(orderList.getFront());
    }
    
    public static void main(String[] args) {
        
        TARYOUCatering system = new TARYOUCatering();
        system.initialize();
        system.menu();
        system.showInput();
        
        //orderList.enqueue(new Order(O0001, C0001, PK001, PM001, "Not Done", "Address",22-6-2022, 10-9-2022));
        
        
    }
    
    
    
}
