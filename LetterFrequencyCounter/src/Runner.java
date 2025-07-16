import display.DisplayCounts;

public class Runner extends DisplayCounts {

    public static void main(String[] args) {
        do {
            System.out.println("Dizgede harf frekansı hesaplama başlatılıyor...");
            displayLetterCounts(letterCounter());
            System.out.println();
        }while (true);
    }

}