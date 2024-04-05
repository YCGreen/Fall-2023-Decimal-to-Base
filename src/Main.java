

public class Main {
    public static void main(String[] args) {

        System.out.print(ConvertDecimalToBase(123987.4987, 7));
    }

    public static String ConvertDecimalToBase(double num, int base) {
        String wholeResult = "";
        String decResult = "";
        int whole = (int)removeDecimals(num, 0);
        double dec = removeDecimals(num, 1);
        int modBase;

        while(whole > 0) {
            modBase = whole%base;
            if(modBase > 9) {
                wholeResult = over10(modBase) + wholeResult;
            }

            else {
                wholeResult = String.valueOf(modBase) + wholeResult;
            }

            whole = whole / base;
        }

       for(int i = 0; i < 10; i++) {

            dec *= base;
            if(dec >= 1 && dec < 10) {
                decResult += String.valueOf((int)removeDecimals(dec, 0));
                dec = removeDecimals(dec, 1);
            }
            else if(dec >= 10) {
                decResult += over10((int)dec);
                dec = removeDecimals(dec, 1);
            }
            else {
                decResult += "0";
            }

         }

        return wholeResult + "." + decResult;
    }

    //if input is 0, return whole number; if 1 return decimal
    public static double removeDecimals(double num, int dec1) {
        String str = String.valueOf(num);
        int index = str.indexOf(".");

        if(dec1 == 0) {
            return Double.parseDouble(str.substring(0, index));
        }

        return Double.parseDouble("0." + (str.substring(index+1, str.length())));
    }

    public static String over10(int num) {
        switch(num) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            case 16:
                return "G";
            case 17:
                return "H";
            case 18:
                return "I";
            case 19:
                return "J";
        }

        return "";
    }
}