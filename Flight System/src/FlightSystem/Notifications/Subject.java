package FlightSystem.Notifications;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyDataHasChanged(T data);
}
