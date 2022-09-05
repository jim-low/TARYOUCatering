package main;

import java.time.LocalDate; //Date display weird outpur, assumed to be unsupported.
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import payment.Payment;
import payment.SortedLinkedList; //may need to change to adt package
import payment.SortedListInterface; //may need to change to adt package

public class TARCatering {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        mainBanner();
        testPayment();
    }

    public static void mainBanner() {
        System.out.println("             _       __     __                             __");
        System.out.println("            | |     / /__  / /________  ____ ___  ___     / /_____");
        System.out.println("            | | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\");
        System.out.println("            | |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /");
        System.out.println("            |__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/");
        System.out.println("");
        System.out.println("    _________    ______  ______  __  ________      __            _");
        System.out.println("   /_  __/   |  / __ \\ \\/ / __ \\/ / / / ____/___ _/ /____  _____(_)___  ____ _");
        System.out.println("    / / / /| | / /_/ /\\  / / / / / / / /   / __ `/ __/ _ \\/ ___/ / __ \\/ __ `/");
        System.out.println("   / / / ___ |/ _, _/ / / /_/ / /_/ / /___/ /_/ / /_/  __/ /  / / / / / /_/ /");
        System.out.println("  /_/ /_/  |_/_/ |_| /_/\\____/\\____/\\____/\\__,_/\\__/\\___/_/  /_/_/ /_/\\__, /");
        System.out.println("                                                                     /____/");
    }
    
    //Leong Wen Wei (Test Functions)
    public static void testPayment(){ 
        
        int choice = 0; //for Payment Menu
        
        SortedListInterface<Payment> payList = new SortedLinkedList<>();
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy"); //set Date to a more readable format

        //create and add the employee object 
        LocalDate d1 = LocalDate.of(2002,11,11);
        payList.add(new Payment("P0002", 4.33, d1, "VISA"));
        LocalDate d2 = LocalDate.of(2022,12,12);
        payList.add(new Payment("P0001", 3.33, d2, "MAYBANK"));
        payList.add(new Payment("P0003", 3.33, d2, "MAYBANK"));
        payList.add(new Payment("P0005", 3.33, d2, "MAYBANK"));
           
        do{
        Iterator<Payment> payIterator = payList.getIterator();
        String date;
        System.out.println("\n*******************Payment Menu*************************");
        System.out.println("1) Display Payment List                                 ");
        System.out.println("2) Add Payment (WIP, only fixed obj payment atm)        ");
        System.out.println("3) Remove Payment (WIP, only with fixed obj atm)        ");
        System.out.println("4) Search Payment                                       ");
        System.out.println("5) Exit Payment Menu                                    ");
        System.out.println("********************************************************");
        System.out.println("Enter a choice : ");
        choice = scan.nextInt();
        
            switch (choice) {
                case 1:
                    //display (using iterator to print)
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());
                        System.out.println("paymentID = " + pay.getPaymentID() + ", paymentAmt = " + pay.getPaymentAmt() + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                    }   
                    
                    
                    //test printing all records with ToString (Not suggested, should not print from entity class)
                    /*
                    System.out.println("===========list============\n" + payList.toString());
                    System.out.println("Records added = " + payList.getNumberOfEntries());
                    System.out.println("===========================\n");
                    */
                    
 
                    break;
                case 2:
                    System.out.println("Not implemented yet.");
                    break;
                case 3:
                    //remove
                    Payment testRemove = new Payment("P0001", 3.33, d2, "MAYBANK");
                    if (!payList.remove(testRemove)){
                        System.out.println("No such record found! No changes made to List!");
                    }
                    else{
                        System.out.println("Record Deleted! ");
                    }   
                    break;
                case 4:
                    //search (contains()) 
                    boolean found = false;
                    System.out.println("Enter the ID you want to search by : ");
                    String searchId = scan.nextLine() + scan.nextLine();
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());
                        if(searchId.equals(pay.getPaymentID())){
                            System.out.println("\n===Record found!===");
                            System.out.println("paymentID = " + pay.getPaymentID() + ", paymentAmt = " + pay.getPaymentAmt() + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                            found = true;
                            break;
                        }
                    }
                    
                    if (found == false) System.out.println("\n===No Such Record found...===");
                    break;
                case 5:
                        System.out.println("Bye bye!");
  
                    break;
                default:
                    System.out.println("\nERROR: Please insert a number from 1 to 5.\n");
                    break;
            }
        }
        while (choice != 5);
        

    }
    
    
}
