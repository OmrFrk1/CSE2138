public class OrderingType {
    public static String orderType(String hex, char ordertype) {
        String first = hex.substring(0, 2);
        String last = hex.substring(2);
        if (ordertype == 'l')
            return last + " " + first;
        else
            return first + " " + last;
    }
}
