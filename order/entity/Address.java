
package entity;

public class Address {
    private String AddressID;
    private String addressName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    public Address(String AddressID, String addressName, String addressLine1, String addressLine2, String addressLine3) {
        this.AddressID = AddressID;
        this.addressName = addressName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }

    public String getAddressID() {
        return AddressID;
    }

    public void setAddressID(String AddressID) {
        this.AddressID = AddressID;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
    
    
}
