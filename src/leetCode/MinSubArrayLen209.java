package leetCode;

/**
 * @ClassName: MinSubArrayLen209
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/9
 **/
public class MinSubArrayLen209 {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int result = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
      sum = sum + nums[right];
      while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left];
        left ++;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
