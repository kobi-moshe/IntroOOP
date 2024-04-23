package interfaces;

import data.Course;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Course course);
}
