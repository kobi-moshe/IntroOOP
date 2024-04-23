package FlightSystem.Data;

import java.util.Random;

public class Flight implements Component {
    private final int flightNumber;
    private long departureTime;
    private long arrivalTime;
    private float price;
    private final String from;
    private final String to;

    public Flight(long departureTime, long arrivalTime, float price, String from, String to) {
        this.flightNumber = new Random().nextInt();
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append("Flight Number: ").append(flightNumber)
                .append(" From: ").append(from)
                .append(" To: ").append(to)
                .append(" Departure Time: ").append(departureTime)
                .append(" Arrival Time: ").append(arrivalTime)
                .append(" Price: ").append(price);

        System.out.println(builder);
    }
}
