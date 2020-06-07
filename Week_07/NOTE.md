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



## 高级树（AVL树和红黑树）



