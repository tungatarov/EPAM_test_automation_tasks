package collections.main.cabcompany.cars;

import collections.main.cabcompany.models.CarBodyType;
import collections.main.cabcompany.models.ComfortLevel;

import java.util.Objects;

public class PassengerCar extends Car {

    private final int numOfPassengerSeats;
    private final ComfortLevel comfortLevel;
    private final CarBodyType carBodyType;

    public PassengerCar(String model, int maxSpeed, double fuelConsumption, double price, int numOfPassengerSeats,
                                            ComfortLevel comfortLevel, CarBodyType carBodyType) {
        super(model, maxSpeed, fuelConsumption, price);
        this.numOfPassengerSeats = numOfPassengerSeats;
        this.comfortLevel = comfortLevel;
        this.carBodyType = carBodyType;
    }

    public int getNumOfPassengerSeats() {
        return numOfPassengerSeats;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public CarBodyType getCarBodyStyle() {
        return carBodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return numOfPassengerSeats == that.numOfPassengerSeats &&
                comfortLevel == that.comfortLevel &&
                carBodyType == that.carBodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfPassengerSeats, comfortLevel, carBodyType);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", numOfPassengerSeats=" + numOfPassengerSeats +
                ", comfortLevel=" + comfortLevel +
                ", bodyType=" + carBodyType +
                "}\n");
    }
}
