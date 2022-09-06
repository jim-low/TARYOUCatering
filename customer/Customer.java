package customer;

import adt.CircularList;
import general.Address;
import general.Person;
import main.TARCatering;

/**
 * Customer
 */
public class Customer extends Person implements Comparable<Customer> {
    private Address savedAddress;
    public static CircularList<Customer> customerList = new CircularList<>();
    public static Customer loggedInCustomer = null;

    public Customer(String name, String email, String gender, String phoneNum, Address savedAddress) {
        super(name, email, gender, phoneNum);
        this.savedAddress = savedAddress;
    }

    public Address getSavedAddress() {
        return savedAddress;
    }

    public void setSavedAddress(Address savedAddress) {
        this.savedAddress = savedAddress;
    }

    public static Customer createCustomer() {
        System.out.println("Creating user account:-");

        System.out.print("Name: ");
        String name = TARCatering.scan.nextLine();

        System.out.print("Email: ");
        String email = TARCatering.scan.next();

        System.out.print("Gender (M/F): ");
        String gender = (TARCatering.scan.next().charAt(0) == 'M') ? "Male" : "Female";

        System.out.print("Phone No. (01x-xxxxxxx): ");
        String phoneNum = TARCatering.scan.next();

        String address = "";
        System.out.print("Do you wish to save a default address? (Y/N): ");
        if (TARCatering.scan.next().toUpperCase().charAt(0) == 'Y') {
            System.out.print("Default Address: ");
            TARCatering.scan.next();
            address = TARCatering.scan.nextLine();
        }

        Address defaultAddress = new Address(name + "'s Default Address", address, "", "");

        return new Customer(name, email, gender, phoneNum, defaultAddress);
    }

    public static boolean login(Customer details) {
        if (loggedInCustomer != null) {
            System.out.println("Existing session ongoing.");
            return false;
        }

        Customer found = customerList.search(details);
        if (found == null) {
            System.out.println("Could not find records. (check entered details)");
            return false;
        }

        loggedInCustomer = found;
        return true;
    }

    public static void logout() {
        if (loggedInCustomer == null) {
            System.out.println("No existing session.");
            return;
        }

        loggedInCustomer = null;
        System.out.println("Logged out");
    }

	@Override
	public int compareTo(Customer o) {
        if (this.getName().equals(o.getName()) && this.getEmail().equals(o.getEmail())) {
            return 0;
        }
		return -1;
	}
}
