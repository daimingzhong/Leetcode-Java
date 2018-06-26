package leetcode_basic.class0;

/**
 * Created by Dai on 2016/10/22.
 */

/*
1. what you expect from your lchild/rchild  从子孙得到什么
是否包含a或者b，如果包含a和b，返回。如果只包含a，
2. what do you want to do in the current layer.  现在干什么
3. what do you want to report to your parent ?    报告什么
*/

/*
           6
         / \
        4   7
      /  \
     1   5
*/

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}
