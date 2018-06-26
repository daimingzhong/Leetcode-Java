package leetcode_basic.class16_Probability;

import static java.lang.Math.random;

/**
 * Created by Dai on 2016/11/9.
 *
 * 0  1  2  3  4
 * 5  6  7  8  9
 * 10
 * 15
 * 20 21 22 23 24
 * while (1 == 1){
 *     return 1; 会跳出循环吗 会的
 * }
 * Min + (int)(Math.random() * ((Max - Min) + 1))
 */
class RandomFive {
    public static int random5() {
        return (int)(random() * ((4) + 1));
    }
}
