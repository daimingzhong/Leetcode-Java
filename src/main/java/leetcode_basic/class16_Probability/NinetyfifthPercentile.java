package leetcode_basic.class16_Probability;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2016/11/12.
 * the longest length is 4096
 */
public class NinetyfifthPercentile {
    public int percentile95(List<Integer> lengths) {
        int[] count = new int[4097];
        System.out.println(lengths.size());
        // for (int len: lengths)
        for (int len = 0; len < lengths.size(); len++) {
             count[lengths.get(len)]++;
        }
        int sum = 0;
        int len = 4097;
        while (sum <=0.05 * lengths.size()) {
            sum = sum + count[ -- len];
        }
        return len;
    }
    public  static void main(String[] args) {
        NinetyfifthPercentile nf = new NinetyfifthPercentile();
        List list = new ArrayList<Integer>(){{
            add(10);
            add(12);
            add(22);
            add(9);
        }};
        // ArrayList list2 = new ArrayList(Arrays.asList(10,11,21));
        System.out.println(nf.percentile95(list));
        int a = 200;
        int c = 200;
        System.out.println(a == c);
    }
}

