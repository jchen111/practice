package AirBnB.phone;

/**
 * Created by z001ktb
 */
public class MultiplyString {
    public static String multiply(String str1, String str2) {
        if(str1 == null || str1.isEmpty()) return str2;
        if(str2 == null || str2.isEmpty()) return str1;
        if(str1.equals("0") || str2.equals("0")) return "0";

        boolean isPositive = (str1.charAt(0) == '-' && str2.charAt(0) == '-') || (str1.charAt(0) != '-' && str1.charAt(0) != '-');

        if(str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        String result = "";
        int carry = 0;
        for(int j = str2.length() - 1; j >= 0; j--) {
            int p1 = Character.getNumericValue(str2.charAt(j));
            StringBuilder local = new StringBuilder();
            for(int k = 0; k < str2.length() - 1 - j; k++) { // pad zeros to local
                local.append(0);
            }
            for(int i = str1.length() - 1; i >= 0; i--) {
                int p2 = Character.getNumericValue(str1.charAt(i));
                local.insert(0,(p1 * p2 + carry) % 10);
                carry = (p1 * p2 + carry) / 10;
            }
            if(carry != 0) {
                local.insert(0, carry);
            }
            result = add(local.toString(), result);
            carry = 0;
        }
        if(!isPositive) result = "-" + result;
        return result;
    }

    private static String add(String str1, String str2) {
        if(str1 == null || str1.isEmpty()) return str2;
        if(str2 == null || str2.isEmpty()) return str1;
        StringBuilder sb = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0 && j >= 0) {
                int tmp = Character.getNumericValue(str1.charAt(i)) + Character.getNumericValue(str2.charAt(j)) + carry;
                sb.insert(0,tmp % 10);
                if(tmp > 9) carry = 1;
                else carry = 0;
                i--;
                j--;
            }
            if(i >= 0) {
                int tmp = Character.getNumericValue(str1.charAt(i)) + carry;
                sb.insert(0,tmp % 10);
                if(tmp > 9) carry = 1;
                else carry = 0;
                i--;
            }
            if(j >= 0) {
                int tmp = Character.getNumericValue(str2.charAt(j)) + carry;
                sb.insert(0,tmp % 10);
                if(tmp > 9) carry = 1;
                else carry = 0;
                j--;
            }
        }
        if(carry == 1) sb.insert(0,1);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
