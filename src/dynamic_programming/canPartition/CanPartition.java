package dynamic_programming.canPartition;

/**
 * @ClassName: CanPartition
 * @Description: 子集背包问题
 * @Author: hexli
 * @Date: 2020/5/21
 **/
public class CanPartition {

  /**
   * 输入一个集合，返回是否能够分割成和相等的两个子集
   * @param nums
   * @return
   */
  /**
   * 先对集合求和，得出 sum，把问题转化为背包问题：
   * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。现在让你装物品，是否存在一种装法，能够恰好将背包装满？
   */
  static boolean canPartition(int[] nums) {

    // 计算背包容量
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      // 和为奇数一定不能分成相等的两组
      return false;
    }
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
          dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
        }
      }
    }

    return dp[n][sum];
  }

  /**
   * 注意到 dp[i][j] 都是通过上一行 dp[i-1][..] 转移过来的，之前的数据都不会再使用了。
   * 所以，我们可以进行状态压缩，将二维 dp 数组压缩为一维，节约空间复杂度
   */
  static boolean canPartition2(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    int n = nums.length;

    boolean[] dp = new boolean[sum + 1];
    // base case
    dp[0] = true;

    for (int i = 0; i < n; i++) {
      for (int j = sum; j >= 0; j--) {
        if (j >= nums[i]) {
          dp[j] = dp[j] || dp[j - nums[i]];
        }
      }
    }

    return dp[sum];
  }


  public static void main(String[] args) {
    int[] nums = {1, 5, 5, 11};
    System.out.println(canPartition(nums));
    System.out.println(canPartition2(nums));
  }

}
