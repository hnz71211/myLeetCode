package leetCode;

/**
 * @ClassName: MaxSubArray53
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class MaxSubArray53 {

  public int maxSubArray(int[] nums) {

    int n = nums.length;
    if (n == 0)
      return 0;

    // dp[i]=x含义：前i个元素的最大子序列和为x
    int[] dp = new int[n];
    // base case: 第一个元素前面没有子数组
    dp[0] = nums[0];

    // 选择：前i个
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }

    int anw = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > anw)
        anw = dp[i];
    }
    return anw;
  }

}
