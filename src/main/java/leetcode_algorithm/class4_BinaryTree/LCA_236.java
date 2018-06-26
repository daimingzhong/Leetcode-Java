package leetcode_algorithm.class4_BinaryTree;

/*

236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two
given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w
as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”

                    _______3______
                   /              \
                ___5__          ___1__
               /      \        /      \
               6      _2       0       8
                     /  \
                     7   4
6, 4


For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
Another example is LCA of nodes 5 and 4 is 5,
since a node can be a descendant of itself according to the LCA definition.

for current node.
1.
find two in child, return the cur.
2.
find one in child, for current node, return the child. meaning the current node contains that child.
3.
did not find anything
return null.

                        1

                   2        3


              null  4

Way of thinking
1. what do we expect from l/r child?
usually, it is the return type recursion function.

left subtree's height & right subtree's height.

total number of nodes in my left subtree(1)
total number of nodes in my right subtree(2)

2. what do we want to do in the current layer?
maxHeight = max(left, right)

2.1 calculate the difference between (1) and (2)
2.2 if(diff > global_diff_max)

3. we do we want to report to parent (same as q1 == q3)
return maxHeight + 1

return 1 + (1) + (2)


Three steps:
1. we need the current node, and result node for deciding.
2. compare
3. return
case1: left & right both null, return null
case2: only one side is not null, return that one
case3: both not null, return that one.

这个题可以做个扩展：
如何在链表里，找到并返回一个node，用递归写。
也是一样，1. 写返回条件，找到了，或者是null，都返回root。 2. 把root.next传进去
3. 返回当前找到的结果。ListNode node = findNode(node.next, p); if(node!=null) {return node};
和树唯一不同的是，最后的返回值，

 */

import leetcode_algorithm.class0.TreeNode;

public class LCA_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);  // need two elements for deciding.
        if(left != null && right != null) {
            return root;
        }
        return left != null? left:right;
    }
}
