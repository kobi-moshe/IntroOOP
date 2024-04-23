package FlightSystem;

import FlightSystem.Data.Airline;
import FlightSystem.Data.Component;
import FlightSystem.Data.Flight;
import FlightSystem.Notifications.FlightSubject;
import FlightSystem.Search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlightSystem {

    private final List<Component> components;
    private final List<FlightSubject> flightListeners;

    public FlightSystem(List<Component> components) {
        this.components = components;
        this.flightListeners = new ArrayList<>();
    }

    // Recursive method to find flights from the list of components
    public void findFlights(List<Component> temp, List<Flight> flights) {
        for (Component c : temp) {
            if (c instanceof Flight) {
                flights.add((Flight) c);
            } else if (c instanceof Airline airline) {
                findFlights(airline.getComponents(), flights);
            }
        }
    }

    public List<Flight> searchFlightsBy(SearchStrategy strategy) {
        List<Flight> flights = new ArrayList<>();
        findFlights(components, flights);

        for (Component c : components) {
            if (c instanceof Flight) {
                flights.add((Flight) c);
            }
        }
        return strategy.search(flights);
    }

    public void addComponent(Component f) {
        components.add(f);
    }

    public void removeFlight(Component f) {
        components.remove(f);
    }

    public void addListener(FlightSubject f) {
        flightListeners.add(f);
    }

    public void removeListener(FlightSubject f) {
        flightListeners.remove(f);
    }

    public void displayComponents() {
        for (Component component : components) {
            component.display();
        }
    }
}
