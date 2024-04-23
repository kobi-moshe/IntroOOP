package FlightSystem.Notifications;

import FlightSystem.Data.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightSubject implements Subject<Flight> {
    private final List<Observer<Flight>> observers = new ArrayList<>();
    private Flight flight;

    public FlightSubject(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void addObserver(Observer<Flight> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Flight> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyDataHasChanged(Flight data) {
        for (Observer<Flight> observer : observers) {
            observer.update(data);
        }
    }

    public void updateFlightData(long departureTime, long arrivalTime, float price) {
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setPrice(price);
        notifyDataHasChanged(flight);
    }
}
