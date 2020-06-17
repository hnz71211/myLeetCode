package leetCode;

/**
 * @ClassName: MaxProfit123
 * @Description: 股票买卖的最佳时机III
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class MaxProfit123 {

  public int maxProfit(int[] prices) {
    int n = prices.length;

    if (n == 0)
      return 0;

    // dp[i][k][0 or 1]， i 天数, k交易次数, 0/1 未持有/持有, 最大利润为dp[i][k][0 or 1]
    int K = 2;
    int[][][] dp = new int[n][K + 1][2];

    for (int i = 0; i < n; i++) {
      for (int k = K; k >= 1; k--) {
        // base case:
        if (i == 0) {
          dp[i][k][0] = 0;
          dp[i][k][1] = -prices[i];
          continue;
        }
        // 解释：今天我没有持有股票，有两种可能：
        // 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
        // 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

        // 解释：今天我持有着股票，有两种可能：
        // 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
        // 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
      }
    }
    return dp[n - 1][K][0];
  }


  public static void main(String[] args) {

    int[] prices = {1, 2, 3, 4, 5};
    int K = 2;

    MaxProfit123 maxProfit123 = new MaxProfit123();
    int anw = maxProfit123.maxProfit(prices);
    System.out.println(anw);
  }

}
