package display;

import initialize.InitializeMatrix;

public class DisplayMatrix extends InitializeMatrix {
   protected static void displayArray(int[][] numberArray,int lineCountInt, int columnCountInt) {
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt; j++) {
                System.out.printf("%3d",numberArray[i][j]);
            }
            System.out.println();
        }
    }
}
