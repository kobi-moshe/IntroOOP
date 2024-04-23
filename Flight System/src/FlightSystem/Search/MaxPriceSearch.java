package FlightSystem.Search;

import FlightSystem.Data.Flight;

import java.util.ArrayList;
import java.util.List;

public class MaxPriceSearch implements SearchStrategy {
    private final float maxPrice;

    public MaxPriceSearch(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Flight> search(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getPrice() <= maxPrice) {
                filteredFlights.add(f);
            }
        }
        return filteredFlights;
    }
}
