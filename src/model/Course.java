package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String courseCode;
    private Teacher teacher;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(String courseId, String courseName, String courseCode, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
    }
}
