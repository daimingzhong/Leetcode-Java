package leetcode_basic.class24_PracticeIV;

import java.util.*;

/**
 * Created by Dai on 2016/12/2.
 */
public class TwoSumAllPairsII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // 因为这里要用iterator，所以用Integer xx
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            List<Integer> key = hashMap.get(target - array[i]);
            if (!hashMap.containsKey(array[i])) { // 没有存过这个值
                if (key != null) { // 有target - array[i]
                        result.add(Arrays.asList(target - array[i], array[i])); // 两个数 变成 List 的方法
                    }
                }
                else if (array[i] + array[i] == target && !flag) {
                    result.add(Arrays.asList(array[i],array[i]));
                    flag = true;
                }
                hashMap.put(array[i], new ArrayList<Integer>());
                hashMap.get(array[i]).add(i); // 存在过的值就不用加了
            }
        return result;
    }
    public static void main (String[] args) {
        TwoSumAllPairsII ts = new TwoSumAllPairsII();
        int[] array = {3, 5, 3, 2, 4, 5, 5, 4, 3, 4, 4};
        System.out.println(ts.allPairs(array,8));
    }
}
