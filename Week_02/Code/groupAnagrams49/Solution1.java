package groupAnagrams49;

import java.util.*;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0){
            return ans;
        }
        Map<String,List<String>> map = new HashMap<>();
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            String sorted = sort(strs[i]);
            if (!map.containsKey(sorted)) {
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
