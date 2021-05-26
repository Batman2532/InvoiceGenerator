public class InvoiceGenerator {

    double totalFare;
    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time, PremiumRide type) {
        totalFare = type.getCostPerKm() * distance + type.getCostPerMin() * time;
        return Math.max(totalFare,type.getMinFare());
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.rideType);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculateTotalFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time,ride.rideType);
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
