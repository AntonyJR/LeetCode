package hard.besttimetobuyandsellstockiv;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        if (k >= prices.length / 2) {
            int sum = 0, prev = prices[0];
            for (int p : prices) {
                sum += Math.max(0, p - prev);
                prev = p;
            }
            return sum;
        }
        int[] profits = new int[prices.length];
        for (int j = 0; j < k; j ++ ) {
            // max profit with one pending sell
            int localMax = -prices[0];
            // max profit with max j - 1 transactions and max i - 1 prices
            int p = 0;
            for (int i = 1; i < prices.length; i ++) {
                int temp = profits[i];
                profits[i] = Math.max(/* max profit with j transactions and i - 1 prices */profits[i - 1], prices[i] + localMax);
                localMax = Math.max(localMax, p - prices[i]);
                p = temp;
            }
        }
        return profits[profits.length - 1];
    }
}
