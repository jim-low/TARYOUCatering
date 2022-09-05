
package entity;

import java.util.Date;

public class Payment {
    private String paymentID;
    private double paymentAmt;
    private Date paymentDate;
    private String paymentMethod;

    public Payment(String paymentID, double paymentAmt, Date paymentDate, String paymentMethod) {
        this.paymentID = paymentID;
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", paymentAmt=" + paymentAmt + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod + '}';
    }
    
    
}
