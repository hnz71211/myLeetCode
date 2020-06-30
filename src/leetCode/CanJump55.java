package leetCode;

/**
 * @ClassName: CanJump55
 * @Description: 跳跃距离
 * @Author: hexli
 * @Date: 2020/6/30
 **/
public class CanJump55 {

  public boolean canJump(int[] nums) {

    int n = nums.length;
    int farthest = 0;

    for (int i = 0; i < n - 1; i++) {
      // 能跳到的最远距离 距离开始：i+nums[i]
      farthest = Math.max(farthest, i + nums[i]);
      if (farthest <= i)
        return false;
    }

    return farthest >= n - 1;

  }

}
