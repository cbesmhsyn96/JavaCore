package taxi;

import consts.InitializedFinalValues;

public class TurkishTaxi extends InitializedFinalValues {
    /*
    Distance traveled (in km) -- Gidilen KM
    Cost per kilometer -- KM Başına Ücret
    Fare = Base Fare + (Distance Traveled × Cost per Kilometer)
    If Fare < 20 TL then
    Fare = 20 TL
     */
    private static int distanceKm;

    public static int getdistanceKm() {
        return distanceKm;
    }

    public void setdistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double calcTotallyCost(int distanceKm){
        setdistanceKm(distanceKm);
        double totallyCost = baseFare + (getdistanceKm() * costPerKilometer);
        return totallyCost;
    }
}
