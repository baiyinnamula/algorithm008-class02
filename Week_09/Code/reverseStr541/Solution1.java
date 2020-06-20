package reverseStr541;

public class Solution1 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        //p 是以 k 的2倍速度增加
        for (int p = 0; p < arr.length; p += 2 * k) {
            int i = p;
            //获取反转右边界
            int j = Math.min(p + k - 1, arr.length - 1);
            while (i < j) {
                char tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            }
        }
        return new String(arr);
    }
}
