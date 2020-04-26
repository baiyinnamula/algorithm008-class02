package topKFrequent347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] ans = new int[k];
        int j = 0;
        for (int pos = bucket.length - 1; pos >= 0 && j < k; pos--) {
            if (bucket[pos] != null) {
                for (int i = 0; i < bucket[pos].size(); i++) {
                    ans[j++] = bucket[pos].get(i);
                }
            }
        }


        return ans;
    }
}
