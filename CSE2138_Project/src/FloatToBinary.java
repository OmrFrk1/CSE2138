import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloatToBinary {
    public static int exponent;
    public static String signBit;
    public static int fractionSize;

    public static String shiftBinary(String binary) {
        int pointIndex = binary.indexOf(".");
        exponent = pointIndex - 1;
        binary = binary.replace(".", "");

        binary = binary.charAt(0) + "." + binary.substring(1);
        return binary;

    }

    public static String floatToBinary(String flt, int floatSize) {
        if (Float.parseFloat(flt) > 0) signBit = "0";
        else signBit = "1";


        String[] temp = flt.split("\\.");
        List<String> temp1 = Arrays.asList(temp);
        String left = temp1.get(0);
        String right = temp1.get(1);
        String leftBin = IntToBit.unsignedToBitFloat(Integer.parseInt(left));
        exponent = leftBin.length() - 1;
        String rightBin = decimalConvert(right, floatSize);
        return leftBin + "." + rightBin;
    }

    public static String decimalConvert(String decimal, int floatSize) {

        decimal = "0." + decimal;
        Float floatDecimal = Float.parseFloat(decimal);
        String s = "";
        while (floatDecimal != 1.0 && s.length() < 23) {
            floatDecimal *= 2;
            String temp = String.valueOf(floatDecimal).substring(0, String.valueOf(floatDecimal).indexOf("."));

            s = s + temp;
            floatDecimal = Float.parseFloat("0" + String.valueOf(floatDecimal).substring(String.valueOf(floatDecimal).indexOf(".")));


        }
        return s;
    }


    public static String calcBias(int floatSize) {

        switch (floatSize) {
            case 1 -> fractionSize = 4;
            case 2 -> fractionSize = 7;
            case 3 -> fractionSize = 13;
            case 4 -> fractionSize = 19;
        }
        int bias = (int) Math.pow(2, fractionSize) - 1;
        bias += exponent;

        return IntToBit.unsignedToBitFloat(bias);

    }

    public static String roundBinary(String binary, int fractionSize) {
        String[] temp = binary.split("\\.");
        List<String> temp1 = Arrays.asList(temp);

        if (temp1.get(1).charAt(fractionSize) == '0') {

            return temp1.get(1).substring(0, fractionSize);

        } else {

            return IntToBit.binaryAddition(temp1.get(1).substring(0, fractionSize), "1");
        }


    }

    public static String lastOperations(String flt, int floatSize) {
        switch (floatSize) {
            case 1 -> fractionSize = 4;
            case 2 -> fractionSize = 7;
            case 3 -> fractionSize = 13;
            case 4 -> fractionSize = 19;
        }
        String binary = floatToBinary(flt, floatSize);
        String bias = calcBias(floatSize);
        String shifted = shiftBinary(binary);
        String rounded = roundBinary(shifted, fractionSize);

        return signBit + bias + rounded;

    }
}
