package FlightSystem.Data;

import java.util.ArrayList;
import java.util.List;

public class Airline implements Component {
    private String name;

    private List<Component> components;

    public Airline(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public Airline(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }


    @Override
    public void display() {
        System.out.println(name + " has: ");
        for (Component component : components) {
            component.display();
        }
        System.out.println();
    }
}
