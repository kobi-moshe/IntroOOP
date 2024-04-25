import data.Course;
import data.Participant;
import data.Student;

import java.util.Scanner;

public class RegistrationSystem {

    private static RegistrationSystem instance;
    private final ParticipantManager participantManager;
    private final CourseManager courseManager;

    private RegistrationSystem() {
        participantManager = new ParticipantManager();
        courseManager = new CourseManager();
    }

    public static synchronized RegistrationSystem getInstance() {
        if (instance == null)
            instance = new RegistrationSystem();
        return instance;
    }

    public void addParticipant(Participant participant) {
        participantManager.addParticipant(participant);
    }

    public void removeParticipant(Participant participant) {
        participantManager.removeParticipant(participant);
    }

    public void removeAllParticipants() {
        participantManager.removeAllParticipants();
    }

    public void createNewCourse(Participant creator, String type, int id, String name, int capacity) {
        if (!creator.canCreateCourse()) {
            System.out.println("Unauthorized attempt to create a course");
            return;
        }

        Course newCourse = CourseFactory.create(type, id, name, capacity);
        if (newCourse != null) {
            courseManager.addCourse(newCourse);
        }
    }
    public void unregisterToCourse(Student student, Course course) {
        courseManager.unregisterCourse(course);
        course.detach(student);
        course.notifyObservers();
    }
    public void unregisterToCourseById(Student student, int courseId) {
        Course course = courseManager.getCourseById(courseId);
        unregisterToCourse(student, course);
    }
    public void registerToCourse(Student student, Course course) {
        if (!participantManager.isLoggedIn(student)) {
            System.out.println("The student must log in before taking any action");
            return;
        }
        if (!courseManager.canRegister(course)) {
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to receive an update if a space becomes available?");
            System.out.print("Enter your choice [y/n]: ");
            String choice = input.nextLine();
            if (choice.equals("y")) {
                course.attach(student);
            }
            return;
        }

        courseManager.registerCourse(course);
    }

    public void registerToCourseById(Student student, int courseId) {
        Course course = courseManager.getCourseById(courseId);
        if (course != null) {
            registerToCourse(student, course);
        } else {
            System.out.println("Course id is not exist");
        }
    }
}
