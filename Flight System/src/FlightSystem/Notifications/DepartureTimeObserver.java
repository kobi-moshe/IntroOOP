package FlightSystem.Notifications;

import FlightSystem.Data.Flight;


public class DepartureTimeObserver implements Observer<Flight> {
    @Override
    public void update(Flight flight) {
        System.out.println("received update: Departure Time has changed to: " + flight.getDepartureTime());
    }
}
