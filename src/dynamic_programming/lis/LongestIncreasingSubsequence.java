package dynamic_programming.lis;

import java.util.Arrays;

/**
 * @ClassName: LongestIncreasingSubsequence
 * @Description:
 * @Author: hexli
 * @Date: 2020/5/20
 **/
public class LongestIncreasingSubsequence {

  public static int lengthOfLIS(int[] nums) {

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          // 假设 dp[0...i-1] 都已知，想办法求出 dp[i]
          dp[i] = Math.max(dp[i], dp[j] + 1);
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
