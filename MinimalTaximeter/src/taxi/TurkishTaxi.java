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
        if(totallyCost<20.0){
            return 20.0;
        }else{
            return totallyCost;
        }
    }

    public static void taximeter(boolean continueRideStatus){
        TurkishTaxi turkishTaxi;
        do {
            System.out.print("Yolculuk başlasın mı [evet/hayır]:");
            String yesNo = scanner.nextLine();
            if(yesNoPattern.matcher(yesNo).matches()){
                if(yesNo.equals("evet")){
                    continueRideStatus = continueRideStatus;
                    int distanceKM = 0;
                    do {
                        if(distanceKM==0){
                            System.out.print("Hoşgeldiniz nereye gideceksiniz [biryere(tek seçenek)] --> ");
                            String biryerText = scanner.nextLine();
                            int requiredDistanceKm = (int)(Math.random() * 50) + 1;
                            if(biryerePattern.matcher(biryerText).matches()){
                                if(distanceKM==0){
                                    System.out.println("[Yolculuk başladı...]");
                                }
                                while (distanceKM<requiredDistanceKm){
                                    System.out.println("Navigasyon verisi -- Hedefe varılması için gidilmesi gereken "+(requiredDistanceKm-distanceKM)+" km.");
                                    System.out.print("Arabayı sür [ENTER tuşuna bas]");
                                    scanner.nextLine();
                                    distanceKM++;
                                    if((requiredDistanceKm-distanceKM) == 0){
                                        double constTotally = new TurkishTaxi().calcTotallyCost(requiredDistanceKm);
                                        System.out.printf("Yolculuk tamamlandı. Tutar: %.2f TL%n", constTotally);
                                        continueRideStatus = false;
                                        break;
                                    }
                                }

                            }
                        }
                    }while (continueRideStatus == true);
                } else if (yesNo.equals("hayır")) {
                    System.out.println("Uyumaya devam :)");
                    break;
                }
            }
        }while (true);
    }
}