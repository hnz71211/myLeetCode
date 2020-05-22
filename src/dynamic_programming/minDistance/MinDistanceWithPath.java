package dynamic_programming.minDistance;

/**
 * @ClassName: MinDistance
 * @Description: 编辑距离
 * @Author: hexli
 * @Date: 2020/5/22
 **/

/**
 *
 * choice
 *
 *    s2  ""   a   p   p   l   e
 * s1
 * ""     -1  -1  -1  -1  -1  -1
 *           \
 * r      -1   3   1   1   1   1
 *             |
 * a      -1   0   1   1   1   1
 *              \
 * d      -1  2   3 <- 1 <- 1 <- 1
 *
 */

public class MinDistanceWithPath {

  static void minDistance(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    // dp[i][j]含义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    Node[][] dp = new Node[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = new Node(0, -1);
      }
    }

    // base case
    for (int i = 0; i <= m; i++) {
      dp[i][0].val = i;
    }
    for (int j = 0; j <= n; j++) {
      dp[0][j].val = j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          // 相同字符
          dp[i][j].val = dp[i - 1][j - 1].val;
          dp[i][j].choice = 0;
        }else {
          if (dp[i - 1][j].val <= dp[i][j - 1].val && dp[i - 1][j].val <= dp[i - 1][j - 1].val) {
            dp[i][j].choice = 2;
          }else if (dp[i][j - 1].val <= dp[i - 1][j].val && dp[i][j - 1].val <= dp[i - 1][j - 1].val) {
            dp[i][j].choice = 1;
          }else if (dp[i - 1][j - 1].val <= dp[i - 1][j].val && dp[i - 1][j - 1].val <= dp[i][j - 1].val) {
            dp[i][j].choice = 3;
          }

          dp[i][j].val = min(dp[i - 1][j].val + 1,  // 删除操作，即删除s1第i位字符
                  dp[i][j - 1].val + 1, // 增加操作，即s1插入j指向字符
                  dp[i - 1][j - 1].val + 1);  // 替换操作，即i和j指向相同字符，替换s1第i位字符
        }
      }
    }

    int min = dp[m][n].val;
    System.out.println(min);

    // dp[m][n] 吗，这里的 val 存着最小编辑距离，choice 存着最后一个操作，
    // 插入左移一格； 删除上移一格；替换左上移一格；不做向上移一格
    // 重复此过程，可以一步步回到起点 dp[0][0]，形成一条路径，按这条路径上的操作进行编辑，就是最佳方案。
    Node node = dp[m][n];
    while (m + n > 0) {
      System.out.print(dp[m][n].choice + "->");
      if (dp[m][n].choice == 1) {
        n--;
      }else if (dp[m][n].choice == 2) {
        m--;
      }else if (dp[m][n].choice == 3) {
        m--;
        n--;
      }else if (dp[m][n].choice == 0) {
        m--;
      }
      node = dp[m][n];
    }
  }



  public static void main(String[] args) {
    String s1 = "rad";
    String s2 = "apple";
    minDistance(s1, s2);
  }

  static class Node {
    /**
     * val 属性就是之前的 dp 数组的数值
     */
    int val;

    /**
     * choice 属性代表操作。在做最优选择时，顺便把操作记录下来，然后就从结果反推具体操作。
     * 0 代表啥都不做
     * 1 代表插入
     * 2 代表删除
     * 3 代表替换
     */
    int choice;

    public Node(int val, int choice) {
      this.val = val;
      this.choice = choice;
    }
  }

  static int min(int i, int j, int k) {
    return Math.min(Math.min(i, j), k);
  }

}
