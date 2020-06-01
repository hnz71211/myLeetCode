package dynamic_programming.houseRobber;

/**
 * @ClassName: HouseRobber
 * @Description: 打家劫舍问题
 * @Author: hexli
 * @Date: 2020/6/1
 **/
public class HouseRobber {

  /**
   * 题型1
   * @param nums
   * @return
   */
  static int rob1(int[] nums) {

    int n = nums.length;
    // dp[i] = x 表示：
    // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
    // base case: dp[n] = 0
//    int[] dp = new int[n + 2];
//
//    for (int i = n - 1; i >= 0; i--) {
//      dp[i] = Math.max(
//              dp[i + 1],  // 不抢第i间
//              dp[i + 2] + nums[i]   // 抢第i间
//      );
//    }
//    return dp[0];

    // 实际上，状态转移只和 dp[i] 最近的两个状态有关，所以可以进一步优化，将空间复杂度降低到 O(1)
    int dp_i_1 = 0;
    int dp_i_2 = 0;
    int dp_i = 0;
    for (int i = n - 1; i >= 0; i--) {
      dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
      dp_i_2 = dp_i_1;
      dp_i_1 = dp_i;
    }
    return dp_i;

  }


  /**
   * 题型2: 这些房子不是一排，而是围成了一个圈
   * @param nums
   * @return
   */
  static int rob2(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    // 去两种情况的更大值
    return Math.max(robRange(nums, 0, n - 2), // 抢第一间不抢最后一间
            robRange(nums, 1, n - 1)  // 不抢第一间，抢最后一间
    );

  }
  // 仅计算闭区间 [start,end] 的最优结果
  static int robRange(int[] nums, int start, int end) {
    int n = nums.length;
    int dp_i_1 = 0, dp_i_2 = 0;
    int dp_i = 0;
    for (int i = end; i >= start; i--) {
      dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
      dp_i_2 = dp_i_1;
      dp_i_1 = dp_i;
    }
    return dp_i;
  }


  /**
   * 题型3: 房子不是一排，不是一圈，而是一棵二叉树！房子在二叉树的节点上，相连的两个房子不能同时被抢劫
   * @param root
   * @return
   */
  static int rob3(TreeNode root) {
    int[] res = dp3(root);
    return Math.max(res[0], res[1]);
  }
  /**
   * 返回一个大小为 2 的数组 arr
   * arr[0] 表示不抢 root 的话，得到的最大钱数
   * arr[1] 表示抢 root 的话，得到的最大钱数
   */
  static int[] dp3(TreeNode node) {
    if (node == null)
      return new int[]{0, 0};
    int[] left = dp3(node.left);
    int[] right = dp3(node.right);
    // 抢，下家就不能抢了
    int rob = node.val + left[0] + right[0];
    // 不抢，下家可抢可不抢，取决于收益大小
    int not_rob = Math.max(left[0], left[1])
            + Math.max(right[0], right[1]);

    return new int[]{not_rob, rob};
  }


  public static void main(String[] args) {

    int[] nums1 = {2, 7, 9, 3, 1};
    System.out.println(rob1(nums1));

    int[] nums2 = {2, 3, 2};
    System.out.println(rob2(nums2));

    TreeNode root = new TreeNode();
    root.val = 3;
    TreeNode node1 = new TreeNode();
    node1.val = 2;
    TreeNode node2 = new TreeNode();
    node2.val = 3;
    root.left = node1;
    root.right = node2;
    TreeNode node3 = new TreeNode();
    node3.val = 3;
    TreeNode node4 = new TreeNode();
    node4.val = 1;
    node1.right = node3;
    node2.right = node4;
    System.out.println(rob3(root));
  }
}
