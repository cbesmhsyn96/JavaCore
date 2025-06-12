import kdv.ProperiesOfKDV;
import product.Product;
import java.util.Scanner;
import java.util.regex.Pattern;

/*KDV Amount = Net Price × (KDV Rate / 100)
  Price Including KDV = Net Price + KDV Amount*/

public class RunProgram {
    public static void main(String[] args) {
        Product product;
        ProperiesOfKDV properiesOfKDV;
        Scanner scanner = new Scanner(System.in);
        int choice;
        Pattern patternStrTr = Pattern.compile("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+");
        Pattern patternNumber = Pattern.compile("\\d+");

        do {
            System.out.println("....Program Starting....");
            product = new Product(0.18);
            System.out.print("Product name: ");
            String namePr = scanner.nextLine();
            if (!patternStrTr.matcher(namePr).matches()) {
                System.out.println("Invalid product name!");
                continue;
            }
            product.setNameProduct(namePr);

            System.out.print("Product quantity: ");
            String countProductInput = scanner.nextLine();
            if (!patternNumber.matcher(countProductInput).matches()) {
                System.out.println("Invalid product quantity!");
                continue;
            }
            int countPr = Integer.parseInt(countProductInput);
            product.setCount(countPr);

            System.out.print("Product net price (excluding KDV): ");
            String priceExcludedProductFee = scanner.nextLine();
            if (!patternNumber.matcher(priceExcludedProductFee).matches()) {
                System.out.println("Invalid net price!");
                continue;
            }
            int pricePr = Integer.parseInt(priceExcludedProductFee);
            product.setPriceProduct(pricePr);

            System.out.println("-----MENU-----");
            System.out.print("""
            1-) Calculate price including KDV
            2-) Calculate price excluding KDV
            3-) Calculate both including and excluding KDV
            Choose [1, 2 or 3]: """);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Unit price of " + product.getNameProduct() + " including KDV = " + product.calculatePriceIncludeKDV());
                    System.out.println(product.getCount() + " units of " + product.getNameProduct() + " total price including KDV = " + (double) product.calculatePriceIncludeKDV() * product.getCount() * product.getPriceProduct());
                    continue;
                case 2:
                    System.out.println("Unit price of " + product.getNameProduct() + " excluding KDV = " + product.getPriceProduct());
                    System.out.println(product.getCount() + " units of " + product.getNameProduct() + " total price excluding KDV = " + (double) product.getPriceProduct() * product.getCount());
                    continue;
                case 3:
                    System.out.println("Unit price of " + product.getNameProduct() + " including KDV = " + product.calculatePriceIncludeKDV());
                    System.out.println(product.getCount() + " units of " + product.getNameProduct() + " total price including KDV = " + (double) product.calculatePriceIncludeKDV() * product.getCount() * product.getPriceProduct());
                    System.out.println("Unit price of " + product.getNameProduct() + " excluding KDV = " + product.getPriceProduct());
                    System.out.println(product.getCount() + " units of " + product.getNameProduct() + " total price excluding KDV = " + (double) product.getPriceProduct() * product.getCount());
                    continue;
                default:
                    System.out.println("Invalid choice.");
                    System.out.println("Terminating the process...");
                    break;
            }

            String continueProcess;
            System.out.print("Would you like to start a new process [yes/no]: ");
            continueProcess = scanner.nextLine();
            if (continueProcess.equals("no") || !continueProcess.equals("yes")) {
                if (continueProcess.equals("no")) {
                    break;
                } else if (!continueProcess.equals("yes")) {
                    break;
                }
            }
        } while (true);
    }
}
