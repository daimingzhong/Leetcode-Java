package leetcode_algorithm.class4_BinaryTree;

/*
Note:

Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

*/


import leetcode_algorithm.class0.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode_116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while(level_start!=null){
            TreeLinkNode cur = level_start;
            while(cur != null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }

    public void connect2(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
