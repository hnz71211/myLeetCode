package leetCode;

/**
 * @ClassName: LongestPalindromeSubseq516
 * @Description: 最长回文子序列
 * @Author: hexli
 * @Date: 2020/6/16
 **/
public class LongestPalindromeSubseq516 {

  public int longestPalindromeSubseq(String s) {
    int n = s.length();

    // dp[i][j]含义： 在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
    int[][] dp = new int[n][n];

    // base case: 一个字符，最长回文序列长度为1
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    // 想求 dp[i][j] 需要知道 dp[i+1][j-1]，dp[i+1][j]，dp[i][j-1] 这三个位置
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          // str[i]和str[j]一定在最长回文子序列中
          dp[i][j] = dp[i + 1][j - 1] + 2;
        }else {
          // 选择str[i+1..j] 和 str[i..j-1] 更长的回文子序列
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][n - 1];
  }

}
