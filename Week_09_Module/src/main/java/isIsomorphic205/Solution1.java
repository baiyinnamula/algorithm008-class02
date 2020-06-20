package isIsomorphic205;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss)) {
                if (map.get(ss) != tt) {
                    return false;
                }
            } else {
                map.put(ss, tt);
            }
        }
        return true;
    }
}
