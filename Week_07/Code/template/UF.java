package template;

/**
 * Union-Find 基本实现，没有优化
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

    /**
     * @param n 图的节点总数
     */
    public UF(int n) {
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 如果某两个节点被连通，则让其中的（任意）一个节点的根节点接到另一个节点的根节点上
     *
     * 将 p 和 q 连接
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 将两棵树合并为一棵
        parent[rootP] = rootQ;
        //parent[rootQ] = rootP 也一样

        // 两个分量合二为一
        count--;
    }

    /**
     *  返回某个节点 x 的根节点
     */
    private int find(int x) {
        // 根节点的 parent[x] == x
        while (parent[x] != x){
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
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    /**
     * 返回当前的连通分量个数
     */
    public int count(){
        return count;
    }
}
