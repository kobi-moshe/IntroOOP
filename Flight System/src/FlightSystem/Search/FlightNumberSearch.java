package FlightSystem.Search;

import FlightSystem.Data.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightNumberSearch implements SearchStrategy {

    private int number;

    public FlightNumberSearch(int number) {
        this.number = number;
    }

    @Override
    public List<Flight> search(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == number) {
                filteredFlights.add(flight);
                break;
            }
        }
        return filteredFlights;
    }
}
