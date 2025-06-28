package discount;

import constants.Defines;

import static discount.TicketDiscountCalculator.applyDiscount;
import static passenger.PassengerInfos.*;

public class AllCalculations extends Defines {
    /*
    Otobüs içi satın almalar
     */
    protected static double calculateBaseFare(double distance, int tripType){
        return farePerKm*distance*tripType;
    }

    protected static void calculateFinalPrice(){
        if(applyDiscount(getAge(),getTripType(),
                calculateBaseFare(
                        getTripDistance(),
                        getTripType()))>0){
            System.out.printf("Ticket price is %.2f",
                    applyDiscount(getAge(),getTripType(),
                            calculateBaseFare(
                                    getTripDistance(),
                                    getTripType())));
        }
    }
}