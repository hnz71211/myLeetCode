package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MinSubString
 * @Description: 最小覆盖子串
 *    给定一个字符串S和字符串T，在S中找出包含T所有字母的最小子串
 *    例如： s = ADOBECODEBANC, t = ABC
 *          输出 BANC
 *
 *
 *    解题模板：
 *      int left = 0, right = 0;
 *
 *      while (right < s.size()) {
 *        window.add(s[right]);
 *        right++;
 *
 *        while (valid) {
 *          window.remove(s[left]);
 *          left++;
 *        }
 *      }
 * @Author: hexli
 * @Date: 2020/6/4
 **/
public class MinSubString {

  String minWindow(String s, String t) {
    // 记录最短子串的开始位置和长度
    int start = 0, minLen = Integer.MAX_VALUE;
    int left = 0, right = 0;

    //  window 记录当前「窗口」中包含的字符及出现的次数
    Map<Character, Integer> window = new HashMap<>();
    // needs 记录 T 中字符出现次数
    Map<Character, Integer> needs = new HashMap<>();
    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    // 匹配的字符个数
    int match = 0;

    // 窗口向右移动，并记录字符出现的次数，直到滑到最右边
    while (right < s.length()) {
      char c_r = s.charAt(right);
      if (needs.get(c_r) != null) {
        window.put(c_r, window.getOrDefault(c_r, 0) + 1);
        // 同一字符出现次数相同时才算匹配
        if (window.get(c_r) == needs.get(c_r)) {
          match ++;
        }
      }
      right ++;

      // 窗口左边收缩，直到不符合包含条件，同时记录位置长度
      while (match == needs.size()) {
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }
        char c_l = s.charAt(left);
        if (needs.get(c_l) != null) {
          window.put(c_l, window.get(c_l) - 1);
          if (window.get(c_l) < needs.get(c_l)) {
            match --;
          }
        }
        left ++;
      }
    }

    return minLen == Integer.MAX_VALUE ?
            "" : s.substring(start, start + minLen);
  }

  public static void main(String[] args) {
    MinSubString mss = new MinSubString();
    System.out.println(mss.minWindow("ADOBECODEBADNCCA", "ABCC"));
  }

}