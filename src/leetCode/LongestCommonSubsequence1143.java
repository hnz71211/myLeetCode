package leetCode;

/**
 * @ClassName: LongestCommonSubsequence1143
 * @Description: 最长公共子序列
 * @Author: hexli
 * @Date: 2020/6/16
 **/
public class LongestCommonSubsequence1143 {

  public int longestCommonSubsequence(String text1, String text2) {

    int m = text1.length();
    int n = text2.length();

    // dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]
    // base case: dp[0][..] = dp[..][0] = 0
    int[][] dp = new int[m + 1][n + 1];

    // 状态：s1 和 s2
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          // 如果 s1[i]==s2[j]，那么这个字符一定在 lcs 中, 并给 lcs 的长度加一
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          // 否则的话，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个
          dp[i][j] = Math.max(
                  dp[i - 1][j],
                  dp[i][j - 1]
          );
      }
    }

    return dp[m][n];
  }

}
