package main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import adt.CircularList;
import adt.CircularListInterface;
import adt.LinkedQueue;
import adt.QueueInterface;
import adt.SortedArrayList;
import adt.SortedLinkedList;
import adt.SortedListInterface;
import customer.Customer;
import general.Address;
import general.Person;
import order.Order;
import order.Package;
import payment.Payment;
import staff.Schedule;
import staff.Staff;

enum Flag {
    NO_LOGIN,
    ABOUT_TO_LOGIN,
    CUSTOMER_LOGIN,
    STAFF_LOGIN,
}

class Menu {
    public static void mainBanner(Person user) throws IOException, InterruptedException {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }

        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM uuuu")) + "\t\t\t\t\t\t\t\t\t" + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm")));
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

        if (user != null) {
            if (user instanceof Customer) {
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }

            if (user instanceof Staff) {
                System.out.println("Staff name: " + user.getName());
                System.out.println("Position: " + ((Staff)user).getPosition());
            }

            System.out.println();
        }

        TARCatering.resetDisplay = false;
    }

    public static void mainMenu() {
        if (TARCatering.flag == Flag.NO_LOGIN) {
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
        }

        if (TARCatering.flag == Flag.ABOUT_TO_LOGIN) {
            System.out.println("1. Staff");
            System.out.println("2. Customer");
            System.out.println("3. Back");
        }

        if (TARCatering.flag == Flag.CUSTOMER_LOGIN) {
            System.out.println("1. Place order");
            System.out.println("2. Check orders");
            System.out.println("3. Check payments");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
        }

        if (TARCatering.flag == Flag.STAFF_LOGIN) {
            System.out.println("1. Add Package");
            System.out.println("2. Remove Package");
            System.out.println("3. Edit Customer Order Status");
            System.out.println("4. Check Schedule");
            System.out.println("5. Check Payments");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
        }
    }
}


public class TARCatering {
    public static Scanner scan = new Scanner(System.in);
    public static int choice;
    public static Flag flag;
    public static boolean resetDisplay = true;

    public static CircularList<Customer> customerList = new CircularList<>();
    public static Person loggedInUser = null;
    public static SortedListInterface<Package> packages = new SortedArrayList<>();
    public static QueueInterface<Order> orderList = new LinkedQueue<>();
    public static SortedListInterface<Payment> payList = new SortedLinkedList<>();
    public static CircularListInterface<Staff> staffList = new CircularList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        init();

        int wrongInputCounter = 0;
        while (true) {
            if (resetDisplay) {
                Menu.mainBanner(loggedInUser);
            }

            Menu.mainMenu();
            while (true) {
                try {
                    System.out.print("Your choice: ");
                    choice = Integer.parseInt(scan.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Incorrect input.");
                    System.out.println();
                }
            }
            System.out.println();

            if (flag == Flag.NO_LOGIN) {
                noLoginInput();
            } else if (flag == Flag.ABOUT_TO_LOGIN) {
                loginInput();
            } else if (flag == Flag.CUSTOMER_LOGIN) {
                customerInput();
            } else if (flag == Flag.STAFF_LOGIN) {
                staffInput();
            }
        }
    }

    public static void init() {
        flag = Flag.NO_LOGIN;

        // customer init
        Customer c1 = new Customer("Jim", "jimllh-wm20@student.tarc.edu.my", "Male", "012-7746260", new Address("Jim's address", "", "", ""));
        Customer c2 = new Customer("Gym", "jimllh-wm20@student.tarc.edu.my", "Mail", "012-7746260", new Address("Jim's address", "", "", ""));
        Customer c3 = new Customer("Jym", "jimllh-wm20@student.tarc.edu.my", "Chad", "012-7746260", new Address("Jim's address", "", "", ""));
        customerList.insert(c1);
        customerList.insert(c2);
        customerList.insert(c3);

        // staff init
        Staff s1 = new Staff("Jasper", "jaspercjs-pm20@student.tarc.edu.my", "Male", "012-7746260", "Manager", 420.00);
        Staff s2 = new Staff("Jasper", "jaspercjs-pm20@student.tarc.edu.my", "Mail", "012-7746260", "Head Chef", 420.00);
        Staff s3 = new Staff("Jasper", "jaspercjs-pm20@student.tarc.edu.my", "Chad", "012-7746260", "Head Server", 420.00);
        Schedule sch1 = new Schedule();
        sch1.setStartTime(9, 0);
        sch1.setEndTime(17, 0);
        sch1.setDay(1);

        Schedule sch2 = new Schedule();
        sch2.setStartTime(9, 0);
        sch2.setEndTime(17, 0);
        sch2.setDay(2);

        Schedule sch3 = new Schedule();
        sch3.setStartTime(9, 0);
        sch3.setEndTime(17, 0);
        sch3.setDay(3);

        Schedule sch4 = new Schedule();
        sch4.setStartTime(9, 0);
        sch4.setEndTime(17, 0);
        sch4.setDay(4);

        Schedule sch5 = new Schedule();
        sch5.setStartTime(9, 0);
        sch5.setEndTime(17, 0);
        sch5.setDay(17);

        Schedule sch6 = new Schedule();
        sch6.setStartTime(9, 0);
        sch6.setEndTime(17, 0);
        sch6.setDay(6);

        Schedule sch7 = new Schedule();
        sch7.setStartTime(9, 0);
        sch7.setEndTime(17, 0);
        sch7.setDay(7);

        s1.getSchedule().enqueue(sch1);
        s1.getSchedule().enqueue(sch2);
        s1.getSchedule().enqueue(sch3);
        s1.getSchedule().enqueue(sch4);
        s1.getSchedule().enqueue(sch5);
        s1.getSchedule().enqueue(sch6);
        s1.getSchedule().enqueue(sch7);

        s2.getSchedule().enqueue(sch1);
        s2.getSchedule().enqueue(sch2);
        s2.getSchedule().enqueue(sch3);
        s2.getSchedule().enqueue(sch4);
        s2.getSchedule().enqueue(sch5);
        s2.getSchedule().enqueue(sch6);
        s2.getSchedule().enqueue(sch7);

        s3.getSchedule().enqueue(sch1);
        s3.getSchedule().enqueue(sch2);
        s3.getSchedule().enqueue(sch3);
        s3.getSchedule().enqueue(sch4);
        s3.getSchedule().enqueue(sch5);
        s3.getSchedule().enqueue(sch6);
        s3.getSchedule().enqueue(sch7);

        staffList.insert(s1);
        staffList.insert(s2);
        staffList.insert(s3);

        // order and package init
        String[] foodArr1 = {"Fishes", "vegan meat", "More Vegetable", "Vegetable", "Fish Soup"};
        String[] foodArr2 = {"Fishes", "Beef", "Curry", "Vegetables", "Fish Soup"};
        String[] foodArr3 = {"Fish", "Pork", "Vegetables", "Beef", "Fish Soup"};
        packages.add(new Package("PK001", "Vegetarian Catering Package", ' ', 20.00, foodArr1));
        packages.add(new Package("PK002", "Halal Catering Package", ' ', 20.00, foodArr2));
        packages.add(new Package("PK003", "Wedding Catering Package", ' ', 20.00, foodArr3));

        LocalDate caterDate1 = LocalDate.of(2022,10,22);
        LocalDate caterDate2 = LocalDate.of(2022,11,22);
        LocalDate caterDate3 = LocalDate.of(2022,12,22);

        Order o1 = new Order("O001", c1, new Package("PK001", "Vegetarian Catering Package", 'S', 40.00, foodArr1), "In Progress", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate1);
        Order o2 = new Order("O002", c2, new Package("PK002", "Halal Catering Package", 'M', 60.00, foodArr2), "In Progress", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate2);
        Order o3 = new Order("O003", c3, new Package("PK003", "Wedding Catering Package", 'L', 80.00, foodArr3), "In Progress", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate3);
        orderList.enqueue(o1);
        orderList.enqueue(o2);
        orderList.enqueue(o3);

        // payment init
        Payment p1 = new Payment(420.69, LocalDate.of(2022, 9, 11), "VISA", o1);
        Payment p2 = new Payment(420.69, LocalDate.of(2022, 9, 11), "VISA", o2);
        Payment p3 = new Payment(420.69, LocalDate.of(2022, 9, 11), "VISA", o3);
        payList.add(p1);
        payList.add(p2);
        payList.add(p3);

    }

    public static void noLoginInput() {
        switch (choice) {
            case 1:
                flag = Flag.ABOUT_TO_LOGIN;
                break;
            case 2:
                createAccount();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public static void loginInput() throws InterruptedException {
        switch (choice) {
            case 1:
                staffLogin();
                break;
            case 2:
                customerLogin();
                break;
            case 3:
                flag = Flag.NO_LOGIN;
        }
    }

    public static void customerInput() {
        switch (choice) {
            case 1:
                placeOrder();
                break;
            case 2:
                checkOrders();
                break;
            case 3:
                checkPayments();
                break;
            case 4:
                logout();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    public static void staffInput() {
        switch (choice) {
            case 1: // add package
                addPackage();
                break;
            case 2: // remove package
                removePackage();
                break;
            case 3: // edit order
                editOrder();
                break;
            case 4: // check schedule
                checkSchedule();
                break;
            case 5:
                checkAllPayments();
                break;
            case 6:
                logout();
                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    public static void checkSchedule() {
        if (!(loggedInUser instanceof Staff)) {
            System.out.println("Only staff may view schedule");
            return;
        }

        System.out.println("Work Schedule:-");
        ((Staff)loggedInUser).getSchedule().display();
        System.out.println();
    }

    public static void checkOrders() {
        Iterator<Order> orders = orderList.getIterator();
        while (orders.hasNext()) {
            Order order = orders.next();
            if (order.getCustomerID().getUserID().equals(loggedInUser.getUserID())) {
                System.out.println(order);
            }
        }
    }

    public static void checkPayments() {
        Iterator<Payment> payments = payList.getIterator();
        while (payments.hasNext()) {
            Payment payment = payments.next();
            if (payment.getOrder().getCustomerID().getUserID().equals(loggedInUser.getUserID())) {
                System.out.println(payment);
            }
        }
    }

    public static void checkAllPayments() {
        Iterator<Payment> payments = payList.getIterator();
        while (payments.hasNext()) {
            System.out.println(payments.next());
        }
    }

    public static void placeOrder() {
        System.out.println("Choose the package to order: ");

        int i;
        char size = ' ';
        double addPrice = 0;
        System.out.println("\n");
        for(i = 0; i < packages.getNumberOfEntries(); i++) {
            System.out.println((i + 1) + ") " + packages.search(i).getDesc());
        }
        System.out.println((i + 1) + ") Exit");
        System.out.print("Your choice: ");
        int selectedPackage = scan.nextInt();
        System.out.println();

        System.out.println("Choose package size to serve: ");
        System.out.println("1. Small, additional RM20  (Suitable for 1 to 20 People) ");
        System.out.println("2. Medium, additional RM40  (Suitable for 20 to 50 People) ");
        System.out.println("3. Large, additional RM60 (Suitable for 50 to 100 People) ");
        System.out.print("Your choice: ");
        int sizeChoice = scan.nextInt();
        System.out.println();

        switch (sizeChoice) {
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
            default:
                System.out.println("Invalid Response! try again.");
                break;
        }

        selectedPackage -= 1;

        Package newPackage = new Package(packages.search(selectedPackage).getPackageID(), packages.search(selectedPackage).getDesc(), size ,
            packages.search(selectedPackage).getPrice() + addPrice, packages.search(selectedPackage).getFood());

        Customer currentCustomer = customerList.search((Customer)loggedInUser);
        String newID = String.format("O%03d", Integer.parseInt(orderList.getNewNode().getOrderID().replaceAll("([A-Z])", "")) + 1);
        Order order = new Order(newID, currentCustomer, newPackage, "In Progress", currentCustomer.getSavedAddress(), LocalDate.now(), LocalDate.of(2022,10,22));
        orderList.enqueue(order);

        Payment payment = new Payment(newPackage.getPrice(), LocalDate.now(), "VISA", order);
        payList.add(payment);

        System.out.println("Successfully placed order");
        System.out.println();
    }

    public static void editOrder(){
        int editChoice;
        int totalChoices =0;
        //Order[] newOrder = new Order[orderList.totalEntries()];
        String orderToBeEdit = "";
        Iterator<Order> orders = orderList.getIterator();
        String newStatus = "";

        int statusChoice = 0;
        do{
            while (orders.hasNext()) {
                Order order = orders.next();
                //newOrder[totalChoices] = order;
                System.out.println(order);
                totalChoices++;
            }

            System.out.print("Select orderID to edit (e.g: 1, 2, 3): ");
            editChoice = scan.nextInt();
            System.out.println();
            orderToBeEdit = String.format("O%03d", editChoice);
            Order searchedOrder = new Order();
            orders = orderList.getIterator();
            while (orders.hasNext()) {
                Order order = orders.next();
                if (order.getOrderID().equals(orderToBeEdit)) {
                    searchedOrder = order;
                    System.out.println(searchedOrder);
                }
            }

            do {
                System.out.println("Enter new status: ");
                System.out.println("1. Done");
                System.out.println("2. Cancelled");
                System.out.print("Your choice: ");
                statusChoice = scan.nextInt();

                switch(statusChoice){
                    case 1:
                        newStatus = "Done";
                        break;
                    case 2:
                        newStatus = "Cancelled";
                        break;
                    default:
                        System.out.println("Invalid Input. Try Again!");
                        break;
                }
            } while(statusChoice < 1 || statusChoice > 2);

            orderList.editNode(searchedOrder, new Order(searchedOrder.getOrderID(),searchedOrder.getCustomerID(), searchedOrder.getPackageID(),
                    newStatus, searchedOrder.getCateringAddress(), searchedOrder.getOrderDate(), searchedOrder.getCaterDate()));
            System.out.println("Order has been updated!\n");

            if (editChoice > totalChoices || editChoice < 1) {
                System.out.println("Invalid input. Try Again!");
            }
        } while(editChoice < 1 || editChoice > totalChoices);

        //orderList.editNode(editChoice , new Order());

    }

    public static void addPackage(){
        System.out.print("Enter the new package description: ");
        String tempDesc = scan.next() + scan.nextLine();

        System.out.print("Enter the new package price: ");
        double tempPrice = scan.nextDouble();

        String tempFood = "";
        boolean exit = false;
        int foodNum = 1;
        String[] newFoodArr = new String[10];
        System.out.println("Enter the new package food one by one up to ten only (enter \"done\" to exit): ");
        while(exit == false && foodNum < 11){
            System.out.print(foodNum + ". ");
            tempFood = scan.next() + scan.nextLine();
            if(tempFood.equals("done")){
                exit = true;
            }else{
                newFoodArr[foodNum - 1] = tempFood;
                foodNum++;
            }
        }

        String newID = String.format("PK%03d", Integer.parseInt(packages.getLast().getPackageID().replaceAll("([A-Z])", "")) + 1);
        packages.add(new Package(newID, tempDesc, ' ', tempPrice, newFoodArr));

        System.out.println("Package is added!\n");
    }

    public static void removePackage() {
        packages.display();

        System.out.print("Enter package ID: ");
        String packageID = scan.next();

        if (!packages.remove(new Package(packageID))) {
            System.out.println("Failed to remove package.");
        } else {
            System.out.println("Successfully removed package.");
        }
        System.out.println();
    }

    public static void createAccount() {
        System.out.println("Creating account:-");
        System.out.print("Name: ");
        String name = scan.next();

        System.out.print("Email: ");
        String email = scan.next();

        System.out.print("Gender (M/F): ");
        String gender = scan.next().charAt(0) == 'M' ? "Male" : "Female";

        System.out.print("Phone number (011-xxxxxxx): ");
        String phoneNum = scan.next();

        // big brain moment
        System.out.print("Address: ");
        String addressStr = scan.next();
        Address address = new Address(name + "'s address", addressStr + scan.nextLine(), "", "");

        Customer customer = new Customer(name, email, gender, phoneNum, address);
        customerList.insert(customer);

        System.out.println();
        System.out.println("Successfully created account");
    }

    public static void customerLogin() throws InterruptedException {
        System.out.print("Enter username: ");
        String name = scan.next();

        System.out.print("Enter email: ");
        String email = scan.next();

        Customer found = customerList.search(new Customer(name, email));
        if (found == null) {
            System.out.println("Incorrect details");
            return;
        }

        System.out.println("Successfully logged in");
        System.out.println();
        loggedInUser = found;
        flag = Flag.CUSTOMER_LOGIN;
        resetDisplay = true;
        TimeUnit.SECONDS.sleep(1);
    }

    public static void staffLogin() throws InterruptedException {
        System.out.print("Enter username: ");
        String name = scan.next();

        System.out.print("Enter email: ");
        String email = scan.next();

        Staff found = staffList.search(new Staff(name, email));
        if (found == null) {
            System.out.println("Incorrect details");
            return;
        }

        System.out.println("Successfully logged in");
        System.out.println();
        loggedInUser = found;
        flag = Flag.STAFF_LOGIN;
        resetDisplay = true;
        TimeUnit.SECONDS.sleep(1);
    }

    public static void logout() {
        loggedInUser = null;
        flag = Flag.NO_LOGIN;
        System.out.println("Successfully logged out");
        System.out.println();
    }
}
