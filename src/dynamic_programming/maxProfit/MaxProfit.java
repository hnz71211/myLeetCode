package dynamic_programming.maxProfit;

/**
 * @ClassName: MaxProfit
 * @Description: 动态规划，股票买卖系列问题
 * @Author: hexli
 * @Date: 2020/5/29
 **/

/**
 * 思路：
 *    三个状态：dp[i][k][0 or 1]， i 天数   k交易次数   0/1 未持有/持有
 *    三个选择：买入、卖出、无操作
 *
 *
 * 状态方程：
 *    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *                 max(   选择 rest  ,             选择 sell      )
 *    解释：今天我没有持有股票，有两种可能：
 *    要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
 *    要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
 *
 *    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *                 max(   选择 rest  ,           选择 buy         )
 *    解释：今天我持有着股票，有两种可能：
 *    要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
 *    要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
 *
 * base case:
 *    dp[-1][k][0] = 0
 *    解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
 *    dp[-1][k][1] = -infinity
 *    解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
 *    dp[i][0][0] = 0
 *    解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
 *    dp[i][0][1] = -infinity
 *    解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
 */
public class MaxProfit {

  /**
   * 题目1： K=1
   * 现在 k 都是 1，不会改变，即 k 对状态转移已经没有影响了，可以去掉所有 k
   * @param prices
   * @return
   */
  static int maxProfit1(int[] prices) {

    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; i++) {
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
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
  }


  /**
   * 题目2： K= +infinity
   * 如果K为正无穷，可以认为K和K-1是一样的，也就是说不需要记录K这个状态了：
   *    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
   *    dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
   * @param prices
   * @return
   */
  static int maxProfit2(int[] prices) {

    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        // base case, 解释同上
        dp[i][0] = 0;
        dp[i][1] = -prices[i];
        continue;
      }
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }

    return dp[n - 1][0];
  }


  /**
   * 题目3： k = +infinity with cooldown, 每次 sell 之后要等一天才能继续交易
   * 状态转移方程：
   * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
   * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
   * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
   * @param prices
   * @return
   */
  static int maxProfit3(int[] prices) {

    int n = prices.length;

    if (n == 0)
      return 0;

    // 股票买卖次数K为无穷次, 可以认为K和K-1是一样的，也就是说不需要记录K这个状态了：
    // 状态：dp[i][0 or 1]， i 天数, 0/1 未持有/持有, 最大利润为dp[i][0 or 1]
    int[][] dp = new int[n][2];

    for (int i = 0; i < n; i++) {

      if (i == 0) {
        dp[0][0] = 0; // 第一天，不持有股票
        dp[0][1] = -prices[0]; // 第一天，持有股票
        continue;
      }
      if (i == 1) {
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]); // 第二天，不持有股票
        dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]); // 第二天，持有股票
        continue;
      }

      // 解释：今天我没有持有股票，有两种可能：
      // 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
      // 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

      // 解释：今天我持有着股票，有两种可能：
      // 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
      // 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    }

    return dp[n - 1][0];
  }


  /**
   * 题目4： k = +infinity with fee, 每次交易要支付手续费
   * 状态转移方程：
   * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
   * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
   * 解释：相当于买入股票的价格升高了。
   * 在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
   * @param prices
   * @return
   */
  static int maxProfit4(int[] prices, int fee) {

    int n = prices.length;
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


  /**
   * 题目5： K=2
   * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
   * @param prices
   * @return
   */
  static int maxProfit5(int[] prices) {

    int n = prices.length;
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
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
      }
    }

    return dp[n - 1][K][0];
  }


  /**
   * 题目6： K=any integer
   * 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity
   * @return
   */
  static int maxProfit6(int[] prices, int K) {
    int n = prices.length;
    if (K > n / 2) {
      return maxProfit2(prices);
    }

    int[][][] dp = new int[n][K + 1][2];
    for (int i = 0; i < n; i++) {
      for (int k = K; k >= 1; k--) {
        // base case:
        if (i == 0) {
          dp[i][k][0] = 0;
          dp[i][k][1] = -prices[i];
          continue;
        }
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
      }
    }

    return dp[n - 1][K][0];
  }


  public static void main(String[] args) {

    int[] prices = {3, 2, 6, 5, 0, 3};
    int fee = 1;
    int K = 4;

    System.out.println(maxProfit1(prices));
    System.out.println(maxProfit2(prices));
    System.out.println(maxProfit3(prices));
    System.out.println(maxProfit4(prices, fee));
    System.out.println(maxProfit5(prices));
    System.out.println(maxProfit6(prices, K));
  }
}
