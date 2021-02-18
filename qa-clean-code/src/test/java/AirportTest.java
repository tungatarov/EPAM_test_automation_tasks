
import aircompany.Airport;
import aircompany.Planes.ExperimentalPlane;
import aircompany.Planes.MilitaryPlane;
import aircompany.Planes.PassengerPlane;
import aircompany.Planes.Plane;
import aircompany.models.ClassificationLevel;
import aircompany.models.ExperimentalType;
import aircompany.models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @Test
    public void GetTransportMilitaryPlanes() {
        Assert.assertTrue(!new Airport(planes).getTransportMilitaryPlanes().isEmpty());
    }

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void GetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = new Airport(planes)
                                        .getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void PlanesSortedByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = new Airport(planes)
                                            .sortByMaxLoadCapacity()
                                            .getPlanes();
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void HasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(!new Airport(planes).getBomberMilitaryPlanes().isEmpty());
    }

    @Test
    public void ExperimentalPlanesHasAtLeastOneClassificationLevelHigherThanUnclassified() {
        boolean hasHigherThanUnclassifiedPlane = false;
        for (ExperimentalPlane experimentalPlane : new Airport(planes)
                                            .getExperimentalPlanes()) {
            if (experimentalPlane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED) {
                hasHigherThanUnclassifiedPlane = true;
                break;
            }
        }
        Assert.assertTrue(hasHigherThanUnclassifiedPlane);
    }
}
