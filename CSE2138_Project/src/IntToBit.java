public class IntToBit {
    public static String unsignedToBit(int unsignedInt){
        String s = "";
        unsignedInt = Math.abs(unsignedInt);
        while (unsignedInt > 0)
        {
            s =  ( (unsignedInt % 2 ) == 0 ? "0" : "1") +s;
            unsignedInt = unsignedInt / 2;
        }
        while(s.length()<16){
            s= s.substring(0,0)+"0"+s.substring(0);
        }
        return s;
    }
    public static String unsignedToBitFloat(int unsignedInt) {
        String s = "";
        unsignedInt = Math.abs(unsignedInt);
        while (unsignedInt > 0) {
            s = ((unsignedInt % 2) == 0 ? "0" : "1") + s;
            unsignedInt = unsignedInt / 2;
        }
        return s;
    }
    public static String signedToBit(int signedInt){
        String s = "";
        if(signedInt > 0){

            while(signedInt>0)
            {
                s =  (( signedInt % 2 ) == 0 ? "0" : "1") +s;
                signedInt = signedInt / 2;
            }
            while(s.length()<16){
                s= s.substring(0,0)+"0"+s.substring(0);
            }


        }
        if(signedInt <0){
            int temp = Math.abs(signedInt);
            while(temp>0)
            {
                s =  (( temp % 2 ) == 0 ? "0" : "1") +s;
                temp = temp / 2;
            }

            while(s.length()<15){
                s= s.substring(0,0)+"0"+s.substring(0);
            }
            s = convertOppositeSign(s);
            s= s.substring(0,0)+"1"+s.substring(0);
        }
        else
            s="0000000000000000";
        return s;
    }
    public static String convertOppositeSign(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') sb.append("0");
            if (c == '0') sb.append("1");
        }
        return binaryAddition(sb.toString(),"1");
    }
    public static String binaryAddition(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int first = s1.length() - 1;
        int second = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += s1.charAt(first) - '0';
                first--;
            }
            if (second >= 0) {
                sum += s2.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0)
            sb.append('1');

        sb.reverse();
        return String.valueOf(sb);
    }
}
