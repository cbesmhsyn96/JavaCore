import passenger.PassengerInfos;

public class Runner extends PassengerInfos {
    public static void main(String[] args) {
        System.out.println("Bus Ticket Price Calculator - Basic");
        do {
            getPassengerInfo();
            calculateFinalPrice();
            System.out.println("----------------------------");
        }while (true);
    }
}