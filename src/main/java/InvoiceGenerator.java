public class InvoiceGenerator {
    private final int COSTPERKM = 10;
    private final int COSTPERMINUTE = 1;
    public int MIN_FARE = 5;
    double totalFare;
    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {

        totalFare = COSTPERKM * distance + COSTPERMINUTE * time;
        return Math.max(totalFare,MIN_FARE);
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculateTotalFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        return totalFare;
    }

    public int numberOfRides(Rides[] rides) {
        return rides.length;
    }

    public double calculateAverageFarePerRide(Rides[] rides) {
        double totalFare = this.calculateTotalFare(rides);
        double numberOfRides = rides.length;
        double averageFare = totalFare/numberOfRides;
        return averageFare;
    }

    public double getRidesDetails(String userID) {
        return this.calculateTotalFare(rideRepository.getRides(userID));
    }

    public void addRides(String userID, Rides[] rides) {
        rideRepository.addRides(userID, rides);
    }

}
