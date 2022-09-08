package main;

import java.util.Scanner;

import customer.Customer;
import general.Person;

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
    public static Person loggedInAccount;

    public static void main(String[] args) {
        flag = Flag.NO_LOGIN;

        Menu.mainBanner();
        Menu.mainMenu();
    }
}
