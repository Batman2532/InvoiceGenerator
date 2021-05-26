import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator cabInvoiceGenerator;
    @BeforeEach
    public void setUp() throws Exception{
        cabInvoiceGenerator = new InvoiceGenerator();

    }

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 5.0;
        int time = 4;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(54, totalFare,0.0);
    }

    @Test
    void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.3;
        int time = 2;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, totalFare,0.0);
    }

    @Test
    void givenMultipleRides_ShouldInvoiceSummary() {
        Rides[] rides = {new Rides(1.0, 5),
                new Rides(0.2, 2)};
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,20);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void ReturnTotalRidesTotalFareAndAverageFarePerRide() {
        Rides[] rides = {new Rides(1.0, 5),
                new Rides(0.2, 2)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        int noOfRides = cabInvoiceGenerator.numberOfRides(rides);
        double averageFare = cabInvoiceGenerator.calculateAverageFarePerRide(rides);

        Assertions.assertEquals(20, totalFare, 0.0);
        Assertions.assertEquals(2, noOfRides,0.0);
        Assertions.assertEquals(10, averageFare, 0.0);
    }

    @Test
    public void givenUserIdReturnTheInvoice() {
        String userID = "Driver1";
        Rides[] rides = new Rides[]{new Rides(1.0, 5),
                new Rides(0.2, 2)
        };
        cabInvoiceGenerator.addRides(userID, rides);
        double rideDetails = cabInvoiceGenerator.getRidesDetails(userID);
        int NoOfRides = cabInvoiceGenerator.numberOfRides(rides);
        Assertions.assertEquals(20, rideDetails, 0.0);
    }
}
