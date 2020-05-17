## 学习笔记

### 作业

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。

#### 解题思路

1. 因为原数组时个半有序数组，所以如果把数组从中间位置切成2个数组，则会得到一个有序子数组和一个半有序子数组。
2. 而且无序的位置一定会位于半有序的子数组里。
3. 这样一直找半有序的子数组，直到半有序数组只有2个元素，并且第一个元素大于第二元素，表明第二个元素就是原数组中间无序的地方。

#### 代码实现

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnOrderPosition {

    @Test
    public void testUnOrderPosition() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int position = unOrderPosition(nums);
        Assertions.assertEquals(4, position);
    }

    public int unOrderPosition(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right || (right - left == 1 && nums[left] >= nums[right])) {
                return right;
            }
            int mid = left + (right - left) / 2;
            //左半部分是有序数组
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else {//右半部分是有序数组
                right = mid;
            }
        }
        return -1;
    }
}
```

left = 0, right = 6,mid = 3

left = 3, right = 6,mid = 4

left = 3, right = 4,mid = 4



