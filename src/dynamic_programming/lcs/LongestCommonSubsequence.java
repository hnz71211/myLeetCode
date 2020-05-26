package dynamic_programming.lcs;

/**
 * @ClassName: LongestCommonSubsequence
 * @Description: 最长公共子序列
 *
 * 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 *
 * @Author: hexli
 * @Date: 2020/5/26
 **/
public class LongestCommonSubsequence {

  static int longestCommonSubsequence(String str1, String str2) {

    int n = str1.length();
    int m = str2.length();

    // dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]
    // base case: dp[0][..] = dp[..][0] = 0
    int[][] dp = new int[n + 1][m + 1];

    // 状态：s1 和 s2
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          // 如果 s1[i]==s2[j]，那么这个字符一定在 lcs 中, 并给 lcs 的长度加一
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }else {
          // 否则的话，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个
          dp[i][j] = Math.max(
                  dp[i - 1][j],
                  dp[i][j - 1]
          );
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    String str1 = "abcde";
    String str2 = "ace";
    System.out.println(longestCommonSubsequence(str1, str2));
  }

}
