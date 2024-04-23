package FlightSystem.Search;

import FlightSystem.Data.Flight;

import java.util.ArrayList;
import java.util.List;

public class DepartureTimeSearch implements SearchStrategy {

    private long departureTime;

    public DepartureTimeSearch(long dt) {
        departureTime = dt;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long dt) {
        departureTime = dt;
    }

    @Override
    public List<Flight> search(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDepartureTime() >= departureTime) {
                filteredFlights.add(f);
            }
        }
        return filteredFlights;
    }
}
