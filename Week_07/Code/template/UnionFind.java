package template;

/**
 * 并查集模板代码
 */
public class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
