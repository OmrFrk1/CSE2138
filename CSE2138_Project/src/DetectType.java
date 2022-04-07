import java.util.*;

public class DetectType {
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    public static LinkedHashMap<String,String> detectType(ArrayList<String> nums) {
        LinkedHashMap<String,String> dictionary = new LinkedHashMap<>();
        Iterator iterator = nums.iterator();

        while (iterator.hasNext()) {
            String temp = (String) iterator.next();
            if (temp.contains("u")) {


                dictionary.put(temp.substring(0, temp.length() - 1), "unsigned");

            } else if (isInteger(temp)) {
                dictionary.put(temp, "int");


            } else {
                dictionary.put(temp, "float");

            }


        }
        return dictionary;
    }
}
