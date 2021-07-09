package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TotalFruit904
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/9
 **/
public class TotalFruit904 {
  public int totalFruit(int[] fruits) {
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int right = 0; right < fruits.length; right++) {
      map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
      while (map.size() > 2) {
        map.put(fruits[left], map.get(fruits[left]) - 1);
        if (map.get(fruits[left]) == 0) {
          map.remove(fruits[left]);
        }
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}
