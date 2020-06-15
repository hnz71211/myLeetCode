package leetCode;

/**
 * @ClassName: CoinChange322
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/15
 **/
public class CoinChange322 {

  public int coinChange(int[] coins, int amount) {

    // dp[i] 含义：当目标金额为i时， 至少需要dp[i]枚硬币
    int[] dp = new int[amount + 1];
    //base case: dp[0] = 0, dp[i] = amount + 1
    for (int i = 1; i <= amount; i++) {
      dp[i] = amount + 1;
    }

    for (int i = 0; i <= amount; i++) {
      for (int coin : coins) {
        if (i < coin)
          continue;
        dp[i] = Math.min(
                dp[i],  // 不包含这枚硬币
                1 + dp[i - coin]  // 包含这枚硬币
        );
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amount = 11;

    CoinChange322 coinChange322 = new CoinChange322();
    int anw = coinChange322.coinChange(coins, 11);
    System.out.println(anw);
  }
}
