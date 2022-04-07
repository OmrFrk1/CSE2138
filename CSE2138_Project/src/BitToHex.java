import java.util.ArrayList;

public class BitToHex {

    public static String bitToHex(String bit) {
        ArrayList<String> hexList = new ArrayList<String>();
        int index = 0;
        while (index < bit.length()) {
            hexList.add(bit.substring(index, Math.min(index + 4, bit.length())));
            index += 4;
        }

        String hexString = new String();
        for(String current : hexList){
        switch (current) {
            case "0000":
                hexString = hexString + "0";
                break;
            case "0001":
                hexString = hexString + "1";
                break;
            case "0010":
                hexString = hexString + "2";
                break;
            case "0011":
                hexString = hexString + "3";
                break;
            case "0100":
                hexString = hexString + "4";
                break;
            case "0101":
                hexString = hexString + "5";
                break;
            case "0110":
                hexString = hexString + "6";
                break;
            case "0111":
                hexString = hexString + "7";
                break;
            case "1000":
                hexString = hexString + "8";
                break;
            case "1001":
                hexString = hexString + "9";
                break;
            case "1010":
                hexString = hexString + "A";
                break;
            case "1011":
                hexString = hexString + "B";
                break;
            case "1100":
                hexString = hexString + "C";
                break;
            case "1101":
                hexString = hexString + "D";
                break;
            case "1110":
                hexString = hexString + "E";
                break;
            case "1111":
                hexString = hexString + "F";
                break;
        }
        }
        return hexString;


    }



}
