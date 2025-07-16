package matrixcalcs;

import display.DisplayMatrix;

import java.util.regex.Pattern;

public class MatrixCalculation extends DisplayMatrix {

    protected static void transpozeMatrix(int[][] mtrx) {
        matrixT = new int[columnCountInt][lineCountInt];
        for (int j = 0; j < columnCountInt; j++) {
            for (int i = 0; i < lineCountInt; i++) {
                matrixT[j][i] = mtrx[i][j];
                System.out.print(matrixT[j][i]+" ");
            }
            System.out.println();
        }
    }

    protected static void isSymetricMatrix() {
        do {
            System.out.println("Lüften simetrikliği kontrol edilecek matrisin değerlerini giriniz");

            if(lineCountInt!=columnCountInt){
                System.out.println("Lüften kare matrix giriniz");
            }
        }while (lineCountInt!=columnCountInt);
        matrix = initializeMatrix();
        System.out.println("Simetrik olmayan matris");
        displayArray(matrix,lineCountInt,columnCountInt);
        for (int i = 0; i < lineCountInt; i++) {
            if(i==0){
                temp = matrix[i][i];
            }else{
                if(matrix[i][i]!=temp){
                    System.out.println("      "+matrix[i][i]+" != "+temp);
                    System.out.println("Oluşturulan matris simetrik değil.");
                    break;
                }
            }
        }

        displayArray(initializeSymetricMatrix(),lineCountInt,columnCountInt);
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

    protected static void matrixMultiply(){
        int [][]matrixM;
        do {
            System.out.println("İlk matrisin satır ve sütunlarını girin");
            initializeMatrix();
            System.out.println("İkinci matrisin satır ve sütunlarını girin");
            initializeAnotherMatrix();
            if(!getColumnCount().equals(getLineCount2())){
                System.out.println("Lütfen ilk matrisin satırs sayısı ile ikinci matrisin sütun sayısı eşit olacak şekilde matrisleri oluşturunuz...");
            }
        }while (!getColumnCount().equals(getLineCount2()));
        matrixM = new int[lineCountInt][columnCountInt2];
        System.out.println("Matrix1");
        displayArray(matrix,lineCountInt,columnCountInt);
        System.out.println("Matrix2");
        displayArray(anotherMatrix,lineCountInt2,columnCountInt2);
        int total = 0;
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt2; j++) {
                total = 0;
                for (int k = 0; k < columnCountInt; k++) {
                    total += matrix[i][k] * anotherMatrix[k][j];
                }
                matrixM[i][j] = total;
            }
        }

        System.out.println("Çarpım matris");
        displayArray(matrixM,lineCountInt,columnCountInt2);
    }

    protected static void multiplyMatrixByScalar(){
        int [][]scaledMatrix;
        String scalarNumber;
        do {
            System.out.println("Matrisin satır ve sütunlarını girin");
            initializeMatrix();
            System.out.print("Girdiğiniz matrisin elemanlarının çarpılacağı sabit sayı :");
            scalarNumber = scanner.nextLine();
            if (Pattern.compile("^-*[1-9]\\d*$").matcher(scalarNumber).matches()){
                scalarNumberInt = Integer.parseInt(scalarNumber);
            }else{
                System.out.println("Lütfen tamsayı girin...");
            }
        }while (!Pattern.compile("^-*[1-9]\\d*$").matcher(scalarNumber).matches());
        scaledMatrix = new int[lineCountInt][columnCountInt];
        System.out.println("Scalar multiply matrix");
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt; j++) {
                scaledMatrix[i][j] = matrix[i][j]*scalarNumberInt;
            }
        }
        System.out.println(scalarNumberInt+" ile çarpılacak matris");
        displayArray(matrix,lineCountInt,columnCountInt);
        System.out.println(scalarNumberInt+" ile çarpım sonucu oluşan matris");
        for (int i = 0; i < lineCountInt; i++) {
            for (int j = 0; j < columnCountInt; j++) {
                System.out.print(scaledMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}