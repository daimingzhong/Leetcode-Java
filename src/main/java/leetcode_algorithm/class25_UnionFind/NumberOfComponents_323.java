package leetcode_algorithm.class25_UnionFind;

/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 有环也算一个。


     1
    / \
   2  3

 n = 3 new int[]{{1, 2}, {1, 3}}

      1
     /
    2   3
 n = 3 new int[]{{1, 2}}

 不就是点 - 边的个数吗？？ 结果 >= 点 - 边
 如果有环状软，那么就要少减一次。如果有多个环。so 检测环的个数？是不行的。

 0  -- 5     4
 |     |     |
 1 --- 2     3

 最多有6个结果
 如果是一条新的边，就减少一个结果
 如果组成了一个环，就不减少结果。相当于这个边没有用。（组成环的最后一条边没用）
 */


public class NumberOfComponents_323 {

    // 有n个点
    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }
        for (int[] pair : edges) {
            int x = find(roots, pair[0]);  // {0, 1}  0   {1, 2}  1   {3, 4} 3
            int y = find(roots, pair[1]);  // {0, 1}  1   {1, 2}  2   {3, 4} 4
            if (x != y) {  // i = 0, 1
                roots[x] = y;  // root[0] = 1  root[1] = 2 root[3] = 4
                res--; // res = 5 - 1
            }
        }
        return res;
    }

    // 这里是find了啥？
    private int find(int[] roots, int i) {  // i = 0
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }

    public static void main(String[] args) {
        NumberOfComponents_323 numberOfUndirectedGraph_323 = new NumberOfComponents_323();
//        int res = numberOfUndirectedGraph_323.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        int res = numberOfUndirectedGraph_323.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}});
        System.out.println(res);
    }
}
