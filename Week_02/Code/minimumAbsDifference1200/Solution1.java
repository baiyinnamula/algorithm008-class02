package minimumAbsDifference1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //先对数组进行排序
        Arrays.sort(arr);

        //找出最小绝对差
        int minimum = Integer.MAX_VALUE;
        for (int i = 0, j = 1; i < arr.length - 1 && j < arr.length; i++, j++) {
            minimum = Math.min(minimum, arr[j] - arr[i]);
        }

        // 收集符合最小绝对差的数对
        List<List<Integer>> diff = new ArrayList<>();
        for (int i = 0, j = 1; i < arr.length - 1 && j < arr.length; i++, j++) {
            if (arr[j] - arr[i] == minimum) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(arr[i]);
                item.add(arr[j]);
                diff.add(item);
            }
        }

        return diff;
    }
}
