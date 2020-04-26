package fizzBuzz412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int i = 1; i <= n; i++) {
            String numAnsStr = "";
            for (Map.Entry entry : map.entrySet()) {
                if (i % (int) entry.getKey() == 0) {
                    numAnsStr += entry.getValue();
                }
            }
            if (numAnsStr.equals("")) {
                numAnsStr += String.valueOf(i);
            }
            ret.add(numAnsStr);
        }
        return ret;
    }
}
