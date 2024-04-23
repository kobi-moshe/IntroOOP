package data;

public class Tutor extends Participant {
    public Tutor(int id, String name) {
        super(id, name);
    }
    @Override
    public boolean canCreateCourse() {
        return true;
    }
}
