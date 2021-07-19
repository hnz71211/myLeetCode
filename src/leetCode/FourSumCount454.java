package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: FourSumCount454
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/20
 **/
public class FourSumCount454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    int temp;
    int res = 0;

    for (int i : nums1) {
      for (int j : nums2) {
        temp = i + j;
        int count = map.getOrDefault(temp, 0);
        map.put(temp, count + 1);
      }
    }

    for (int i : nums3) {
      for (int j : nums4) {
        temp = i + j;
        res += map.getOrDefault(0 - temp, 0);
      }
    }
    return res;
  }
}
