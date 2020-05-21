package dynamic_programming.change;

/**
 * @ClassName: Change
 * @Description: 完全背包问题
 *    有一个背包，最大容量为 amount，有一系列物品 coins，每个物品的重量为 coins[i]，每个物品的数量无限
 *    请问有多少种方法，能够把背包恰好装满？
 * @Author: hexli
 * @Date: 2020/5/21
 **/
public class Change {

  static int change(int amount, int[] coins) {

    // dp[i][j] 的定义： 若只使用前 i 个物品，当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
    // 换句话说： 若只使用 coins 中的前 i 种硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法。
    int[][] dp = new int[coins.length + 1][amount + 1];

    // base case 为 dp[0][..] = 0， dp[..][0] = 1
    // 因为如果不使用任何硬币面值，就无法凑出任何金额；如果凑出的目标金额为 0，那么不选择任何硬币就是唯一的一种凑法。
    for (int i = 0; i <= coins.length; i ++) {
      dp[i][0] = 1;
    }

    // dp中的i对应coins[i - 1]面值
    for (int i = 1; i <= coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j < coins[i - 1]) {
          // 总额小于面值
          dp[i][j] = dp[i - 1][j];
        }else {
          // 如果不把这第 i 个物品装入背包，也就是说你不使用 coins[i] 这个面值的硬币，那么凑出面额 j 的方法数 dp[i][j] 应该等于 dp[i-1][j]，继承之前的结果
          // 如果你把这第 i 个物品装入了背包，也就是说你使用 coins[i] 这个面值的硬币，那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]]。
          // 综上就是两种选择，而我们想求的 dp[i][j] 是「共有多少种凑法」，所以 dp[i][j] 的值应该是以上两种选择的结果之和
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // 首先由于 i 是从 1 开始的，所以 coins 的索引是 i-1 时表示第 i 个硬币的面值。
        }
      }
    }

    return dp[coins.length][amount];
  }

  /**
   * 通过观察可以发现，dp 数组的转移只和 dp[i][..] 和 dp[i-1][..] 有关，所以可以压缩状态，进一步降低算法的空间复杂度：
   */
  static int change2(int amount, int[] coins) {
    int n = coins.length;
    int[] dp = new int[amount + 1];
    dp[0] = 1; // base case
    for (int i = 0; i < n; i++)
      for (int j = 1; j <= amount; j++)
        if (j >= coins[i])
          dp[j] = dp[j] + dp[j-coins[i]];
    return dp[amount];
  }


  public static void main(String[] args) {
    int amount = 5;
    int[] coins = {1, 2, 5};
    System.out.println(change(amount, coins));
  }

}
