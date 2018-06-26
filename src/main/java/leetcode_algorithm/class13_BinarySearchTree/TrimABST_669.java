package leetcode_algorithm.class13_BinarySearchTree;

/*
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L).
You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

修剪一个bst，使得返回的树在左右区间内。

Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1

分析：

问题：对一棵树，删掉不满足L R 区间的节点
子问题：对每一额节点，删掉不满足L R区间的孩子。


当前层，返回当前层满足L R的节点

打印顺序：中 左 右。

对于中，遇到null 返回
对于左，解决子问题

子问题的返回值是当前点的左右节点。

扩展：delete a node in bst

https://www.youtube.com/watch?v=L_t2x3nH61k
有三种情况：
1. 根结点在L R之间
   root.left = trim(root.left)

2. 根结点 > R
   root = trim(root.left)

3. 根结点 < R
   root = trim(root.right)

return root.
 */

import leetcode_algorithm.class0.TreeNode;

public class TrimABST_669 {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }
            // 三种情况
            if (root.val > R) {  // 如果当前点大于 R，那么只用处理左边，右边都抛弃了。
                return trimBST(root.left, L, R);
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }
            else {
                // 当前点的左节点 是 左节点 子问题的解 ？？
                root.left = trimBST(root.left, L, R);
                root.right = trimBST(root.right, L, R);
            }
            return root;
        }
}
