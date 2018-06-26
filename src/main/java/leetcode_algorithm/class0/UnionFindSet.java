package leetcode_algorithm.class0;

/*
disjoint-set 
http://zxi.mytechroad.com/blog/data-structure/sp1-union-find-set/

例子：
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

边上的点是从1开始的。所以用 n + 1. 0 本身是不会被用到的

 */

public class UnionFindSet {
    private int[] parents;
    private int[] ranks;

    public UnionFindSet(int n) {
        parents = new int[n + 1];
        ranks = new int[n + 1];
        for (int i = 0; i < parents.length; ++i) {  // 初始化 parent是自己
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    // u, v 已经在一个集合了，返回false
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;

        // rank低的做parent。
        if (ranks[pv] > ranks[pu])
            parents[pu] = pv;
        else if (ranks[pu] > ranks[pv])
            parents[pv] = pu;
        else {
            parents[pv] = pu;
            ranks[pu] += 1;
        }
        return true;
    }

    public int find(int u) {
        while (parents[u] != u) {
            // 指定parent[u] 就已经进行优化了。也可以不写。or parent[u] = find[u.parent];
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }
}