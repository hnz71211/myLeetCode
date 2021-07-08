package leetCode;

/**
 * @ClassName: RemoveElement27
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/6
 **/
public class RemoveElement27 {
  public int removeElement(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (val != nums[fast]) {
        nums[slow++] = nums[fast];
      }
    }
    return slow;
  }
}
