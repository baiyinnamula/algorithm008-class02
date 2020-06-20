package reverseWords151;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" +");
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }
}
