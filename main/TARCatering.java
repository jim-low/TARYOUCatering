package main;

import java.time.LocalDate; //Date display weird outpur, assumed to be unsupported.
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Iterator;
import payment.Payment;
import adt.SortedLinkedList; //may need to change to adt package
import adt.SortedListInterface; //may need to change to adt package
import order.Order;
import order.Package;
import general.Address;
import adt.LinkedQueue;
import adt.QueueInterface;
import adt.SortedArrayList;
import customer.Customer;

public class TARCatering {
    public static Scanner scan = new Scanner(System.in);
    String[] foodArr1;
    String[] foodArr2;
    String[] foodArr3;
    int sizeChoice = 0;
    int packageChoice;

    public SortedListInterface<Package> packages = new SortedArrayList<>();
    QueueInterface<Order> orderList = new LinkedQueue<>();
    Order order;
    Address newAddress;
    Customer customer;
    Payment newPayment;
    LocalDate caterDate;


    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy"); //set Date to a more readable format

    public static void main(String[] args) {
        TARCatering system = new TARCatering();

        mainBanner();
        //testPayment();
        system.initialize();
        system.EnqueueOrder(system.Order());
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

        newAddress = new Address("addressName", "address1", "address2", "address3");
        customer = new Customer("Brian", "hktalonz@gmail.com", "Male", "01112100350", newAddress);
        newPayment = new Payment("P001", packages.search(packageChoice).getPrice(), LocalDate.now() , "BANK IN");
        order = new Order();
        caterDate = LocalDate.now();

        orderList.enqueue(new Order("O001",customer, packages.search(packageChoice), newPayment, "Done", newAddress, LocalDate.now(), caterDate));
        orderList.enqueue(new Order("O002",customer, packages.search(packageChoice), newPayment, "Done", newAddress, LocalDate.now(), caterDate));

    }

    public int Order(){
        char size = ' ';
        double addPrice = 0;

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

            switch(sizeChoice){
            case 1:
                size = 'S';
                addPrice = 20.00;
                break;
            case 2:
                size = 'M';
                addPrice = 40.00;
                break;
            case 3:
                size = 'L';
                addPrice = 60.00;
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Response! try again.");
                break;
            }

        }while(packageChoice <= 0 || packageChoice >= 5 || sizeChoice == 4);

        packages.edit(packageChoice-1, new Package(packages.search(packageChoice-1).getPackageID(), packages.search(packageChoice-1).getDesc(), size ,
            packages.search(packageChoice-1).getPrice() + addPrice, packages.search(packageChoice-1).getFood()));


        return (packageChoice - 1);
    }

    public void EnqueueOrder(int packageChoice){

        String newID = String.format("O%03d", Integer.parseInt(orderList.getNewNode().getOrderID().replaceAll("([A-Z])", "")) + 1);
        orderList.enqueue(new Order(newID, customer, packages.search(packageChoice), newPayment, "Not Done", newAddress, LocalDate.now(), caterDate));

        System.out.println(orderList.getNewNode());
    }

    public void listAllOrders(){
        System.out.println(orderList);
    }

    public void editOrder(String orderID){


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
