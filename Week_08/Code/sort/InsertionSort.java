package sort;

/**
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * <p>
 * 1.从第一个元素开始，该元素可以认为已经被排序；
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5.将新元素插入到该位置后；
 * 6.重复步骤2~5。
 */
public class InsertionSort {
    public void sort(int[] nums) {
        int length = nums.length;
        int preIndex = 0;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            int current = nums[i];
            //给当前元素寻找插入位置
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            //preIndex的后面插入当前元素
            nums[preIndex + 1] = current;
        }
    }
}
