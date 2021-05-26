public enum PremiumRide {
    Normal(10.0,1.0,5.0),
    Premium(15.0,2.0,20.0);

    private final double costPerKm;
    private final double costPerMin;
    private final double minFare;

    PremiumRide(double costPerKm, double costPerMin, double minFare){
        this.costPerKm=costPerKm;
        this.costPerMin=costPerMin;
        this.minFare=minFare;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public double getCostPerMin() {
        return costPerMin;
    }

    public double getMinFare() {
        return minFare;
    }

}
