### [不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/) 则状态转移方程

```java
//如果当前格子不是障碍物，则到达当前格子的路径数量等于到达上方格子路径数量 + 到达左方格子路径数量 
obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
// 如果当前格子是障碍物，则此路不通，路径数量为0
obstacleGrid[i][j] = 0;
```

### Rabin-Karp 算法

RK 算法可以认为是Brute Force 算法的改进版，RK 算法是借助哈希算法对 BF 算法进行改造，即对每个子串分别求哈希值，然后拿子串的哈希值与模式串的哈希值比较，减少了比较的时间

```java
package rk;

public class RabinKarpSearch {
    public final static int D = 256;
    public final static int Q = 9997;

    static int search(String txt, String pat) {
        int patLength = pat.length();
        int txtLength = txt.length();
        int i, j;
        int patHash = 0, txtHash = 0;
        for (i = 0; i < patLength; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + pat.charAt(i)) % Q;
        }
        //pow(256, M-1)
        int highestPow = 1;
        for (i = 0; i < patLength - 1; i++) {
            highestPow = (highestPow * D) % Q;
        }
        for (i = 0; i < txtLength - patLength; i++) {
            if (patHash == txtHash) {
                for (j = 0; j < patLength; j++) {
                    if (txt.charAt(j + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == patLength) {
                    return i;
                }
            }
            if (i < txtLength - patLength) {
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + patLength)) % Q;
                if (txtHash < 0) {
                    txt += Q;
                }
            }
        }
        return -1;
    }
}

```

### BM（Boyer-Moore）算法

​	BM 算法核心思想是，利用模式串本身的特点，在模式串中某个字符与主串不能匹配的时候，**将模式串往后多滑动几位，以此来减少不必要的字符比较，提高匹配的效率**。BM 算法构建的规则有两类，坏字符规则和好后缀规则。好后缀规则可以独立于坏字符规则使用。因为坏字符规则的实现比较耗内存，为了节省内存，我们可以只用好后缀规则来实现 BM 算法。

