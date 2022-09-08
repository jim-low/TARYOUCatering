package main;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import payment.Payment;
import adt.SortedLinkedList; 
import adt.SortedListInterface; 
import order.Order;
import order.OrderList;
import order.Package;
import general.Person;
import general.Address;
import adt.LinkedQueue;
import adt.QueueInterface;
import adt.SortedArrayList;
import java.util.Date;

public class TARCatering {
    public static Scanner scan = new Scanner(System.in);

    public SortedListInterface<Package> packages = new SortedArrayList<>();

    public static void main(String[] args) {
        TARCatering system = new TARCatering();

        mainBanner();
        //testPayment();
        system.initialize();
        system.choosePackage();
        //showInput();
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

    //OrderCrap
    public void initialize(){
        String[] foodArr1 = {"Fishes", "Meat-lookalike vegetable", "More Vegetable", "Literal Grass", "Fish Soup"};
        String[] foodArr2 = {"Fishes", "Beef", "Curry", "Vegetables", "Fish Soup"};
        String[] foodArr3 = {"Fish", "Pork", "Vegetables", "Beef", "Fish Soup"};

        packages.add(new Package("PK001", "Vegetarian Friendly", ' ', 20.00, foodArr1));
        packages.add(new Package("PK002", "No Babi", ' ', 20.00, foodArr2));
        packages.add(new Package("PK003", "Standard food normal people eat, babi bankyak", ' ', 20.00, foodArr3));
    }
    public void choosePackage(){
        int sizeChoice=0;
        int packageChoice;
        do{
            System.out.println("Choose the package to order: ");
            System.out.println("(1)Package 1 ");
            System.out.println("(2)Package 2 ");
            System.out.println("(3)Package 3 ");
            System.out.println("(4)Exit");
            packageChoice = scan.nextInt();

            do{
                System.out.println("Choose package size to serve: ");
                System.out.println("1. Small, additional RM20  (Suitable for 1 to 20 People) ");
                System.out.println("2. Medium, additional RM40  (Suitable for 20 to 50 People) ");
                System.out.println("3. Large, additional RM60 (Suitable for 50 to 100 People) ");
                System.out.println("4. Back");

            }while(sizeChoice < 1 || sizeChoice > 4);


        }while(packageChoice < 1 || packageChoice > 4 || sizeChoice == 4);


    }


    public static void showInput(){
        /*
           orderList.enqueue(new Order("O0001", new Person("Brian", "Male", "C0001", "brian@gmail.com","011-12100350"),
           new Package("PK001", "Random Desc here", "5 people", 100.00, foodArr), new Payment("PM001", 100.00, new Date(22/06/2022), "Credit Card"), "Not Done",
           new Address(null, "Home", "addressline1", "addressLine2", "addressLine3"), new Date(22-6-2022), new Date(10-9-2022)));
           */
        QueueInterface<Order> orderList = new LinkedQueue<>();
        System.out.println(orderList.getFront());
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
        LocalDate d5 = LocalDate.of(2022,4,5);
        LocalDate d6 = LocalDate.of(2022,6,7);
        payList.add(new Payment("P0002", 433.33, d1, "VISA"));
        payList.add(new Payment("P0001", 675.33, d2, "MAYBANK"));
        payList.add(new Payment("P0003", 843.33, d3, "HSBC"));
        payList.add(new Payment("P0005", 659.88, d4, "HSBC"));
        payList.add(new Payment("P0006", 200.00, d5, "PUBLIC BANK"));
        payList.add(new Payment("P0004", 669.37, d6, "MAYBANK"));
        payList.add(new Payment("P0007", 420.66, LocalDate.of(2022,6,3), "VISA"));

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

            switch (choice) {
                case 1: //display
                    //display (using iterator to print)
                    if (payList.isEmpty()){
                        System.out.println("Your List is Empty...");
                        break;
                    }

                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());
                        System.out.println("paymentID = " + pay.getPaymentID() + String.format(" , paymentAmt = %.2f", pay.getPaymentAmt()) + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                    }
                     System.out.println("Current amount of Records : " + payList.getNumberOfEntries());


                    break;

                case 2: //add
                    //ID auto generation
                    int newUniqueNum = 0;
                    boolean isUniquePayId;
                    String generateNewPayId;
                    
                    do{
                        //generate a newPayId
                        isUniquePayId = true;
                        newUniqueNum = (int)(Math.random()*(9999-1+1)+1);
                        
                        //set it to a ID format
                        if(newUniqueNum < 10) generateNewPayId = "P000" + String.valueOf(newUniqueNum);
                        
                        else if (newUniqueNum < 100) generateNewPayId = "P00" + String.valueOf(newUniqueNum);
                        
                        else if (newUniqueNum < 1000) generateNewPayId = "P0" + String.valueOf(newUniqueNum);
                        //9999 or less
                        else generateNewPayId = "P" + String.valueOf(newUniqueNum);
                    
                        //reinitialize the Iterator to reset it.
                        payIterator = payList.getIterator();
                    
                        //check for duplicate PayID
                        while(payIterator.hasNext()){
                            Payment pay = payIterator.next();
                            if(generateNewPayId.equals(pay.getPaymentID())){
                                isUniquePayId = false;
                            }
                        }
                    
                    } while(isUniquePayId == false);
                    
                    //print to Id to be added. 
                    System.out.println("Payment ID " + generateNewPayId);

                    System.out.print("\nEnter the Payment Amount : ");
                    Double addAmt = scan.nextDouble();

                    //add with the current date. 
                    LocalDate dToAdd = LocalDate.now();

                    System.out.print("\n\nEnter the Payment Method :");
                    String addMethod = scan.nextLine() + scan.nextLine();

                    Payment checkpay = new Payment(generateNewPayId, addAmt, dToAdd, addMethod);

                    if (!payList.contains(checkpay)){
                        payList.add(checkpay);
                        System.out.println("New payment added.");
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
                    boolean found = false;
                    System.out.println("Enter the ID you want to search by : ");
                    String searchId = scan.nextLine() + scan.nextLine();
                    while(payIterator.hasNext()){
                        Payment pay = payIterator.next();
                        date = dateFormat.format(pay.getPaymentDate());
                        if(searchId.equals(pay.getPaymentID())){
                            System.out.println("\n===Record found!===");
                            System.out.println("paymentID = " + pay.getPaymentID() + String.format(" , paymentAmt = %.2f", pay.getPaymentAmt()) + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                            found = true;
                            break;
                        }
                    }

                    if (found == false) System.out.println("\n===No Such Record found...===");
                    break;

                case 5: //clear
                    System.out.println("I don't know why you wanted to delete all the records, but ok boss.");
                    payList.clear();
                    System.out.println("PAYMENT LIST CLEARED.");
                    break;

                case 6://exit
                    //System.out.print(payList.getLast().getPaymentID());
                    //System.out.println("Bye bye!");

                    break;

                default:
                    System.out.println("\nERROR: Please insert a number from 1 to 6.\n");
                    break;
            }
        }
        while (choice < 6);


    }


}
