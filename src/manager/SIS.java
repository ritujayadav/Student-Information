package manager;

import model.*;
import database.DatabaseConnection;
import exceptions.CourseNotFoundException;
import exceptions.DuplicateEnrollmentException;
import exceptions.InvalidEnrollmentDataException;
import exceptions.PaymentValidationException;
import exceptions.StudentNotFoundException;
import exceptions.TeacherNotFoundException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class SIS {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public void enrollStudentInCourse(Student student, Course course, String date)
            throws DuplicateEnrollmentException, CourseNotFoundException, StudentNotFoundException, InvalidEnrollmentDataException {

        if(student == null || course == null || date == null || date.isEmpty()) {
            throw new InvalidEnrollmentDataException("Invalid enrollment data provided.");
        }

        if (!students.contains(student)) {
            students.add(student);
        }

        if (!courses.contains(course)) {
            throw new CourseNotFoundException("Course not found: " + course.getCourseId());
        }

        for (Enrollment e : course.getEnrollments()) {
            if (e.getStudent().getStudentId().equals(student.getStudentId())) {
                throw new DuplicateEnrollmentException("Student already enrolled in this course.");
            }
        }

        

        course.getEnrollments().add(new Enrollment(UUID.randomUUID().toString(), student, course, date));

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, UUID.randomUUID().toString());
            stmt.setString(2, student.getStudentId());
            stmt.setString(3, course.getCourseId());
            stmt.setDate(4, Date.valueOf(date));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error during enrollment: " + e.getMessage());
        }
    }

    public void assignTeacherToCourse(Teacher teacher, Course course)
            throws TeacherNotFoundException, CourseNotFoundException {

        if (teacher == null || course == null) {
            throw new TeacherNotFoundException("Teacher or Course is null");
        }

        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
        }

        if (!courses.contains(course)) {
            throw new CourseNotFoundException("Course not found: " + course.getCourseId());
        }

        course.assignTeacher(teacher);
        teacher.assignCourse(course);
    }

    public void recordPayment(Student student, double amount, String date)
            throws PaymentValidationException, StudentNotFoundException {

        if (student == null) {
            throw new StudentNotFoundException("Student is null.");
        }

        if (!students.contains(student)) {
            throw new StudentNotFoundException("Student not found: " + student.getStudentId());
        }

        if (amount <= 0 || date == null || date.isEmpty()) {
            throw new PaymentValidationException("Invalid payment amount or date.");
        }

        student.makePayment(amount, date);
    }

    public void generateEnrollmentReport(Course course) {
        System.out.println("Enrollment Report for " + course.getCourseId());
        for (Enrollment e : course.getEnrollments()) {
            System.out.println("Student: " + e.getStudent().getStudentId());
        }
    }

    public void generatePaymentReport(Student student) {
        System.out.println("Payments for " + student.getStudentId());
        for (Payment p : student.getPaymentHistory()) {
            System.out.println("Amount: ₹" + p.getPaymentAmount() + ", Date: " + p.getPaymentDate());
        }
    }
}
