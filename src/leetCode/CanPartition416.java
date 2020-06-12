package leetCode;

/**
 * @ClassName: CanPartition416
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/12
 **/
public class CanPartition416 {

  public boolean canPartition(int[] nums) {

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0)
      return false;
    sum = sum / 2;

    int n = nums.length;

    // dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
    boolean[][] dp = new boolean[n + 1][sum + 1];

    // base case
    // dp[i][0] 背包没有空间，相当于装满了
    // dp[0][i] 而当没有物品可选择的时候，肯定没办法装满背包
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j < nums[i - 1]) {
          // 装不下
          dp[i][j] = dp[i - 1][j];
        }else {
          // 装入或不装入背包
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[n][sum];

  }

}
