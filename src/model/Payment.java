package model;

public class Payment {
    private String studentId;
    private double paymentAmount;
    private String paymentDate;

    public Payment(String studentId, double paymentAmount, String paymentDate) {
        this.studentId = studentId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() { return paymentAmount; }
    public String getPaymentDate() { return paymentDate; }
}
