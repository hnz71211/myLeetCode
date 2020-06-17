package leetCode;

/**
 * @ClassName: MaxProfit188
 * @Description: 买卖股票的最佳时机IV
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class MaxProfit188 {

  public int maxProfit(int k, int[] prices) {
    int n = prices.length;

    if (n == 0)
      return 0;

    // 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity
    if (k > n / 2) {
      return maxProfitKInf(prices);
    }

    // dp[i][j][0 or 1]， i 天数, j交易次数, 0/1 未持有/持有, 最大利润为dp[i][j][0 or 1]
    int[][][] dp = new int[n][k + 1][2];

    for (int i = 0; i < n; i++) {
      for (int j = k; j >= 1; j--) {
        // base case:
        if (i == 0) {
          dp[i][j][0] = 0;
          dp[i][j][1] = -prices[i];
          continue;
        }
        // 解释：今天我没有持有股票，有两种可能：
        // 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
        // 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

        // 解释：今天我持有着股票，有两种可能：
        // 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
        // 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
      }
    }
    return dp[n - 1][k][0];
  }

  public int maxProfitKInf(int[] prices) {
    int n = prices.length;

    if (n == 0)
      return 0;

    // 股票买卖次数K为无穷次, 可以认为K和K-1是一样的，也就是说不需要记录K这个状态了：
    // 状态：dp[i][0 or 1]， i 天数, 0/1 未持有/持有, 最大利润为dp[i][0 or 1]
    int[][] dp = new int[n][2];

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        // base case:
        dp[i][0] = 0;
        // 解释：
        //   dp[i][0]
        // = max(dp[-1][0], dp[-1][1] + prices[i])
        // = max(0, -infinity + prices[i]) = 0
        dp[i][1] = -prices[i];
        //解释：
        //   dp[i][1]
        // = max(dp[-1][1], dp[-1][0] - prices[i])
        // = max(-infinity, 0 - prices[i])
        // = -prices[i]
        continue;
      }

      // 解释：今天我没有持有股票，有两种可能：
      // 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
      // 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

      // 解释：今天我持有着股票，有两种可能：
      // 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
      // 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }

    return dp[n - 1][0];
  }

}
