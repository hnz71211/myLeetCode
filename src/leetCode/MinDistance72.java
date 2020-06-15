package leetCode;

/**
 * @ClassName: MinDistance72
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/15
 **/
public class MinDistance72 {

  public int minDistance(String word1, String word2) {

    int m = word1.length();
    int n = word2.length();

    // dp含义： s1[0..i]和s2[0..j]的最小编辑距离为dp[i][j]
    int[][] dp = new int[m + 1][n + 1];

    // base case:
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1))
          // 相同字符
          dp[i][j] = dp[i - 1][j - 1];
        else
          dp[i][j] = min(
                  dp[i - 1][j] + 1, // 删除操作，即删除word1第i位字母
                  dp[i][j - 1] + 1, // 增加操作，即word1中增加j指向的字母
                  dp[i - 1][j - 1] + 1  // 替换操作，即i指向word1的字母替换j指向word2中字母
          );
      }
    }

    return dp[m][n];
  }

  static int min(int i, int j, int k) {
    return Math.min(Math.min(i, j), k);
  }

  public static void main(String[] args) {
    String word1 = "horse", word2 = "ros";
    MinDistance72 minDistance72 = new MinDistance72();
    int anw = minDistance72.minDistance(word1, word2);
    System.out.println(anw);
  }
}
