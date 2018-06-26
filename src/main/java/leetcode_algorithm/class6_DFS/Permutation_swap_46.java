package leetcode_algorithm.class6_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dai on 2016/12/1.
 Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

                            a (交换a为a)                b（交换a为b）         c
                          /    \                       /         \
                    b（交换b为b） c（交换b为c）       a（交换a为a） c（交换a为c）
                      /           \                  /              \
                c （交换c为c）     b（交换b为b）    c                    a


 // 对于第k层节点来说，就是交换固定了前面 k-1 位，然后分别 swap(k,k), swap(k, k+1) , swap(k, k+2) ...
 // 例如上图中的第三层，固定了第一位（即2），然后分别交换第1，1位，1，2位，1，3位
 对于三层中的每个点，1层3种可能，2层2种，3层1种。

 */

public class Permutation_swap_46 {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        helper(set.toCharArray(), 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }


    public List<String> permutations2(String set) {
        char[] input = set.toCharArray();// 不能写成character[]
        Set<Character> hashSet = new HashSet<>();
        StringBuilder cur = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (Character s : input) {
            sb.append(s);
        }
        helper2(input, 0, sb, cur, result);
        return result;
    }

    private void helper2(char[] input, int level, StringBuilder sb, StringBuilder cur, List<String> result) {
        if (level == input.length) {
            result.add(cur.toString());
            return;
        }
        for (int i = 0; i < sb.length(); i++) {
            cur.append(sb.charAt(i));
            sb.deleteCharAt(i);
            helper2(input, level + 1, sb, cur, result);
            cur = new StringBuilder();
//            cur.deleteCharAt(cur.length() - 1);
            sb.append(input[i]);
        }

    }



    public static void main(String[] args) {
        String st = "abc";
        Permutation_swap_46 per = new Permutation_swap_46();
        System.out.println(per.permutations(st));
    }
}

