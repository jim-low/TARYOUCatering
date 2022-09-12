package customer;

import general.Address;
import general.Person;

/**
 * Customer
 */
public class Customer extends Person implements Comparable<Customer> {
    private Address savedAddress;

    public Customer(String name, String email) {
        this(name, email, "", "", null);
    }

    public Customer(String name, String email, String gender, String phoneNum, Address savedAddress) {
        super(name, email, gender, phoneNum);
        this.savedAddress = savedAddress;
    }

    public Customer(){

    }

    public Address getSavedAddress() {
        return savedAddress;
    }

    public void setSavedAddress(Address savedAddress) {
        this.savedAddress = savedAddress;
    }

    @Override
    public int compareTo(Customer o) {
        if (this.getName().equals(o.getName()) && this.getEmail().equals(o.getEmail())) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
