package leetcode_basic.class98;

/**
 * Created by Dai on 2017/1/2.
 * 不限购买次数，求最大利润
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
 *
 新来一个数，只有两种情况，比当前的数大，比当前的数小。
 1. 比当前的数大，记入当前的利润。
 2. 比当前的数小，不计入当前的利润。

 对于一个上升子序列，比如：5，1，2，3，4，0 中的1，2，3，4序列来说，对于两种操作方案：
 一，在1买入，4卖出；
 二，在1买入，2卖出同时买入，3卖出同时买入，4卖出；
 这两种操作下，收益是一样的。
 所以算法就是：从头到尾扫描prices，
 如果i比i-1大，那么price[i] – price[i-1]就可以计入最后的收益中。
 这样扫描一次O(n)就可以获得最大收益了。


 */
public class BuyStockII {
    public int maxProfit(int[] array){
        int[] result = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + array[i] - array[i-1];
            }
            else {
                result[i] = result[i - 1];
            }
        }
        return result[array.length - 1];
    }
    public static void main (String[] args) {
        BuyStockII bs = new BuyStockII();
        int result = bs.maxProfit(new int[]{1,2,6,4});
        System.out.print(result);
    }
}