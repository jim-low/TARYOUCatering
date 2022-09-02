package customer;

import general.Address;
import general.Person;
import main.TARCatering;

/**
 * Customer
 */
public class Customer extends Person {
    private Address savedAddress;

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
}
