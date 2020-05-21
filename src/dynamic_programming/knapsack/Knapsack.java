package dynamic_programming.knapsack;

/**
 * @ClassName: Knapsack
 * @Description:
 *
 * 给定一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * @Author: hexli
 * @Date: 2020/5/21
 **/
public class Knapsack {


  /**
   * 0-1背包
   * @param W 背包可装载重量为 W
   * @param N 总共有N个物品
   * @param wt 重量数组，其中第 i 个物品的重量为 wt[i]
   * @param val 价值数组，其中第 i 个物品的价值为 val[i]
   * @return 返回最大价值
   */
  /**
   * dp[i][w] =
   *    0 0 0 0 0
   *    0 0 4 4 4
   *    0 2 4 6 6
   *    0 2 4 6 6
   */
  static int knapsack(int W, int N, int[] wt, int[] val) {

    /**
     * dp[i][w] 的定义: 对于前 i 个物品，当前背包容量为 w，这种情况下可以装的最大价值是 dp[i][w]。
     * d[0][w] = d[i][0] = 0
     * 注意：dp中第i个物品分别对应wt和val中的i-1的值
     */
    int[][] dp = new int[N + 1][W + 1];

    for (int i = 1; i <= N; i++) {
      for (int w = 1; w <= W; w++) {
        // 背包重量小于当前物品重量，当前i在wt中是i-1
        if (w < wt[i - 1]) {
          dp[i][w] = dp[i - 1][w];
        }else {
          // 不装入：dp[i][w] = dp[i-1][w]
          // 装入时：dp[i][w] = dp[i-1][w - wt[i]] + val[i]
          // 当前i在wt和val中是i-1
          dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
        }
      }
    }
    return dp[N][W];
  }

  public static void main(String[] args) {
    int W = 4;
    int N = 3;
    int[] wt = {2, 1, 3};
    int[] val = {4, 2, 3};
    System.out.println(knapsack(4, 3, wt, val));
  }

}
