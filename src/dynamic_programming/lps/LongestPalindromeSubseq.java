package dynamic_programming.lps;

/**
 * @ClassName: LongestPalindromeSubseq
 * @Description: 最长回文子序列
 *
 * 给定字符串s，找出最长子序列
 * 例1：bbbab 输出：4（bbbb）
 * 例2: cbbd  输出：2（bb)
 * 例3：bxaby  输出：3（bab)
 *
 * @Author: hexli
 * @Date: 2020/5/26
 **/
public class LongestPalindromeSubseq {

  static int longestPalindromeSubseq(String str) {

    int n = str.length();

    // dp[i][j]含义： 在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
    int[][] dp = new int[n][n];

    // base case: 一个字符，最长回文序列长度为1
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    // 想求 dp[i][j] 需要知道 dp[i+1][j-1]，dp[i+1][j]，dp[i][j-1] 这三个位置
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (str.charAt(i) == str.charAt(j)) {
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

  public static void main(String[] args) {
    String str = "bbbab";
    System.out.println(longestPalindromeSubseq(str));
  }

}
