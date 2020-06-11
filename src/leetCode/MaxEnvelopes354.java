package leetCode;

import java.util.Arrays;

/**
 * @ClassName: MaxEnvelopes354
 * @Description:
 *    解法：
 *      先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。
 *      之后把所有的 h 作为一个数组，在这个数组上计算 LIS(最长递增子序列 ) 的长度就是答案。
 *
 *      对于宽度 w 相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class MaxEnvelopes354 {

  public int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
    // 按宽度升序排列，如果宽度一样，则按高度降序排列
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    // 对高度数组寻找 LIS
    int[] height = new int[n];
    for (int i = 0; i < n; i++)
      height[i] = envelopes[i][1];

    return lengthOfLIS(height);
  }

  // 动态规划LIS
  int lengthOfLIS(int[] nums) {
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

    int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};

    MaxEnvelopes354 maxEnvelopes354 = new MaxEnvelopes354();
    System.out.println(maxEnvelopes354.maxEnvelopes(envelopes));
  }

}
