package data;

import interfaces.Observer;

public class Student extends Participant implements Observer {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canCreateCourse() {
        return false;
    }

    @Override
    public void update(Course course) {
        System.out.println(course + " is available now");
    }
}
