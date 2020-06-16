package leetCode;

/**
 * @ClassName: MaxCoins312
 * @Description: 戳气球
 * @Author: hexli
 * @Date: 2020/6/16
 **/
public class MaxCoins312 {

  public int maxCoins(int[] nums) {

    int n = nums.length;

    // 两边加上虚拟气球
    int[] points = new int[n + 2];
    points[0] = points[n + 1] = 1;
    for (int i = 1; i <= n; i++)
      points[i] = nums[i - 1];

    // dp[i][j] = x 表示，戳破气球 i 和气球 j 之间（开区间，不包括 i 和 j）的所有气球，可以获得的最高分数为 x
    // base case 就是 dp[i][j] = 0，其中 0 <= i <= n+1, j <= i+1，因为这种情况下，开区间 (i, j) 中间根本没有气球可以戳
    int[][] dp = new int[n + 2][n + 2];

    // 状态：开区间(i, j)
    for (int i = n; i >= 0; i--) {
      for (int j = i + 1; j < n + 2; j++) {
        // 选择： 最后戳破的那个气球是 k，
        for (int k = i + 1; k < j; k++) {
          // 择优做选择，使得 dp[i][j] 最大
          dp[i][j] = Math.max(
                  dp[i][j], // 不戳k
                  dp[i][k] + dp[k][j] + points[i] * points[k] * points[j] // 戳k
          );
        }
      }
    }
    return dp[0][n + 1];
  }

}
