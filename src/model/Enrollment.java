package model;

public class Enrollment {
    private String enrollmentId;
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(String enrollmentId, Student student, Course course, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getEnrollmentDate() { return enrollmentDate; }
}
