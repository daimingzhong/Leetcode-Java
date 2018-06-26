package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

/**
 *   5

 /    \

 3        8

 /   \

 1      4

 and

 5

 /    \

 8        3

 /   \

 1     4

 the two binary trees are tweaked identical.
 */
public class IsTweaked {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left))
                || (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right));
    }
}
