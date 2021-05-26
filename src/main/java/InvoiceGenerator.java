public class InvoiceGenerator {
    private final int COSTPERKM = 10;
    private final int COSTPERMINUTE = 1;
    public int MIN_FARE = 5;
    double totalFare;
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


}
