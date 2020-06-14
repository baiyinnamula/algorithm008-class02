package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {

    private int[] nums = {78, 17, 39, 26, 72, 94, 21, 12, 23, 68, 88, 8, 5, 24, 90};

    @Test
    public void testBubbleSort() {
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSelectionSort() {
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testInsertionSort() {
        new InsertionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testShellSort() {
        new ShellSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testMergeSort() {
        int[] ans = new MergeSort().sort(nums);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void testQuickSort() {
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testCountingSort() {
        new CountingSort().sort(nums, 94);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testBucketSort() {
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testRadixSort() {
        new RadixSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
