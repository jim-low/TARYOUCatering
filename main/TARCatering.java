package main;

import java.time.LocalDate; //Date display weird outpur, assumed to be unsupported.
import java.util.Scanner;

import java.util.Iterator;
import payment.Payment;
import adt.SortedLinkedList; //may need to change to adt package
import adt.SortedListInterface; //may need to change to adt package
import order.Order;
import order.Package;
import general.Address;
import adt.CircularList;
import adt.LinkedQueue;
import adt.QueueInterface;
import adt.SortedArrayList;
import customer.Customer;

enum Flag {
    NO_LOGIN,
    CUSTOMER_LOGIN,
    STAFF_LOGIN,
}

class Menu {
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

    public static void mainMenu() {
        if (TARCatering.flag == Flag.NO_LOGIN) {
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
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
            System.out.println("3. Edit Package");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
        }
    }
}

public class TARCatering {
    public static Scanner scan = new Scanner(System.in);
    public static Flag flag;

    // shit needed to run the program
    public static CircularList<Customer> customerList = new CircularList<>();
    public static Customer loggedInCustomer = null;
    public static SortedListInterface<Package> packages = new SortedArrayList<>();
    public static QueueInterface<Order> orderList = new LinkedQueue<>();
    public static SortedListInterface<Payment> payList = new SortedLinkedList<>();

    public static void main(String[] args) {
        init();
        Menu.mainBanner();

        while (true) {
            Menu.mainMenu();

            int choice = scan.nextInt();
            if (flag == Flag.NO_LOGIN) {
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("I would put a create account method here but for now no need ba");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            } else if (flag == Flag.CUSTOMER_LOGIN) {
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2: // check orders
                        Iterator<Order> orders = orderList.getIterator();
                        while (orders.hasNext()) {
                            Order order = orders.next();
                            if (order.getCustomerID().getUserID().equals(loggedInCustomer.getUserID())) {
                                System.out.println(order);
                            }
                        }
                        break;
                    case 3: // check payments
                        Iterator<Payment> payments = payList.getIterator();
                        while (payments.hasNext()) {
                            Payment payment = payments.next();
                            if (payment.getOrder().getCustomerID().getUserID().equals(loggedInCustomer.getUserID())) {
                                System.out.println(payment);
                            }
                        }
                        break;
                    case 4:
                        logout();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public static void init() {
        flag = Flag.NO_LOGIN;

        // customer init
        Customer c1 = new Customer("Jim", "jimllh-wm20@student.tarc.edu.my", "Male", "012-7746260", new Address("Jim's address", "", "", ""));
        Customer c2 = new Customer("Gym", "jimllh-wm20@student.tarc.edu.my", "Alpha Male", "012-7746260", new Address("Jim's address", "", "", ""));
        Customer c3 = new Customer("Jym", "jimllh-wm20@student.tarc.edu.my", "Chad", "012-7746260", new Address("Jim's address", "", "", ""));
        customerList.insert(c1);
        customerList.insert(c2);
        customerList.insert(c3);

        // order and package init
        String[] foodArr1 = {"Fishes", "Meat-imitated vegetable", "More Vegetable", "Literal Grass", "Fish Soup"};
        String[] foodArr2 = {"Fishes", "Beef", "Curry", "Vegetables", "Fish Soup"};
        String[] foodArr3 = {"Fish", "Pork", "Vegetables", "Beef", "Fish Soup"};
        packages.add(new Package("PK001", "Vegetarian Friendly", ' ', 20.00, foodArr1));
        packages.add(new Package("PK002", "No Babi", ' ', 20.00, foodArr2));
        packages.add(new Package("PK003", "Standard food normal people eat, babi bankyak", ' ', 20.00, foodArr3));

        LocalDate caterDate = LocalDate.of(2022,10,22);;

        Order o1 = new Order("O001", c1, packages.search(0), "Done", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate);
        Order o2 = new Order("O002", c2, packages.search(1), "Done", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate);
        Order o3 = new Order("O003", c3, packages.search(2), "Done", new Address("Jim's address", "", "", ""), LocalDate.now(), caterDate);
        orderList.enqueue(o1);
        orderList.enqueue(o2);
        orderList.enqueue(o3);

        // payment init
        Payment p1 = new Payment("P0001", 420.69, LocalDate.of(2022, 9, 11), "VISA", o1);
        Payment p2 = new Payment("P0002", 420.69, LocalDate.of(2022, 9, 11), "NASA", o2);
        Payment p3 = new Payment("P0003", 420.69, LocalDate.of(2022, 9, 11), "SASA", o3);
        payList.add(p1);
        payList.add(p2);
        payList.add(p3);

    }

    public static void login() {
        System.out.print("Enter username: ");
        String name = scan.next();

        System.out.print("Enter email: ");
        String email = scan.next();

        Customer found = customerList.search(new Customer(name, email));
        if (found == null) {
            System.out.println("Incorrect details you donkey");
            return;
        }

        System.out.println("Successfully logged in");
        loggedInCustomer = found;
        flag = Flag.CUSTOMER_LOGIN;
    }

    public static void logout() {
        loggedInCustomer = null;
        flag = Flag.NO_LOGIN;
        System.out.println("Successfully logged out");
    }
}
