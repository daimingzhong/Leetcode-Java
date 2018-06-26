package leetcode_algorithm.class6_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dai on 2016/10/18.
 */
public class AllPermutationsII {
    public List<String> permutationII(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array,0,result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result){
        //结束条件，所有array[]都加进去了
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<Character>();
        for(int i =index; i<=array.length-1; i++) {
            if(used.add(array[i])) {
                swap(array, i ,index);
                helper(array, index+1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        String st = "abb";
        AllPermutationsII per = new AllPermutationsII();
        System.out.println(per.permutationII(st));
        System.out.println((1.21 - 1.11) == 0.1);
    }
}
