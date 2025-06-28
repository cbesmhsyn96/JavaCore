package discount;

public class TicketDiscountCalculator extends AllCalculations{

    protected static double applyDiscount(int age, int tripType, double ticketPrice){
        double ticketPriceValue = ticketPrice;
        if(tripType == 2){
            ticketPriceValue = ticketPriceValue - (ticketPriceValue*20)/100;
        }
        if(age<12){
            return  ticketPriceValue - (ticketPriceValue*50)/100;
        }else if (age>=12&&age<=14){
            return ticketPriceValue - (ticketPriceValue*10)/100;
        } else if (age>65) {
            return ticketPriceValue - (ticketPriceValue*30)/100;
        } else {
            return ticketPriceValue;
        }
    }
}
