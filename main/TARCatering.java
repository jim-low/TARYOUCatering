package main;

import java.time.LocalDate; //Date import displays weird output, assumed to be unsupported, changed to Local Date instead.
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import payment.Payment;
import adt.SortedLinkedList; 
import adt.SortedListInterface; 
import java.lang.Math;   

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
        LocalDate d2 = LocalDate.of(2022,12,12);
        LocalDate d3 = LocalDate.of(2022,10,10);
        LocalDate d4 = LocalDate.of(2022,1,1);
        payList.add(new Payment("P0001", 400.33, d1, "VISA"));
        payList.add(new Payment("P0002", 366.33, d2, "MAYBANK"));
        payList.add(new Payment("P0003", 347.33, d3, "MAYBANK"));
        payList.add(new Payment("P0004", 943.33, d4, "MAYBANK"));

        do{
            Iterator<Payment> payIterator = payList.getIterator();
            String date;
            System.out.println("\n*******************Payment Menu*************************");
            System.out.println("1) Display Payment List                                 ");
            System.out.println("2) Add Payment                                          ");
            System.out.println("3) Remove Payment                                       ");
            System.out.println("4) Search Payment                                       ");
            System.out.println("5) Delete Payment List                                  ");
            System.out.println("6) Exit Payment Menu                                    ");
            System.out.println("********************************************************");
            System.out.print("Enter a choice : ");
            choice = scan.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1: //display
                    //display (using iterator to print)
                    if (payList.isEmpty()){
                        System.out.println("Your List is Empty...");
                        break;
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());

                        System.out.println("paymentID = " + pay.getPaymentID() + String.format(" , paymentAmt = %.2f", pay.getPaymentAmt()) + " , paymentDate = " + date + " , paymentMethod = " + pay.getPaymentMethod());
                        System.out.println("---------------------------------------------------------------------------------------------------");
                    }

                    System.out.println("Amount of Records = " + payList.getNumberOfEntries());
                    
                    //test printing all records with ToString (Not suggested, should not print from entity class)
                    /*
                       System.out.println("===========list============\n" + payList.toString());
                       System.out.println("Records added = " + payList.getNumberOfEntries());
                       System.out.println("===========================\n");
                       */


                    break;

                case 2: //add
                    int day;
                    int month;
                    int year;
                    
                    //generate own payment ID.
                    String generatePayId;
                    boolean newPayId = true;
                    
                    do{
                    //generate a random number of a paymentID format
                    int generateNum = (int)(Math.random() * (9999 - 1 + 1) + 1);
                    
                    //generate necessary zeros
                    if(generateNum < 10) generatePayId = "P000" + String.valueOf(generateNum);
                    
                    else if (generateNum < 100) generatePayId = "P00" + String.valueOf(generateNum);
                    
                    else if (generateNum < 1000) generatePayId = "P0" + String.valueOf(generateNum);
                    
                    else generatePayId = "P" + String.valueOf(generateNum);
                        
                    //generated number is created, check if it is a duplicate.
                        newPayId = true;
                        payIterator = payList.getIterator(); //reset iterator, to reset positions.
                        while(payIterator.hasNext()){
                            Payment pay = payIterator.next();
                            if(generatePayId.equals(pay.getPaymentID())){
                                newPayId = false;
                            }
                        }
                        
                    } while (newPayId == false);
                    
                    //display the Id to be added.
                    System.out.println("Payment ID: " + generatePayId);

                    System.out.print("\nEnter the Payment Amount : ");
                    Double addAmt = scan.nextDouble();

                    System.out.print("\nEnter the Date of the Payment : ");
                    
                    do{
                    System.out.print("\nDay Of Payment (integer) : ");
                    day = scan.nextInt();
                        if(day > 12 || day < 1){
                           System.out.println("\nIncorrect day. Try again.");
                        }
                    }while (day > 12 || day < 1);
                    
                    do{
                        System.out.print("\nMonth Of Payment (integer) : ");
                        month = scan.nextInt();
                        if(month > 12 || month < 1){
                           System.out.println("\nIncorrect month. Try again.");
                        }
                    }while (month > 12 || month < 1);
                    
                    do{
                        System.out.print("\nYear Of Payment (integer) : ");
                        year = scan.nextInt();
                        if(year > 9999 || year < 1000){
                           System.out.println("\nIncorrect/unrealistic year. Try again.");
                        }
                    }while (year > 9999 || year < 1000);
                    

                    System.out.println("\n\nEnter the Payment Method :");
                    String addMethod = scan.nextLine() + scan.nextLine();

                    LocalDate dToAdd = LocalDate.of(year,month,day);
                    Payment checkpay = new Payment(generatePayId, addAmt, dToAdd, addMethod);

                    if (!payList.contains(checkpay)){
                        if (!payList.add(checkpay)){
                            System.out.println("ERROR: Unable to add.");
                        }
                        
                        else System.out.println("New payment added.");
                    }

                    else {
                        System.out.println("This payment already exists.");
                    }

                    break;

                case 3: //remove
                    if (payList.isEmpty()){
                        System.out.println("You have nothing to delete, the list is empty...");
                        break;
                    }
                    
                    System.out.print("Enter the ID you want to remove by : ");
                    String removeId = scan.nextLine() + scan.nextLine();
                    
                    //find the object
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        if(removeId.equals(pay.getPaymentID())){
                            if(!payList.remove(pay)){
                                System.out.println("\nERROR: Unable to remove record.");
                            }
                            
                            else{
                                System.out.println("\nRecord Found and Removed!");
                            }
                            break;
                        }
                    }
                    
                    break;

                case 4: //search
                    boolean searchFound = false;
                    System.out.println("Enter the ID you want to search by : ");
                    String searchId = scan.nextLine() + scan.nextLine();
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());
                        if(searchId.equals(pay.getPaymentID())){
                            System.out.println("\n===Record found!===");
                            System.out.println("paymentID = " + pay.getPaymentID() + ", paymentAmt = " + pay.getPaymentAmt() + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                            searchFound = true;
                            break;
                        }
                    }

                    if (searchFound == false) System.out.println("\n===No Such Record found...===");
                    break;

                case 5: //clear
                    payList.clear();
                    System.out.println("PAYMENT LIST CLEARED.");
                    break;

                case 6://exit
                    System.out.println("End of Payment module!");

                    break;

                default:
                    System.out.println("\nERROR: Please insert a number from 1 to 6.\n");
                    break;
            }
        }
        while (choice < 6);


    }


}
