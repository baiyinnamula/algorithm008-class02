package lemonadeChange860;

/**
 * 解题思路：贪婪算法
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution1 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        boolean result = true;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    result = false;
                    break;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
