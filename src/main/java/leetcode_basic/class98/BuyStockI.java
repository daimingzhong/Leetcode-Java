package leetcode_basic.class98;

/**
 * Created by Dai on 2017/1/2.
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
 */
public class BuyStockI {
    public int maxProfit(int[] array) {
        int small = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= small) {
                small = array[i];
                profit = Math.max(array[i] - small, profit);
            }
            else {
                profit = Math.max(array[i] - small, profit);
                // 肉眼debug的重点之一：
                // if else 判断。else时候的操作。
            }
        }
        return profit;
    }

    public static void main (String[] args) {
        BuyStockI bs = new BuyStockI();
        int result = bs.maxProfit( new int[]{2,7,1,5});
        System.out.print(result);
    }
}
