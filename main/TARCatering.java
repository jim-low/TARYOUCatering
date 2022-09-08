package main;

import java.time.LocalDate; //Date display weird outpur, assumed to be unsupported.
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import payment.Payment;
import adt.SortedLinkedList; //may need to change to adt package
import adt.SortedListInterface; //may need to change to adt package
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
    String[] foodArr1;
    String[] foodArr2;
    String[] foodArr3;
    public SortedListInterface<Package> packages = new SortedArrayList<>();
    
    public static void main(String[] args) {
        TARCatering system = new TARCatering();

        mainBanner();
        testPayment();
        //system.initialize();
        //system.choosePackage();
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
        String[] foodArr1 = {"Fishes", "Meat-imitated vegetable", "More Vegetable", "Literal Grass", "Fish Soup"};
        String[] foodArr2 = {"Fishes", "Beef", "Curry", "Vegetables", "Fish Soup"};
        String[] foodArr3 = {"Fish", "Pork", "Vegetables", "Beef", "Fish Soup"};
        packages.add(new Package("PK001", "Vegetarian Friendly", ' ', 20.00, foodArr1));
        packages.add(new Package("PK002", "No Babi", ' ', 20.00, foodArr2));
        packages.add(new Package("PK003", "Standard food normal people eat, babi bankyak", ' ', 20.00, foodArr3));
    }
    
    public void choosePackage(){
        int sizeChoice = 0;
        int packageChoice;
        do{
            System.out.println("Choose the package to order: ");
            for(int i=1;i<=packages.getNumberOfEntries();i++){
                System.out.println("(" + i + ")Package " + i + ", " + packages.search(i-1).getDesc());
            }
            System.out.println("(4)Exit");
            packageChoice = scan.nextInt();
            
            if(packageChoice <=0 || packageChoice >=5){
                System.out.println("Invalid Choice. Try Again.");
            }else{
                do{
                    System.out.println("Choose package size to serve: ");
                    System.out.println("1. Small, additional RM20  (Suitable for 1 to 20 People) ");
                    System.out.println("2. Medium, additional RM40  (Suitable for 20 to 50 People) ");
                    System.out.println("3. Large, additional RM60 (Suitable for 50 to 100 People) ");
                    System.out.println("4. Back");
                    sizeChoice = scan.nextInt();

                }while(sizeChoice <= 0 || sizeChoice >= 5);
            }
        }while(packageChoice <= 0 || packageChoice >= 5 || sizeChoice == 4);
            
            
            switch(sizeChoice){
                case 1:{
                    packages.edit(sizeChoice-1, new Package(packages.search(sizeChoice-1).getPackageID(), packages.search(sizeChoice-1).getDesc(), 'S' , 
                            packages.search(sizeChoice-1).getPrice(), packages.search(sizeChoice-1).getFood()));
                    System.out.println(packages.search(sizeChoice-1));
                    break;
                }
                case 2:{
                    packages.edit(sizeChoice-1, new Package(packages.search(sizeChoice-1).getPackageID(), packages.search(sizeChoice-1).getDesc(), 'S' , 
                            packages.search(sizeChoice-1).getPrice(), packages.search(sizeChoice-1).getFood()));
                    System.out.println(packages.search(sizeChoice-1));
                    break;
                }
                case 3:{
                    packages.edit(sizeChoice-1, new Package(packages.search(sizeChoice-1).getPackageID(), packages.search(sizeChoice-1).getDesc(), 'S' , 
                            packages.search(sizeChoice-1).getPrice(), packages.search(sizeChoice-1).getFood()));
                    System.out.println(packages.search(sizeChoice-1));
                    break;
                }
                default:{
                    break;
                }
                
            }
    }
    
    
    public static void showInput(){
        /*
        orderList.enqueue(new Order("O0001", new Person("Brian", "Male", "C0001", "brian@gmail.com","011-12100350"), 
                new Package("PK001", "Random Desc here", "5 people", 100.00, foodArr), new Payment("PM001", 100.00, new Date(22/06/2022), "Credit Card"), "Not Done", 
                new Address(null, "Home", "addressline1", "addressLine2", "addressLine3"), new Date(22-6-2022), new Date(10-9-2022)));
        */
        QueueInterface<Order> orderList = new LinkedQueue<>();
        System.out.println(orderList.getNewNode());
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
            System.out.println("5) Delete Payment List                                  ");
            System.out.println("6) Exit Payment Menu                                    ");
            System.out.println("********************************************************");
            System.out.println("Enter a choice : ");
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
                        System.out.println("paymentID = " + pay.getPaymentID() + ", paymentAmt = " + pay.getPaymentAmt() + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
                    }


                    //test printing all records with ToString (Not suggested, should not print from entity class)
                    /*
                       System.out.println("===========list============\n" + payList.toString());
                       System.out.println("Records added = " + payList.getNumberOfEntries());
                       System.out.println("===========================\n");
                       */


                    break;

                case 2: //add

                    System.out.println("To test contains(), there will be no generation or validation for ID.");

                    System.out.print("Enter the ID you want to add by : ");
                    String addId = scan.nextLine() + scan.nextLine();

                    System.out.print("\nEnter the Payment Amount : ");
                    Double addAmt = scan.nextDouble();

                    System.out.print("Enter the Date of the Payment : ");
                    System.out.print("\nDay Of Payment : ");
                    int day = scan.nextInt();
                    System.out.print("\nMonth Of Payment : ");
                    int month = scan.nextInt();
                    System.out.print("\nYear Of Payment : ");
                    int year = scan.nextInt();

                    System.out.println("\n\nEnter the Payment Method :");
                    String addMethod = scan.nextLine() + scan.nextLine();

                    LocalDate dToAdd = LocalDate.of(year,month,day);
                    Payment checkpay = new Payment(addId, addAmt, dToAdd, addMethod);

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

                    Payment testRemove = new Payment("P0001", 3.33, d2, "MAYBANK");
                    if (!payList.remove(testRemove)){
                        System.out.println("No such record found! No changes made to List!");
                    }
                    else{
                        System.out.println("Record Deleted! ");
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
                            System.out.println("paymentID = " + pay.getPaymentID() + ", paymentAmt = " + pay.getPaymentAmt() + ", paymentDate = " + date + ", paymentMethod = " + pay.getPaymentMethod());
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
                    //System.out.println("Bye bye!");
                    System.out.println(payList.getLast());
                    break;

                default:
                    System.out.println("\nERROR: Please insert a number from 1 to 6.\n");
                    break;
            }
        }
        while (choice < 6);


    }


}
