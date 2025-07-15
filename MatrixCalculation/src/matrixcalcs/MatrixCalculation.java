package matrixcalcs;

import display.DisplayMatrix;

import java.util.regex.Pattern;

public class MatrixCalculation extends DisplayMatrix {

    protected static void transpozeArray(int[][] mtrx) {
        matrixT = new int[columnCountInt][lineCountInt];
        for (int j = 0; j < columnCountInt; j++) {
            for (int i = 0; i < lineCountInt; i++) {
                matrixT[j][i] = mtrx[i][j];
                System.out.print(matrixT[j][i]+" ");
            }
            System.out.println();
        }
    }

    protected static void matrixAddition(){
        int [][]addition;
        do {
            System.out.println("İlk matrisin satır ve sütunlarını girin");
            initializeMatrix();
            System.out.println("İkinci matrisin satır ve sütunlarını girin");
            initializeAnotherMatrix();
            if(!getColumnCount().equals(getColumnCount2())||!getLineCount().equals(getLineCount2())){
                System.out.println("Lütfen matrisleri satır sayılarını eşit ve sütun sayılarını eşit olacak şekilde ayarlayınız...");
            }
        }while (!getColumnCount().equals(getColumnCount2())||!getLineCount().equals(getLineCount2()));
        addition = new int[lineCountInt][columnCountInt];
        System.out.println("Matrix1");
        displayArray(matrix,lineCountInt,columnCountInt);
        System.out.println("Matrix2");
        displayArray(anotherMatrix,lineCountInt,columnCountInt);
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt; j++) {
                addition[i][j] = matrix[i][j]+anotherMatrix[i][j];
            }
        }
        System.out.println("Toplam matris");
        displayArray(addition,lineCountInt,columnCountInt2);
    }

    protected static void matrixDifference(){
        int [][]difference;
        do {
            System.out.println("İlk matrisin satır ve sütunlarını girin");
            initializeMatrix();
            System.out.println("İkinci matrisin satır ve sütunlarını girin");
            initializeAnotherMatrix();
            if(!getColumnCount().equals(getColumnCount2())||!getLineCount().equals(getLineCount2())){
                System.out.println("Lütfen matrisleri satır sayılarını eşit ve sütun sayılarını eşit olacak şekilde ayarlayınız...");
            }
        }while (!getColumnCount().equals(getColumnCount2())||!getLineCount().equals(getLineCount2()));
        difference = new int[lineCountInt][columnCountInt];
        System.out.println("Matrix1");
        displayArray(matrix,lineCountInt,columnCountInt);
        System.out.println("Matrix2");
        displayArray(anotherMatrix,lineCountInt,columnCountInt);
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt; j++) {
                difference[i][j] = matrix[i][j]-anotherMatrix[i][j];
            }
        }
        System.out.println("Fark matris");
        displayArray(difference,lineCountInt,columnCountInt2);
    }
    
}
