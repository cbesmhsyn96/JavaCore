
import javax.xml.crypto.dom.DOMURIReference;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TryingClass extends Customer{
    public static double sepetToplamı(List<Double> toplamlar){
        double sepetToplami = 0.0;
        for (double toplam : toplamlar) {
            sepetToplami += toplam;
        }
        return sepetToplami;
    }
    public static void main(String[] args) {
        List<Double> doubleList = List.of(2.2,4.1,3.3);
        System.out.println(sepetToplamı(doubleList));

    }
}