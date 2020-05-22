package dynamic_programming.minDistance;

/**
 * @ClassName: MinDistance
 * @Description: 编辑距离
 * @Author: hexli
 * @Date: 2020/5/22
 **/

public class MinDistance {

  static int minDistance(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    // dp[i][j]含义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    int[][] dp = new int[m + 1][n + 1];

    // base case
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          // 相同字符
          dp[i][j] = dp[i - 1][j - 1];
        }else {
          dp[i][j] = min(dp[i - 1][j] + 1,  // 删除操作，即删除s1第i位字符
                  dp[i][j - 1] + 1, // 增加操作，即s1插入j指向字符
                  dp[i - 1][j - 1] + 1);  // 替换操作，即i和j指向相同字符，替换s1第i位字符
        }
      }
    }

    return dp[m][n];
  }

  static int min(int i, int j, int k) {
    return Math.min(Math.min(i, j), k);
  }

  public static void main(String[] args) {
    String s1 = "rad";
    String s2 = "apple";
    System.out.println(minDistance(s1, s2));
  }

}
