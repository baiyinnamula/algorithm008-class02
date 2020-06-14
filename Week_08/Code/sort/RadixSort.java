package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
 * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
 * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 * <p>
 * 算法描述
 * 1.取得数组中的最大数，并取得位数；
 * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
 * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 * 算法分析
 * 基数排序基于分别排序，分别收集，所以是稳定的。
 * 但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，
 * 而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。
 * 假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。
 * 基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k，因此额外空间需要大概n个左右。
 */
public class RadixSort {
    public void sort(int[] nums) {
        int maxDigit = 1;
        for (int n : nums) {
            maxDigit = Math.max(maxDigit, (int) Math.log10(Math.abs(n)) + 1);
        }

        Map<Integer, List<Integer>> buckets;
        for (int i = 0, dev = 1; i < maxDigit; i++, dev *= 10) {
            buckets = new HashMap<>();
            for (int num : nums) {
                int bucketKey = (num % (dev * 10)) / dev;
                buckets.computeIfAbsent(bucketKey, k -> new ArrayList<>());
                buckets.get(bucketKey).add(num);
            }
            int pos = 0;
            for (List<Integer> list : buckets.values()) {
                for (Integer v : list) {
                    nums[pos++] = v;
                }
            }
        }
    }
}
