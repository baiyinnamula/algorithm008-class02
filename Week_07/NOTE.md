学习笔记

## 字典树

### 字典树的数据结构

字典树是一种树形结构，典型应用是用于统计或排序大量的字符串（但不仅限于字符串）。

优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

### 字典树的实现代码

```java
/**
 * 字典树模板
 */
class Trie {
    private boolean isEnd;
    private Trie[] next;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            int n = c - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            node = node.next[c - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
```

### 字典树的核心思想

字典树的核心思想是空间换时间。

字典树利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### 字典树的基本性质

1.节点本身不存完整单词。

2.从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。

3.每个节点的所有子节点路径代表的字符都不相同。

## 并查集

### 适用场景

- 组团、配对问题
- 判断是否属于每个组

### 基本操作

1. 初始化：把每个点所在的集合初始化为其自身。
2. 查找：查找元素所在的集合，即根节点。
3. 合并：将两个节点所在的集合合并为一个集合。

### 代码实现

```java
/**
 * Union-Find 优化版
 * Union-Find 算法的关键就在于union和connected函数的效率。
 * 那么用什么模型来表示这幅图的连通状态呢？用什么数据结构来实现代码呢？
 */
public class UF {
    /**
     * 记录连通分量
     */
    private int count;
    /**
     * 节点 x 的父节点是 parent[x]
     */
    private int[] parent;

    //新增一个数组记录每棵树包含的节点数
    private int[] size;

    /**
     * @param n 图的节点总数
     */
    public UF(int n) {
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];

        // 最初每棵树只有一个节点,重量应该初始化 1
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 如果某两个节点被连通，则让其中的（任意）一个节点的根节点接到另一个节点的根节点上
     * 将 p 和 q 连接
     * 平衡性优化
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 将两棵树合并为一棵
        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 返回某个节点 x 的根节点
     */
    private int find(int x) {
        // 根节点的 parent[x] == x
        while (parent[x] != x) {
            //进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 判断 p 和 q 是否连通
     * 如果节点 p 和 q 连通的话，它们一定拥有相同的根节点
     * 这里所说的「连通」是一种等价关系，也就是说具有如下三个性质：
     * 1、自反性：节点p和p是连通的。
     * 2、对称性：如果节点p和q连通，那么q和p也连通。
     * 3、传递性：如果节点p和q连通，q和r连通，那么p和r也连通。
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    /**
     * 返回当前的连通分量个数
     */
    public int count() {
        return count;
    }
}
```

代码实现时需要优化的地方，一个是路径压缩，另一个是合并节点集合是小树接到大树下面。

## 高级搜索

### 剪枝

​	剪枝顾名思义，就是删去一些不重要的节点，来减小计算或搜索的复杂度。剪枝在很多算法中都有很好的应用，如：决策树，神经网络，搜索算法,数据库的设计等。在决策树和神经网络中，剪枝可以有效缓解过拟合问题并减小计算复杂度；在搜索算法中，可以减小搜索范围，提高搜索效率。

### 双向 BFS

​	所谓双向搜索指的是搜索沿两个方向同时进行：正向搜索：从初始结点向目标结点方向搜索；逆向搜索：从目标结点向初始结点方向搜索；当两个方向的搜索生成同一子结点时终止此搜索过程。

#### 实现思路

1. 两个方向交替扩展。
2. 选择节点个数较少的那个方向先扩展。

### 启发式搜索（A*）

​	[启发式搜索](https://baike.baidu.com/item/启发式搜索/8944170)就是在[状态空间](https://baike.baidu.com/item/状态空间/5129038)中的搜索对每一个搜索的位置进行评估，得到最好的位置，再从这个位置进行搜索直到目标。这样可以省略大量无谓的搜索路径，提高了效率。在启发式搜索中，对位置的估价是十分重要的。采用了不同的估价可以有不同的效果。

## 高级树（AVL树和红黑树）

### 树的进化过程

树 -> 二叉树 ->二叉搜索树 ->自平衡二叉搜索树。

### AVL 树

​	**AVL树**是最早被发明的[自平衡二叉查找树](https://zh.wikipedia.org/wiki/自平衡二叉查找树)。在AVL树中，任一节点对应的两棵子树的最大高度差为1，因此它也被称为**高度平衡树**。查找、插入和删除在平均和最坏情况下的[时间复杂度](https://zh.wikipedia.org/wiki/时间复杂度)都是 ![O(\log{n})](https://wikimedia.org/api/rest_v1/media/math/render/svg/653ab6d6fd99537d220f179d2591955ff4f37b99)。增加和删除元素的操作则可能需要借由一次或多次[树旋转](https://zh.wikipedia.org/wiki/树旋转)，以实现树的重新平衡。

![](https://tva1.sinaimg.cn/large/007S8ZIlly1gfk6aelqefj30m80fq3zy.jpg)

AVL 树的缺点：节点需要存储额外信息，且调整次数频繁。

### 红黑树

​	红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)，它能够确保任何一 个结点的**左右子树的高度差小于两**倍。具体来说，红黑树是满足如下条件的二叉搜索树:

1. 每个结点要么是红色，要么是黑色

2. 根节点是黑色

   每个叶节点(NIL节点，空节点)是黑色的。

3. 不能有相邻接的两个红色节点

4. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。



### AVL 树和红黑树对比

| 树     | 查找操作 | 插入和删除操作 | 额外空间                                   | 应用场景    |
| ------ | -------- | -------------- | ------------------------------------------ | ----------- |
| AVL 树 | 较快     | 较慢           | 较多（每个节点存储平衡因子或树的高度）     | 数据库      |
| 红黑树 | 较慢     | 较快           | 较少（每个节点存储是否黑色或红色节点即可） | 语言库，API |

