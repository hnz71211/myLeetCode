package leetCode;

/**
 * @ClassName: Rob198
 * @Description: 打家劫舍I
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class Rob198 {

  public int rob(int[] nums) {

    int n = nums.length;

    // dp[i] = x 表示：
    // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
    // base case: dp[n] = 0
    //    int[] dp = new int[n + 2];
    //
    //    for (int i = n - 1; i >= 0; i--) {
    //      dp[i] = Math.max(
    //              dp[i + 1],  // 不抢第i间
    //              dp[i + 2] + nums[i]   // 抢第i间
    //      );
    //    }
    //    return dp[0];

    // 实际上，状态转移只和 dp[i] 最近的两个状态有关，所以可以进一步优化，将空间复杂度降低到 O(1)
    int dp_i_1 = 0;
    int dp_i_2 = 0;
    int dp_i = 0;
    for (int i = n - 1; i >= 0; i--) {
      dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
      dp_i_2 = dp_i_1;
      dp_i_1 = dp_i;
    }
    return dp_i;
  }

}
