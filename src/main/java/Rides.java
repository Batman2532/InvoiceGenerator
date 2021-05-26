class Rides {
    public PremiumRide rideType;
    public double distance;
    public int time;


    public Rides(double distance, int time, PremiumRide type) {
        this.distance = distance;
        this.time = time;
        this.rideType=type;
    }
}