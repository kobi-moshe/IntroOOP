package FlightSystem.Notifications;

import FlightSystem.Data.Flight;

public class PriceObserver implements Observer<Flight> {
    @Override
    public void update(Flight flight) {
        System.out.println("received update: Price has changed: " + flight.getPrice());
    }
}
