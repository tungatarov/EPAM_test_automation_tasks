package cars;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Comparable<Car> {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);
    private final int id;
    private final String model;
    private final int maxSpeed;
    private final double fuelConsumption;
    private final double price;

    public Car(String model, int maxSpeed, double fuelConsumption, double price) {
        this.id = atomicInteger.incrementAndGet();
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return id == car.id &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                price == car.price &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, maxSpeed, fuelConsumption, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return Double.compare(fuelConsumption, o.fuelConsumption);
    }
}
