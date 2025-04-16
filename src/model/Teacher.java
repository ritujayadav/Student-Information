package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Course> courses = new ArrayList<>();

    public Teacher(String teacherId, String firstName, String lastName, String email) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getTeacherId() { return teacherId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public void assignCourse(Course course) {
        courses.add(course);
    }

    public void displayTeacherInfo() {
        System.out.println("Teacher: " + firstName + " " + lastName + ", Email: " + email);
    }
}
