package sort;

/**
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * <p>
 * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            //找到基准元素位置
            int partitionIndex = partition(nums, left, right);
            //通过基准元素位置分割为两个子数组，分别进行排序
            sort(nums, left, partitionIndex - 1);
            sort(nums, partitionIndex + 1, right);
        }
    }

    /**
     * 分区操作
     */
    private int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            //如果当前元素小于基准元素，则挪到所有已找到小于元素的最右边去
            if (nums[i] < nums[left]) {
                swap(nums, i, index++);
            }
        }
        //基准元素与最右边小于基准的元素交换位置
        swap(nums, left, index - 1);
        //返回基准元素位置
        return index - 1;
    }

    /**
     * 交换两个元素位置
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
