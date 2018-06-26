package leetcode_basic.class2_BinarySearch;

/**
 * Created by Dai on 2016/11/22.
 * power(-2, 5) = -32
 * 3 3 / 3 3 3
 * 3      3
 * 1
 */

public class APowerB {
    public long aPowerB (int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long k = aPowerB (a, b/2);
            return k*k;
        }
        else {
            return a * aPowerB(a, (b-1));
        }
    }

    public long aPowerB2 (int a, int b) {
        if (b ==0) {
            return 1;
        }
        long half = aPowerB2 (a, b/2);
        return b%2 ==0 ? half*half : half*half*a;
        //如果5， 就是2 2 1 这样写是用既得结果表示另一种情况下的结果，而不是把另一种结果往前者靠
    }
    public static void main (String[] args) {
        APowerB ab = new APowerB();
        long result = ab.aPowerB(-2,5);
        System.out.print(result);
    }
}




