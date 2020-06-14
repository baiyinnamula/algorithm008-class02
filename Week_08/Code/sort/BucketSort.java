package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * <p>
 * 算法描述
 * 1.设置一个定量的数组当作空桶；
 * 2.遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3.对每个不是空的桶进行排序；
 * 4.从不是空的桶里把排好序的数据拼接起来。
 * <p>
 * 算法分析
 * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。
 * 很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
 */
public class BucketSort {

    public void sort(int[] nums) {
        int length = nums.length;
        // 输入数据的最小值
        int min = nums[0];
        // 输入数据的最大值
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        // 设置桶的默认数量为 5
        int default_bucket_size = 5;
        int bucketCount = (max - min) / default_bucket_size + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < length; i++) {
            buckets.get((i - min) / bucketCount).add(nums[i]);
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            int[] n = new int[bucket.size()];
            for (int j = 0; j < bucket.size(); j++) {
                n[j] = bucket.get(j);
            }

            new InsertionSort().sort(n);
            for (int value : n) {
                nums[index++] = value;
            }
        }
    }
}
