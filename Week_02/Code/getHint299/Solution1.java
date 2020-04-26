package getHint299;

/**
 * 解题思路
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution1 {
    public String getHint(String secret, String guess) {
        //记录 secret 中每个数字的出现次数
        int[] bulls = new int[10];
        //记录 guess 中每个数字的出现次数
        int[] cows = new int[10];
        //公牛数量
        int bullNum = 0;
        //母牛数量
        int cowsNum = 0;
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullNum++;
            } else {
                bulls[secret.charAt(i) - '0'] += 1;
                cows[guess.charAt(i) - '0'] += 1;
            }
        }
        for (int i = 0; i < bulls.length; i++) {
            //相同位置的最小值（代表该数字被才对次数）
            cowsNum += Math.min(bulls[i], cows[i]);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(bullNum);
        builder.append("A");
        builder.append(cowsNum);
        builder.append("B");

        return builder.toString();
    }

}
