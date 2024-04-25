package data;


import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject {
    protected int enrolled = 0;
    List<Observer> observers = new ArrayList<>();
    private int id;
    private String name;
    private int capacity;

    public Course(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void addStudentToCourse() {
        enrolled++;
    }
    public void removeStudentToCourse() {
        enrolled--;
    }

    public void removeStudentFromCourse() {
        enrolled--;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Course " + name + " (" + id + ")";
    }
}
