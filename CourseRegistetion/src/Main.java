import data.Lecturer;
import data.Student;

public class Main {

    // Check if the system can have more than 100 participants
    public static void test1(RegistrationSystem system) {
        for (int i = 0; i < 200; i++) {
            system.addParticipant(new Student(i, "some name"));
        }

        system.removeAllParticipants();
    }

    // Check if the system can create duplicate courses
    // Courses are different by id! the rest can be identical
    public static void test2(RegistrationSystem system) {
        Lecturer lecturer = new Lecturer(0, "Yossi");
        system.addParticipant(lecturer);
        system.createNewCourse(lecturer, "Seminar", 0, "OOP", 5);
        system.createNewCourse(lecturer, "Elective", 0, "OOP", 5);
    }

    // Check if a student can register to course
    // Run it after test2()
    public static void test3(RegistrationSystem system) {
        Student student = new Student(1, "Miki");
        system.addParticipant(student);
        system.registerToCourseById(student, 0);
    }

    // Check updates about course
    public static void test4(RegistrationSystem system) {
        Lecturer lecturer = new Lecturer(1, "Yossi");
        system.createNewCourse(lecturer, "Seminar", 1, "OOP", 1);

        Student student = new Student(1, "Miki");
        Student student1 = new Student(1, "Shon");
        system.addParticipant(student);
        system.addParticipant(student1);

        system.registerToCourseById(student, 1);
        system.registerToCourseById(student1, 1);

        system.unregisterToCourseById(student, 1);
        system.registerToCourseById(student1, 1);
    }

    public static void main(String[] args) {
        RegistrationSystem system = RegistrationSystem.getInstance();
//        test1(system);
//        test2(system);
//        test3(system);
        test4(system);
    }
}
