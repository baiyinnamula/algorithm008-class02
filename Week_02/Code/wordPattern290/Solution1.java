package wordPattern290;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> characterStringHashMap = new HashMap<>();
        Map<String, Character> stringCharacterHashMap = new HashMap<>();
        char[] chars = pattern.toCharArray();
        java.lang.String[] strings = str.split(" ");
        if (chars.length != strings.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!characterStringHashMap.containsKey(chars[i])) {
                characterStringHashMap.put(chars[i], strings[i]);
            } else {
                if (!characterStringHashMap.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            }
            if (!stringCharacterHashMap.containsKey(strings[i])) {
                stringCharacterHashMap.put(strings[i], chars[i]);
            } else {
                if (!stringCharacterHashMap.get(strings[i]).equals(chars[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
