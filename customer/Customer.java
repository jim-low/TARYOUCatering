package customer;

import general.Address;
import general.Person;

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
}
