import java.util.*;

import static gcdlcm.GCDLCMCalculation.*;
import static maxmin.FindMaxMin.findMinAndMaxNumberFromList;
import static perfectnumber.PerfectNumberCheck.getPerfectNumberStatus;


public class Runner{
    public static void main(String[] args) {
        getGCMAndLCM(25,35);
        findMinAndMaxNumberFromList(List.of(2,3,1,5,27,83,23,99,8,0));
        getPerfectNumberStatus();
    }
}