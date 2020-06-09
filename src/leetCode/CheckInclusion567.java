package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CheckInclusion567
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class CheckInclusion567 {

  public boolean checkInclusion(String s1, String s2) {

    int left = 0, right = 0;

    //  window 记录当前「窗口」中包含的字符及出现的次数
    Map<Character, Integer> window = new HashMap<>();
    // needs 记录 s1 中字符出现次数
    Map<Character, Integer> needs = new HashMap<>();
    for (char c : s1.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    // 匹配的字符个数
    int match = 0;

    // 窗口向右移动，并记录字符出现的次数，直到滑到最右边
    while (right < s2.length()) {
      char c_r = s2.charAt(right);
      right ++;
      if (needs.get(c_r) != null) {
        window.put(c_r, window.getOrDefault(c_r, 0) + 1);
        if (window.get(c_r).equals(needs.get(c_r))) {
          match ++;
        }
      }

      // 判断左侧窗口是否要收缩
      while (right - left >= s1.length()) {
        if (match == needs.size()) {
          return true;
        }
        char c_l = s2.charAt(left);
        left ++;
        if (needs.get(c_l) != null) {
          if (window.get(c_l).equals(needs.get(c_l))) {
            match --;
          }
          window.put(c_l, window.get(c_l) - 1);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s1 = "ab";
    String s2 = "eidbaooo";
    CheckInclusion567 checkInclusion567 = new CheckInclusion567();
    System.out.println(checkInclusion567.checkInclusion(s1, s2));
  }

}
