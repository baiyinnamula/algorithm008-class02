package myAtoi8;

public class Solution2 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char c = str.charAt(0);
        if (!Character.isDigit(c) && c != '-' && c != '+') {
            return 0;
        }
        long ans = 0L;
        boolean neg = c == '-';
        int i = Character.isDigit(c) ? 0 : 1;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }

        return neg ? (int)-ans : (int) ans;
    }
}
