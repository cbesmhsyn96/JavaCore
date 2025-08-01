package initialize;

import vars.Defines;

import java.util.regex.Pattern;

public class InitializeMatrix extends Defines {

    //protected static int matrix[][];
    protected static String lineCount;
    protected static String columnCount;
    protected static String lineCount2;
    protected static String columnCount2;
    protected static int lineCountInt;
    protected static int columnCountInt;
    protected static int lineCountInt2;
    protected static int columnCountInt2;
    protected static int[][] matrix;
    protected static int[][] anotherMatrix;

    public static String getLineCount2() {
        return lineCount2;
    }

    public static void setLineCount2(String lineCount2) {
        InitializeMatrix.lineCount2 = lineCount2;
    }

    public static String getColumnCount2() {
        return columnCount2;
    }

    public static void setColumnCount2(String columnCount2) {
        InitializeMatrix.columnCount2 = columnCount2;
    }

    public static String getLineCount() {
        return lineCount;
    }

    public static void setLineCount(String lineCount) {
        InitializeMatrix.lineCount = lineCount;
    }

    public static String getColumnCount() {
        return columnCount;
    }

    public static void setColumnCount(String lineCount) {
        InitializeMatrix.columnCount = lineCount;
    }

    public static int[][] getMatrix() {
        return matrix;
    }

    public static void setMatrix(int[][] matrix) {
        InitializeMatrix.matrix = matrix;
    }

    public static int[][] getAnotherMatrix() {
        return anotherMatrix;
    }


    public static void setAnotherMatrix(int[][] anotherMatrix) {
        InitializeMatrix.anotherMatrix = anotherMatrix;
    }

    protected static int[][] initializeMatrix() {
        status = false;
        while (!status){
            System.out.print("Kaç satırlı matris oluşturacaksınız:");
            String lineCount = scanner.nextLine();
            System.out.print("Kaç sütunlu matris oluşturacaksınız:");
            String columnCount = scanner.nextLine();
            setLineCount(lineCount);
            setColumnCount(columnCount);
            if (Pattern.compile("^[1-9]$").matcher(getLineCount()).matches() &&
                    Pattern.compile("^[1-9]$").matcher(getColumnCount()).matches()) {
                lineCountInt = Integer.parseInt(getLineCount());
                columnCountInt = Integer.parseInt(getColumnCount());
                matrix = new int[lineCountInt][columnCountInt];
                setMatrix(matrix);
                for (int i = 0; i < lineCountInt; i++) {
                    for (int j = 0; j < columnCountInt; j++) {
                        randNumber = random.nextInt(9) + 1;
                        matrix[i][j] = randNumber;
                    }
                }
                status = true;
            } else {
                System.out.println("Lütfen 1-9 aralığında rakam giriniz...");
                status = false;
            }
        }
        return getMatrix();
    }

    protected static int[][] initializeSymetricMatrix() {
        int number;
        do{
            System.out.print("Kaç satırlı matris oluşturacaksınız:");
            String lineCount = scanner.nextLine();
            System.out.print("Kaç sütunlu matris oluşturacaksınız:");
            String columnCount = scanner.nextLine();
            setLineCount(lineCount);
            setColumnCount(columnCount);
            if (Pattern.compile("^[1-9]$").matcher(getLineCount()).matches() &&
                Pattern.compile("^[1-9]$").matcher(getColumnCount()).matches()) {
                if(Integer.parseInt(getLineCount())==Integer.parseInt(getColumnCount())){
                    lineCountInt = Integer.parseInt(lineCount);
                    columnCountInt = Integer.parseInt(columnCount);
                    int constNumber = random.nextInt(1,10);
                    matrix = new int[lineCountInt][columnCountInt];
                    for (int k = 0; k < lineCountInt; k++) {
                        matrix[k][k] = constNumber;
                    }

                    for (int k = 0; k < lineCountInt; k++) {
                        for (int l = 0; l < columnCountInt; l++) {
                            number = random.nextInt(1,9);
                            if(k!=l){
                                matrix[k][l] = matrix[l][k] = number;
                            }
                        }
                    }
                    status = true;
                }else{
                    System.out.println("Simetrik matris oluşturabilmek için satır ve sütun sayısının eşit olması gerekir...");
                    status = false;
                }

            } else {
                System.out.println("Lütfen 1-9 aralığında rakam giriniz...");
                status = false;
            }
        }while (status == false);
        System.out.println("Simetrik matris");
        return getMatrix();
    }

    protected static int[][] initializeAnotherMatrix() {
        status = false;
        while (!status){
            System.out.print("Kaç satırlı matris oluşturacaksınız:");
            String lineCount2 = scanner.nextLine();
            System.out.print("Kaç sütunlu matris oluşturacaksınız:");
            String columnCount2 = scanner.nextLine();
            setLineCount2(lineCount2);
            setColumnCount2(columnCount2);
            if (Pattern.compile("^[1-9]$").matcher(getLineCount2()).matches() &&
                    Pattern.compile("^[1-9]$").matcher(getColumnCount2()).matches()) {
                lineCountInt2 = Integer.parseInt(getLineCount2());
                columnCountInt2 = Integer.parseInt(getColumnCount2());
                anotherMatrix = new int[lineCountInt2][columnCountInt2];
                setAnotherMatrix(anotherMatrix);
                for (int i = 0; i < lineCountInt2; i++) {
                    for (int j = 0; j < columnCountInt2; j++) {
                        randNumber = random.nextInt(9) + 1;
                        anotherMatrix[i][j] = randNumber;
                    }
                }
                status = true;
            } else {
                System.out.println("Lütfen 1-9 aralığında rakam giriniz...");
                status = false;
            }
        }
        return anotherMatrix;
    }

    protected static int[][] createIdentityMatrix(){
        while (!status){
            System.out.println("Birim matris oluşturma işlemi başlıyor...");
            System.out.print("Kaç satırlı matris oluşturacaksınız:");
            String linesCount = scanner.nextLine();
            System.out.print("Kaç sütunlu matris oluşturacaksınız:");
            String columnsCount = scanner.nextLine();
            setLineCount(linesCount);
            setColumnCount(columnsCount);
            if (Pattern.compile("^[1-9]$").matcher(getLineCount()).matches() &&
                    Pattern.compile("^[1-9]$").matcher(getColumnCount()).matches()) {
                if(Integer.parseInt(getLineCount())==Integer.parseInt(getColumnCount())){
                    lineCountInt = Integer.parseInt(getLineCount());
                    columnCountInt = Integer.parseInt(getColumnCount());
                    matrix = new int[lineCountInt][columnCountInt];
                    for (int i = 0; i < lineCountInt; i++) {
                        matrix[i][i] = 1;
                    }

                    for (int i = 0; i < lineCountInt; i++) {
                        for (int j = 0; j < columnCountInt; j++) {
                            if(i!=j){
                                matrix[i][j] = 0;
                            }
                        }
                    }
                    status = true;
                    System.out.println("Birim matris oluşturuldu. Ekrana yazdırılıyor.");
                }else{
                    System.out.println("Lütfen satır sayısı ve sütun sayısını eşit giriniz...");
                    status = false;
                }
            }else{
                System.out.println("Lütfen 1-9 aralığında satır sayısı ve sütun sayısı girin...");
                status = false;
            }

        }
        return getMatrix();
    }


}