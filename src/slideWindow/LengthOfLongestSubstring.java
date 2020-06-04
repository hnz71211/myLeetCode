package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LengthOfLongestSubstring
 * @Description: 无重复字符的最长子串
 * @Author: hexli
 * @Date: 2020/6/4
 **/
public class LengthOfLongestSubstring {

  int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0;
    Map<Character, Integer> window = new HashMap<>();
    int res = 0; // 记录最长长度

    while (right < s.length()) {
      char c_r = s.charAt(right);
      window.put(c_r, window.getOrDefault(c_r, 0) + 1);
      right ++;

      while (window.get(c_r) > 1) {
        char c_l = s.charAt(left);
        window.put(c_l, window.get(c_l) - 1);
        left ++;
      }

      res = Math.max(res, right - left);
    }

    return res;
  }



}
