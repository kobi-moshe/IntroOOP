package data;

public class Lecturer extends Participant {
    public Lecturer(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canCreateCourse() {
        return true;
    }
}
