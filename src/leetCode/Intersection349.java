package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Intersection349
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/18
 **/
public class Intersection349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return new int[0];
    }

    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (Integer num : nums1) {
      set1.add(num);
    }

    for (Integer num : nums2) {
      if (set1.contains(num)) {
        set2.add(num);
      }
    }
    int[] res = new int[set2.size()];
    int i = 0;
    for (int num : set2) {
      res[i++] = num;
    }
    return res;
  }
}
