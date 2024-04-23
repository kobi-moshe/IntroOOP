import data.Course;
import data.Elective;
import data.Mandatory;
import data.Seminar;

public class CourseFactory {
    public static Course create(String type, int id, String name, int cap) {
        return switch (type) {
            case "Seminar" -> new Seminar(id, name, cap);
            case "Elective" -> new Elective(id, name, cap);
            case "Mandatory" -> new Mandatory(id, name, cap);
            default -> {
                System.out.println("This type doesn't exists");
                yield null;
            }
        };
    }
}
