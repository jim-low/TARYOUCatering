package payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import order.Order;

public class Payment implements Comparable<Payment>{

    String paymentID;
    double paymentAmt;
    LocalDate paymentDate;
    String paymentMethod;
    Order order;

    private static int idNumber = 1;

    public Payment(double paymentAmt, LocalDate paymentDate, String paymentMethod) {
        this(paymentAmt, paymentDate, paymentMethod, null);
    }

    public Payment(double paymentAmt, LocalDate paymentDate, String paymentMethod, Order order) {
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.order = order;

        this.paymentID = String.format("P%03d", idNumber);
        ++idNumber;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public Payment searchPayment(String id){

        if (this.paymentID.equals(id)){
            Payment foundPayment = new Payment(this.paymentAmt, this.paymentDate, this.paymentMethod, this.order);
            //return the matched object
            return foundPayment;
        }

        else return null;

    }

    @Override
    public String toString() {
        return String.format("Payment ID: %s\nPayment Amount: %.2f\nPayment Date: %s\nPayment Method: %s\nOrder ID: %s\nOrder Date: %s\nCater Date: %s\n",
                paymentID,
                paymentAmt,
                paymentDate.format(DateTimeFormatter.ofPattern("dd MMM uuuu")),
                paymentMethod,
                order.getOrderID(),
                order.getOrderDate().format(DateTimeFormatter.ofPattern("dd MMM uuuu")),
                    order.getCaterDate().format(DateTimeFormatter.ofPattern("dd MMM uuuu")));
    }

    @Override
    public int compareTo(Payment p) {
        LocalDate dateToCompare = p.order.getCaterDate();
        LocalDate currentPDate = this.order.getCaterDate();
        int dateCompareValue = currentPDate.compareTo(dateToCompare);
        return dateCompareValue;
    }
}
