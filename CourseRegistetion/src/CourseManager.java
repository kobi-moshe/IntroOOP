import data.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course newCourse) {
        for (Course course : courses) {
            if (newCourse.getId() == course.getId()) {
                System.out.println(newCourse + " is already exists");
                return;
            }
        }
        System.out.println(newCourse + " has been added successfully");
        courses.add(newCourse);
    }

    public void removeCourse(Course course) {
        System.out.println(course + " has been removed successfully");
        courses.remove(course);
    }

    public boolean registerCourse(Course course) {
        if (course.getEnrolled() < course.getCapacity()) {
            System.out.println("Student has been registered");
            course.addStudentToCourse();
            return true;
        }
        System.out.println("The course is currently full");
        return false;
    }

    public boolean canRegister(Course course) {
        return course.getEnrolled() < course.getCapacity();
    }
}
