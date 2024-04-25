import data.Course;
import data.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private final List<Course> courses = new ArrayList<>();

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }
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

    public void registerCourse(Course course) {
        if (course.getEnrolled() < course.getCapacity()) {
            System.out.println("Student has been registered");
            course.addStudentToCourse();
            return;
        }
        System.out.println("The course is currently full");
    }

    public void unregisterCourse(Course course) {
        if (course.getEnrolled() > 0) {
            course.removeStudentFromCourse();
            System.out.println("Student has been unregistered");
        }
    }

    public boolean canRegister(Course course) {
        return course.getEnrolled() < course.getCapacity();
    }
}
