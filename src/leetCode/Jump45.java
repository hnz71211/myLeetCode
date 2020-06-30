package leetCode;

/**
 * @ClassName: Jump45
 * @Description: 跳跃游戏II
 * @Author: hexli
 * @Date: 2020/6/30
 **/
public class Jump45 {

  public int jump(int[] nums) {

    int n = nums.length;
    int end = 0;
    int farthest = 0;
    int jumps = 0;

    for (int i = 0; i < n - 1; i++) {
      // 能跳到的最远距离
      farthest = Math.max(farthest, i + nums[i]);
      // 最优选择
      // i 和 end 标记了可以选择的跳跃步数，farthest 标记了所有选择 [i..end] 中能够跳到的最远距离，jumps 记录了跳跃次数
      if (end == i) {
        jumps ++;
        end = farthest;
      }
    }

    return jumps;

  }

}
