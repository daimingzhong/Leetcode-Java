package leetcode_basic.class6_DFS;

import java.util.ArrayList;
import java.util.List;

/*
Set = "abc"
all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

                     0
                /       \
 a 0          a         0
           /   \     /   \
b  0     b    0    b    0
        / \  / \  / \  / \
c  0   c  0  c 0  c 0  c 0
      /   \
   null (length == set.length)


另一种写法：for
                     0
             a       b         c
         /  | |
        a  c  0
      / \  /
     c  0 b

其实就是，dfs打印每一条路径 终止条件：sb.append(set[index])
第一个输出abc，并不会走到c旁边的0，在c出返回到b，b执行过了c，执行0。
a执行过了b，在执行0，所以delete是为了清除左边的访问痕迹。
b访问c（本身是个函数，如果到c = 3,就结束函数，返回,删掉，再返回），访问0
*/

public class AllSubsetsI {
    private List<String> subSets(String set){
        List<String> result = new ArrayList<String>();
        if(set == null){
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder(); // 一直维护一个当前解。
        helper2(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result){
        if(index == set.length){
            result.add(sb.toString());
            return;
        }
        // 两个递归不能反着写 ，[abc, abc, abc, abc, abc, abc, abc, abc]，注意delete在加过的之后
        helper(set, sb.append(set[index]), index+1, result);
        sb.deleteCharAt(sb.length()-1);
        helper(set, sb, index+1, result);
        //sb.deleteCharAt(sb.length()-1);
    }

    // [, a, ab, abc, ac, b, bc, c]
    //  对已选择的字符，维护升序排列  选择下一个已选的index（最小的可被选的就是index）
    private void helper2(char[] set, StringBuilder sb, int index, List<String> result){
        result.add(sb.toString());
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helper2(set, sb, i+1, result);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args){
        String set = "abc";
        AllSubsetsI subSetObj = new AllSubsetsI();
        System.out.println(subSetObj.subSets(set));
    }
}
