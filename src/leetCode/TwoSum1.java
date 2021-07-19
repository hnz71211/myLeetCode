package leetCode;

import java.util.HashMap;

/**
 * @ClassName: TwoSum1
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/19
 **/
public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> gap2index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (gap2index.containsKey(nums[i])) {
        return new int[]{i, gap2index.get(nums[i])};
      }
      gap2index.put(target - nums[i], i);
    }
    return null;
  }
}
