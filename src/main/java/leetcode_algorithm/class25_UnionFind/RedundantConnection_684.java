package leetcode_algorithm.class25_UnionFind;

/*

Return an edge that can be removed so that the resulting graph is a tree of N nodes.
If there are multiple answers, return the answer that occurs last in the given 2D-array.
The answer edge [u, v] should be in the same format, with u < v.

Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

删掉多余的一条边，使得是一棵树。如果有多种做法，就删掉最晚出现的那一组。

这个题，给的输入都是边。
 */

import leetcode_algorithm.class0.UnionFindSet;

public class RedundantConnection_684 {
    public int[] findRedundant (int[][] edges) {
        UnionFindSet unionFindSet = new UnionFindSet(edges.length);
        for (int[] edge : edges) {
            if(!unionFindSet.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}
