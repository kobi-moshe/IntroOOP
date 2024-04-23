package FlightSystem.Notifications;

import FlightSystem.Data.Flight;

public class ArrivalTimeObserver  implements Observer<Flight> {
    @Override
    public void update(Flight flight) {
        System.out.println("received update: Arrival Time has changed: " + flight.getArrivalTime());
    }
}
