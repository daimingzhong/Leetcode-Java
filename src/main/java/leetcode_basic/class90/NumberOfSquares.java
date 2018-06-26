package leetcode_basic.class90;

/**
 * Created by Dai on 2017/1/4.
 4 can be split to  1+1+1+1 (4 items)   or  2^2 (1 item, which is the solution),  			  Return 1

 10 can be split to two items   3^2 + 1^2  (solution) or four items   2^2 + 2^2 + 1^2 +1^2
 Return 2

 */

// assumption: num is integer bigger than 0.
    // 这题的重点是写好下标，for的终止条件。
public class NumberOfSquares {
    public int squareNum (int num) {
        if (num <= 0) {
            return -1;
        }
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = i;
            for (int j = 1; j*j <= i; j++) {
                result[i] = Math.min(result[i], 1 + result[i - j*j]);
                //之前这个公式错了好几次，要重点检查。
            }
        }
        return result[num];
    }

    public int square (int num) {
        if (num <= 0) {
            return -1;
        }
        int[] result = new int[num + 1];
        result[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (isSquare(num)) {
                result[i] = 1;
            }
            else {
                for (int j = 1; j < i; j++){
                    result[i] = Math.min(result[i], result[j] + result[i - j]);
                }
            }
        }
        return result[num];
    }

    // binary search is faster than iteration
    private boolean isSquare(int num) {
        for (int i = 1; i < num/2; i++) {
            if (i * i == num) {
                return true;
                //break;
            }
        }
        return false;
    }


    // binaray seach. call it as isSeqare(num, 0, num)
    private boolean isSeqare (int num, int left, int right) {
        int mid = left + (right - left) / 2; // int the avoid of overflow
        while (left < right - 1) {
            if (mid * mid == num) {
                return true;
            }
            else  if (mid * mid < num){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (left * left == num) {
            return true;
        }
        if (right * right == num) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        NumberOfSquares ns = new NumberOfSquares();
        int result = ns.squareNum(12);
        System.out.print(result);
    }

}
