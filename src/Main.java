import model.*;
import manager.SIS;
import java.util.Scanner;

import exceptions.CourseNotFoundException;
import exceptions.DuplicateEnrollmentException;
import exceptions.InvalidEnrollmentDataException;
import exceptions.PaymentValidationException;
import exceptions.StudentNotFoundException;
import exceptions.TeacherNotFoundException;

public class Main {
    public static void main(String[] args) throws DuplicateEnrollmentException, CourseNotFoundException, StudentNotFoundException, InvalidEnrollmentDataException, TeacherNotFoundException, PaymentValidationException {
        Scanner sc = new Scanner(System.in);
        SIS sis = new SIS();

        System.out.println("Enter Student Details");
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter First Name: ");
        String fname = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        String dob = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Student s1 = new Student(sid, fname, lname, dob, email, phone);

        System.out.println("\nEnter Course Details below");
        System.out.print("Enter Course ID: ");
        String cid = sc.nextLine();
        System.out.print("Enter Course Name: ");
        String cname = sc.nextLine();
        System.out.print("Enter Course Code: ");
        String ccode = sc.nextLine();
        System.out.print("Enter Teacher Name: ");
        String tname = sc.nextLine();

        Course c1 = new Course(cid, cname, ccode, tname);

        System.out.println("\nEnter Teacher Details below");
        System.out.print("Enter Teacher ID: ");
        String tid = sc.nextLine();
        System.out.print("Enter Teacher First Name: ");
        String tfname = sc.nextLine();
        System.out.print("Enter Teacher Last Name: ");
        String tlname = sc.nextLine();
        System.out.print("Enter Teacher Email: ");
        String temail = sc.nextLine();

        Teacher t1 = new Teacher(tid, tfname, tlname, temail);

        sis.enrollStudentInCourse(s1, c1, "2025-04-16");
        sis.assignTeacherToCourse(t1, c1);
        sis.recordPayment(s1, 1500, "2025-04-17");

        s1.displayStudentInfo();
        c1.displayCourseInfo();
        t1.displayTeacherInfo();
        sis.generateEnrollmentReport(c1);
        sis.generatePaymentReport(s1);

        sc.close();
    }
}
