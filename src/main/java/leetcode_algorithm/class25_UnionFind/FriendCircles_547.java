package leetcode_algorithm.class25_UnionFind;

import leetcode_algorithm.class0.UnionFindSet;

import java.util.HashSet;
import java.util.Set;

/*
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

朋友之间是可以传递的。第一，第二个人是朋友。第三个人自己是朋友。所以返回2组。

[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

可以从0开始算，也可以从1开始算。只要注意union 和 find用一样的区间size就可以。

 */
public class FriendCircles_547 {

    public int findCircleNum(int[][] M) {
        UnionFindSet unionFindSet = new UnionFindSet(M.length);
        for(int[] cur : M) {
            for(int i = 0; i < cur.length; i++) {
                for (int j = 0; j < cur.length; j++) {
                    if (i < j && cur[i] == 1 && cur[j] == 1) {
                        unionFindSet.union(i+1, j+1);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; i <= M.length; i++) {
            if (set.add(unionFindSet.find(i))) {
                count++;
            }
        }
        return count;
    }
}
