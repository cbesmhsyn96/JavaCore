import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Main {
    public static void main(String[] args) {

        int length = 6;
        String val = "*";
        String ws = " ";

            for(int j = length; j>0; j--){
                if(j==length){
                    System.out.println(ws.repeat(j+1).concat(val.repeat(length-j+1)));
                }else{
                    System.out.println(ws.repeat(j).concat(val.repeat(length-j+1)).concat(val.repeat(length-j+1)));
                }
            }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(val);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(val);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            if(i==0||i==4){
                System.out.print(val.concat(val.repeat(19)));
            }else{
                System.out.print(val.concat(ws.repeat(18)).concat(val));
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            if(i==0||i==4){
                System.out.print(val.concat(val.repeat(12)));
            }else{
                System.out.print(val.concat(ws.repeat(11)).concat(val));
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int j = length; j>0; j--){
            if(j==length){
                System.out.println(ws.repeat(j+1).concat(val.repeat(length-j+1)));
            }else{
                System.out.println(ws.repeat(j).concat(val).concat(ws.repeat((length-j+1))).concat(ws.repeat((length-j))).concat(val));
            }
            if(j==1){
                System.out.println(val.repeat(length*2+3));
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 6; i > 1; i--) {
            if(i==6){
                System.out.println(ws.repeat(i).concat(val.repeat(20)));
            }else if(i<6&&i>2){
                System.out.println(ws.repeat(i).concat(val).concat(ws.repeat(18)).concat(val));
            } else if (i==2) {
                System.out.println(ws.repeat(i).concat(val.repeat(20)));
            }
        }
    }
}