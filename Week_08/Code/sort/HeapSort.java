package sort;

/**
 * 算法描述
 * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {

    public void sort(int[] nums){
        buildMaxHeap(nums);
        int length = nums.length;
        for (int i = nums.length; i >0; i--) {
            swap(nums,0,i);
            length--;
            heapify(nums,0,length);

        }
    }

    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length / 2; i >= 0; i--) {
            heapify(nums, i,length);
        }
    }

    private void heapify(int[] nums, int i,int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest!= i){
            swap(nums,i,largest);
            heapify(nums,largest,length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
