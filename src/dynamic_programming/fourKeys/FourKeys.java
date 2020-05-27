package dynamic_programming.fourKeys;

/**
 * @ClassName: FourKeys
 * @Description: 4键键盘
 * @Author: hexli
 * @Date: 2020/5/27
 **/
public class FourKeys {

  static int maxA(int N) {

    // dp[i]含义：i 次操作后最多能显示多少个 A
    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      // 最后一次要么 选择按 A 键（就比上次多一个 A 而已）
      dp[i] = dp[i - 1] + 1;

      // 要么 选择按 黏贴键 (这时要考虑之前是在哪里 C-A C-C 的)
      // 最优的操作序列一定是 C-A C-C 接着若干 C-V, 用一个变量 j 作为若干 C-V 的起点, 那么 j 之前的 2 个操作就应该是 C-A C-C
      for (int j = 2; j < i; j++) {
        // 全选 + 复制 dp[j-2]，连续粘贴 i - j 次, 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
        dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
      }
    }

    return dp[N];
  }

  public static void main(String[] args) {
    System.out.println(maxA(7));
  }

}
