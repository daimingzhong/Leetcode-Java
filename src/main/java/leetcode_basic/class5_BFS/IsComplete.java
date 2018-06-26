package leetcode_basic.class5_BFS;

import leetcode_basic.class0.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dai on 2016/11/30.
       5
     / \
    3   8
  /  \
 1    4
 is completed.  without 1, not complete
 答案左右分开比较，逻辑比较简单，一共三中。
 1. == null flag == true，不让再加了
 2. != null flag == true, 错了
 3. ！= null flag ！= true 加上。
 对左右没有区分。但实际上先执行左，再执行右，就有区分了。
 这里bfs和dfs的区别是，用了queue，先弹出，再执行。
 */

public class IsComplete {
    public boolean isCompleted (TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果flag == true，就不再加点。
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // poll 是queue里的，先进先出，remove and return
            TreeNode cur = queue.poll();
            // 只要左侧到达过null，就不能再加了。或者右边空了，也不能加了
            if (cur.left == null) {
                flag = true;
            }
            // 这里简写了，一定是cur.left != null && flag == true
            else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            }
            else if(flag) {
                return false;
            }
            else {
                queue.offer(cur.right);
            }
        } // return 是用来结束一次函数调用的。所以这里只提前return false
        return true;
    }

    public boolean isCompleted2 (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        if (root == null) {
            return true;
        }
        while (!queue.isEmpty()) {
            root = queue.poll(); // 必须删一次节点，不然死循环了
           if (root.left == null && root.right == null) {
               flag = true;
               // 根节点不但不能返回true，反而要判断为不能再加了
               //  return true; 不能有返回true的句子 到了根节点就拉倒
           }
            if (root.left != null && root.right != null) {
                if (flag == false) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                    //return true;
                }
                else
                    return false;
            }
            if (root.left != null && root.right == null) {
                if (flag == false) {
                    queue.offer(root.left);
                    flag = true; // no more insertion illegal
                    //return true;
                }
                else
                    return false;
            }
            if (root.left == null && root.right != null) {
                return false;
            }
        }
        return true;
    }

        public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        IsComplete is = new IsComplete();
        System.out.println(is.isCompleted2(t1));
    }
}
