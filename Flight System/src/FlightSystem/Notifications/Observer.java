package FlightSystem.Notifications;

public interface Observer<T> {
    void update(T data);
}
