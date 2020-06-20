package reverseWords151;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        Deque<java.lang.String> deque = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        while (left <= right) {
            if (builder.length() > 0 && arr[left] == ' ') {
                deque.offerFirst(builder.toString());
                builder.setLength(0);
            } else if (arr[left] != ' ') {
                builder.append(arr[left]);
            }
            left++;
        }
        deque.offerFirst(builder.toString());

        return String.join(" ", deque);
    }
}
