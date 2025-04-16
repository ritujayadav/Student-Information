package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String phone;
    private List<Payment> payments = new ArrayList<>();

    public Student(String studentId, String firstName, String lastName, String dob, String email, String phone) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDob() { return dob; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void makePayment(double amount, String date) {
        payments.add(new Payment(studentId, amount, date));
    }

    public List<Payment> getPaymentHistory() {
        return payments;
    }

    public void displayStudentInfo() {
        System.out.println("Student: " + firstName + " " + lastName + ", Email: " + email);
    }
}
