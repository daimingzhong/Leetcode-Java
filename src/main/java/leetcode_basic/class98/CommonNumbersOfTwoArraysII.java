package leetcode_basic.class98;


import java.util.*;

/**
 * Created by Dai on 2017/1/1.
   A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

 */
public class CommonNumbersOfTwoArraysII {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : A) {
            if (!map.containsKey(i)) {
                map.put(i,1);
            }
            else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer i : B) {
            if (map.containsKey(i)) {
                result.add(i);
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        CommonNumbersOfTwoArraysII cn = new CommonNumbersOfTwoArraysII();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        List<Integer> result = cn.common(a ,a);
        System.out.print(result);
    }
}
