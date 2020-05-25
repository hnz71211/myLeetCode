package dynamic_programming.superEggDrop;


/**
 * @ClassName: SuperEggDrop
 * @Description: 高楼扔鸡蛋问题
 *
 * 题目是这样：你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。
 * 现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎）。
 * 现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？
 *
 * 如果只有一个鸡蛋（K = 1），只能线性扫描：先在 1 楼扔一下，没碎，再去 2 楼扔一下，没碎，再去 3 楼……
 * 如果有无穷个鸡蛋，最好的策略是使用二分查找思路
 *
 * @Author: hexli
 * @Date: 2020/5/25
 **/
public class SuperEggDrop {

  /**
   * @param K 鸡蛋个数
   * @param N 楼层数
   * @return
   */
  static int superEggDrop(int K, int N) {

    // 状态方程含义，状态为 K 个鸡蛋，面对 N 层楼, 返回这个状态下的最优结果
    int[][] dp = new int[K + 1][N + 1];

    // base case
    // 当鸡蛋数 K 为 1 时，显然只能线性扫描所有楼层
    for (int i = 0; i <= N; i++) {
      dp[1][i] = i;
    }
    // 当楼层数 N 等于 0 时，显然不需要扔鸡蛋；
    for (int i = 0; i <= K; i++) {
      dp[i][0] = 0;
    }

    // 外面两个for代表状态， i个鸡蛋，j层楼
    for (int i = 2; i <= K; i++) {
      for (int j = 1; j <= N; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        // 里面的for，只是在做一次「选择」
        // 比方说你有 2(i) 个鸡蛋，面对 10(j) 层楼，你这次选择去哪一层楼扔呢？不知道，那就把这 10 层楼全试一遍
        for (int k = 1; k <= j; k++) {
          // 要求的是最坏情况下扔鸡蛋的次数，所以鸡蛋在第 k 层楼碎没碎，取决于那种情况的结果更大
          int tmp = Math.max(
                  // 如果鸡蛋碎了，那么鸡蛋的个数 K 应该减一，搜索的楼层区间应该从 [1..j] 变为 [1..k-1] 共 k-1 层楼；
                  dp[i - 1][k - 1],
                  // 如果鸡蛋没碎，那么鸡蛋的个数 K 不变，搜索的楼层区间应该从 [1..j] 变为 [k+1..N] 共 j-k 层楼。
                  dp[i][j - k]
          ) + 1;
          dp[i][j] = Math.min(tmp, dp[i][j]);
        }
      }
    }

    return dp[K][N];
  }


  public static void main(String[] args) {
    int K = 2;
    int N = 100;
    System.out.println(superEggDrop(2, 100));
  }

}
