package leetCode;

/**
 * @ClassName: MaxProfit121
 * @Description: 买卖股票的最佳时机
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class MaxProfit121 {

  public int maxProfit(int[] prices) {
    int n = prices.length;

    if (n == 0)
      return 0;

    // 状态：dp[i][0 or 1]， i 天数, 0/1 未持有/持有, 最大利润为dp[i][0 or 1]
    int[][] dp = new int[n][2];

    for (int i = 0; i < n; i++) {
      // i=0时特殊处理
      if (i == 0) {
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
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
  }

  public static void main(String[] args) {

    int[] prices = {3, 2, 6, 5, 0, 3};
    int fee = 1;
    int K = 4;
    prices = new int[0];

    MaxProfit121 maxProfit121 = new MaxProfit121();
    int anw = maxProfit121.maxProfit(prices);
    System.out.println(anw);
  }

}
