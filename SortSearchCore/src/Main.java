import search.Searching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main extends Searching {
    public static void main(String[] args) {
        System.out.println("-----Sorting in Ascending Order-----");
        System.out.println(selectionSortFromMinToMax(getNumbers(new ArrayList<>()), ascendingList));
        System.out.println("-----Sorting in Descending Order-----");
        System.out.println(selectionSortFromMaxToMin(getNumbers(new ArrayList<>()), descendingList));
        System.out.println("-----------Jump Search-----------");
        jumbSearch(ascendingList, 5);
        System.out.println("-----------Linear Search-----------");
        linearSearch(getNumbers(new ArrayList<>()), 9);
        System.out.println("-----------Binary Search-----------");
        binarySearch(ascendingList, 9);
    }
}