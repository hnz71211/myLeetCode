package dynamic_programming.lis;

import java.util.Arrays;

/**
 * @ClassName: LongestIncreasingSubsequence
 * @Description: 最长增长子序列
 *    dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
 * @Author: hexli
 * @Date: 2020/5/20
 **/
public class LongestIncreasingSubsequence {

  public static int lengthOfLIS(int[] nums) {

    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(
                  dp[i],
                  dp[j] + 1
          );
        }
      }
    }

    int res = 0;
    for (int i = 0; i < dp.length; i++) {
      res = Math.max(res, dp[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS(nums));
  }

}
