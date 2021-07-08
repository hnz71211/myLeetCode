package leetCode;

/**
 * @ClassName: MoveZeroes283
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/6
 **/
public class MoveZeroes283 {
  public void moveZeroes(int[] nums) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != 0) {
        nums[slow++] = nums[fast];
      }
    }
    while (slow < nums.length) {
      nums[slow] = 0;
    }
  }
}
