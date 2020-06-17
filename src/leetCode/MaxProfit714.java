package leetCode;

/**
 * @ClassName: MaxProfit714
 * @Description: 买卖股票的最佳时机-含手续费
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class MaxProfit714 {

  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;

    if (n == 0)
      return 0;

    int[][] dp = new int[n][2];

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        // base case
        dp[i][0] = 0;
        dp[i][1] = -prices[i] - fee;
        continue;
      }
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
    }

    return dp[n - 1][0];
  }

}
