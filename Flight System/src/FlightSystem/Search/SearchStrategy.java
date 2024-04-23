package FlightSystem.Search;


import FlightSystem.Data.Flight;

import java.util.List;

public interface SearchStrategy {
    List<Flight> search(List<Flight> flights);
}
