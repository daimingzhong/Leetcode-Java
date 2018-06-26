package leetcode_basic.class11_Math;

/**
 * Created by Dai on 2016/12/1.
 * 5(“0101”) and 8(“1000”) has 3 different bits
 * 异或之后，1 1 0 1
 * 异或 ：
 * A OR B = a与(非b) + (非a)与b
 * 1 1 = 0
 * 0 0 = 0
 * 1 0 = 1
 * 0 1 = 1
 * 时间复杂度应该是log n 的。因为一个数会被表示成2进制数，
 * 二进制数的长度是原数大小的log n，原数长度的3-4倍。（3位表示一位）
 */
public class DifferentBits {
    public int diffBits(int a, int b) {
        //exclusive or 异或，只有a b 不同的位置为1.
        a = a ^ b;
        int count = 0;
        // >>> 逻辑右移
        while (a != 0) {
            count = count + (a & 1);
            //count +=  a & 1; 不是 count = count + a & 1；因为与的等级不比+高
            // 1 1 0 1 和 0 0 0 1 与， 结果是 0 0 0 1，下一步让1 1 0 1 右移。
            a = a >>> 1;
        }
        return count;
    }

    public static void main (String[] arg) {
        DifferentBits db = new DifferentBits();
        int result = db.diffBits(92, 1111);
        System.out.print(result);
    }
}
