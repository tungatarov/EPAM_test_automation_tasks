package collections.main.cabcompany;

import collections.main.cabcompany.cars.Car;
import collections.main.cabcompany.cars.PassengerCar;
import collections.main.cabcompany.models.CarBodyType;
import collections.main.cabcompany.models.ComfortLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaxiStation {

    private final Scanner scanner;
    private final File dir;
    private final List<Car> cars;

    public TaxiStation() {
        this.scanner = new Scanner(System.in);
        this.cars = new ArrayList<>();
        this.dir = new File("./src/files");
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runConsoleMenu() {
        do {
            System.out.println("Input the action (add, calculate, sort, filter, import, export, exit):");
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    addTheCar();
                    break;
                case "calculate":
                    getTheTotalCostOfAllCars();
                    break;
                case "sort":
                    sortCarsByFuelConsumption();
                    break;
                case "filter":
                    filterCarsInGivenSpeedRange();
                    break;
                case "import":
                    importAllAvailableCarsToListFromFile();
                    break;
                case "export":
                    writeAllAvailableCarsToFile();
                    break;
                case "exit":
                    System.out.println("Bye bye!");
                    return;
                default:
                    System.out.println("That action does not exist, please input again.");
            }
        } while (true);
    }

    private void addTheCar() {
        String model = askUserAboutCarModel();
        int maxSpeed = askUserAboutCarMaxSpeed();
        double fuelConsumption = askUserAboutFuelConsumption();
        double price = askUserAboutCarPrice();
        int numOfPassengerSeats = askUserAboutNumOfPassengerSeats();
        ComfortLevel comfortLevel = askUserAboutComfortLevelOfCar();
        CarBodyType carBodyType = askUserAboutCarBodyType();
        addTheCarIntoList(new PassengerCar(model, maxSpeed, fuelConsumption, price,
                        numOfPassengerSeats, comfortLevel, carBodyType));
    }

    private String askUserAboutCarModel() {
        System.out.println("The model:");
        return scanner.nextLine();
    }

    private int askUserAboutCarMaxSpeed() {
        System.out.println("The maximum speed, km / h:");
        return Integer.parseInt(scanner.nextLine());
    }

    private double askUserAboutFuelConsumption() {
        System.out.println("The fuel consumption, l / 100km:");
        return Double.parseDouble(scanner.nextLine());
    }

    private double askUserAboutCarPrice() {
        System.out.println("The price, dollars us:");
        return Double.parseDouble(scanner.nextLine());
    }

    private int askUserAboutNumOfPassengerSeats() {
        System.out.println("The number of passenger seats:");
        return Integer.parseInt(scanner.nextLine());
    }

    private ComfortLevel askUserAboutComfortLevelOfCar() {
        do {
            System.out.println("Input the comfort level (economy, business, premium):");
            String input = scanner.nextLine();
            switch (input) {
                case "economy":
                    return ComfortLevel.ECONOMY;
                case "business":
                    return ComfortLevel.BUSINESS;
                case "premium":
                    return ComfortLevel.PREMIUM;
                default:
                    System.out.println("That action does not exist, please input again.");
                    break;
            }
        } while (true);
    }

    private CarBodyType askUserAboutCarBodyType() {
        do {
            System.out.println("Input the car's body type (sedan, hatchback, station, crossover, suv, van, pickup):");
            String input = scanner.nextLine();
            switch (input) {
                case "sedan":
                    return CarBodyType.SEDAN;
                case "hatchback":
                    return CarBodyType.HATCHBACK;
                case "station":
                    return CarBodyType.STATION_WAGON;
                case "crossover":
                    return CarBodyType.CROSSOVER;
                case "suv":
                    return CarBodyType.SUV;
                case "van":
                    return CarBodyType.VAN;
                case "pickup":
                    return CarBodyType.PICKUP;
                default:
                    System.out.println("That action does not exist, please input again.");
            }
        } while (true);
    }

    protected void addTheCarIntoList(Car car) {
        cars.add(car);
        System.out.printf("The Car (\"%s\") has been added.\n", car.getModel());
    }




    private void getTheTotalCostOfAllCars() {
        System.out.printf("The cost of the vehicle fleet: %s$\n", cars.stream().mapToDouble(Car::getPrice).sum());
    }

    private void sortCarsByFuelConsumption() {
        System.out.println("Sorting of cars in the fleet by fuel consumption:");
        cars.forEach(System.out::print);
    }

    private void filterCarsInGivenSpeedRange() {
        System.out.println("Find cars in the fleet by speed in a given range of speed:");
        System.out.println("Input min speed:");
        int fromMin = Integer.parseInt(scanner.nextLine());
        System.out.println("input max speed:");
        int toMax = Integer.parseInt(scanner.nextLine());
        cars.stream()
                .filter(car -> car.getMaxSpeed() > fromMin && car.getMaxSpeed() < toMax)
                .sorted(Comparator.comparingInt(Car::getMaxSpeed))
                .forEach(System.out::print);
    }



    private void writeAllAvailableCarsToFile() {
        String fileName = askUserAboutFileName();
        try (PrintWriter printWriter = new PrintWriter(new File(dir, fileName))) {
            for (Car car : cars) {
                PassengerCar that = (PassengerCar) car;
                printWriter.println(that.getModel());
                printWriter.println(that.getMaxSpeed());
                printWriter.println(that.getFuelConsumption());
                printWriter.println(that.getPrice());
                printWriter.println(that.getNumOfPassengerSeats());
                printWriter.println(that.getComfortLevel());
                printWriter.println(that.getCarBodyStyle());
            }
            System.out.printf("%d cards have been saved.\n", cars.size());
        } catch (FileNotFoundException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    private String askUserAboutFileName() {
        System.out.println("File name:");
        return scanner.nextLine();
    }




    private void importAllAvailableCarsToListFromFile() {
        String fileName = askUserAboutFileName();
        int count = 0;
        try (Scanner scanner = new Scanner(new File(dir, fileName))) {
            while (scanner.hasNext()) {
                String model = scanner.nextLine();
                int maxSpeed = Integer.parseInt(scanner.nextLine());
                double fuelConsumption = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                int numOfPassengerSeats = Integer.parseInt(scanner.nextLine());
                ComfortLevel comfortLevel = ComfortLevel.valueOf(scanner.nextLine());
                CarBodyType carBodyType = CarBodyType.valueOf(scanner.nextLine());
                cars.add(new PassengerCar(model, maxSpeed, fuelConsumption,
                        price, numOfPassengerSeats, comfortLevel, carBodyType));
                count++;
            }
            System.out.printf("%d cars have been loaded.\n", count);
        } catch (FileNotFoundException e) {
            System.out.println("The file not found.");
        }
    }

    @Override
    public String toString() {
        return "TaxiStation{\n" +
                "cars{\n" + cars +
                '}';
    }
}
