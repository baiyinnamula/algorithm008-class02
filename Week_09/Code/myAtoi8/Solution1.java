package myAtoi8;

public class Solution1 {
    public int myAtoi(String str) {
        //去除空格
        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }

        char[] arr = str.toCharArray();
        int idx = 0;
        int sign = 1;
        //判断是否有符号
        if (!Character.isDigit(arr[idx])) {
            if (arr[idx] == '+') {
                idx++;
            } else if (arr[idx] == '-') {
                sign = -1;
                idx++;
            } else {
                return 0;
            }
        }

        int ans = 0;
        while (idx < len && Character.isDigit(arr[idx])) {
            int digit = arr[idx] - '0';
            //判断是否超出整数范围
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }

        return sign * ans;
    }
}
