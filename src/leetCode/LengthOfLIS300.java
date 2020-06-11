package leetCode;

import java.util.Arrays;

/**
 * @ClassName: LengthOfLIS300
 * @Description: 最长增长子序列
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class LengthOfLIS300 {

  public int lengthOfLIS(int[] nums) {

    int n = nums.length;

    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    int[] dp = new int[n];
    // base case:
    Arrays.fill(dp, 1);

    // 选择： 索引i与j
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        // 状态：新增位比前一位大
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(
                  dp[i],
                  dp[j] + 1
          );
        }
      }
    }

    int anw = 0;
    for (int i = 0; i < dp.length; i++) {
      anw = Math.max(anw, dp[i]);
    }

    return anw;
  }

}
