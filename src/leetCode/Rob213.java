package leetCode;

/**
 * @ClassName: Rob213
 * @Description: 打家劫舍II
 * @Author: hexli
 * @Date: 2020/6/17
 **/
public class Rob213 {

  public int rob(int[] nums) {
    int n = nums.length;

    if (n == 1) {
      return nums[0];
    }

    // 取两种情况的更大值
    return Math.max(robRange(nums, 0, n - 2), // 抢第一间不抢最后一间
            robRange(nums, 1, n - 1)  // 不抢第一间，抢最后一间
    );
  }

  // 仅计算闭区间 [start,end] 的最优结果
  int robRange(int[] nums, int start, int end) {

    int dp_i_1 = 0, dp_i_2 = 0;
    int dp_i = 0;
    for (int i = end; i >= start; i--) {
      dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
      dp_i_2 = dp_i_1;
      dp_i_1 = dp_i;
    }
    return dp_i;
  }

}
