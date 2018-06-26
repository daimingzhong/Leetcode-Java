package leetcode_algorithm.class12_DP;
/*

122. Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given
stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again)。


 */

public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        return total;
    }
}