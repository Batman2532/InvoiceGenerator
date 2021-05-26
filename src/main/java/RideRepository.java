import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RideRepository {
    public HashMap<String, ArrayList<Rides>> userRides;
    public RideRepository() {
        userRides = new HashMap<>();
    }

    public void addRides(String userID, Rides[] rides) {
        ArrayList<Rides> rideList = this.userRides.get(userID);
        if (rideList == null)
            this.userRides.putIfAbsent(userID, new ArrayList<>(Arrays.asList(rides)));
    }

    public Rides[] getRides(String userID) {
        return this.userRides.get(userID).toArray(new Rides[0]);
    }
}
