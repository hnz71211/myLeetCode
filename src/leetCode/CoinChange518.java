package leetCode;

/**
 * @ClassName: CoinChange518
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/15
 **/
public class CoinChange518 {

  public int change(int amount, int[] coins) {

    int N = coins.length;

    // dp[i][j]含义：coins[i],目标金额为j，组合数是dp[i][j]
    int[][] dp = new int [N + 1][amount + 1];

    // base case: dp[0][..] = 0， dp[..][0] = 1
    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j >= coins[i - 1])
          dp[i][j] = dp[i - 1][j] // 放i前
                  +
                  dp[i][j - coins[i - 1]];  // 把i放入
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[N][amount];
  }

  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amount = 5;
    CoinChange518 coinChange518 = new CoinChange518();
    int anw = coinChange518.change(amount,coins);
    System.out.println(anw);
  }
}
