package sort;

/**
 * 算法描述：
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * <p>
 * 1.初始状态：无序区为R[1..n]，有序区为空；
 * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
 * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
 * 将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3.n-1趟结束，数组有序化了。
 */
public class SelectionSort {
    public void sort(int[] nums) {
        int length = nums.length;
        int minIndex = 0;
        //这个循环用来排序前i 个元素
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            //这个循环用来找
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //交换第i小的元素和第i位置上的元素
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }
}
