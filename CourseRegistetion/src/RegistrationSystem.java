import data.Course;
import data.Student;
import data.Participant;

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


    public void registerToCourse(int userId, Course course) {
        try {
            Student participant = (Student) participantManager.getParticipant(userId);
            if (participant != null) {
                if (!courseManager.canRegister(course)) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Would you like to receive an update if a place becomes available in the course?");
                    System.out.print("Enter your choice [y/n]: ");
                    String choice = input.nextLine();
                    if (choice.equals("y")) {
                        course.attach(participant);
                    }
                } else {
                    courseManager.registerCourse(course);
                }
            }
        } catch (Exception e) {
            System.out.println("The participant has not logged in to the system or maybe the provided id isn't belong to student");
        }
    }
}
