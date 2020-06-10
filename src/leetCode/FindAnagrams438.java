package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FindAnagrams438
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/10
 **/
public class FindAnagrams438 {

  public List<Integer> findAnagrams(String s, String p) {

    int left = 0, right = 0;
    List<Integer> res = new ArrayList<>();

    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> needs = new HashMap<>();
    for (char i = 0; i < p.length(); i++) {
      needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
    }

    int match = 0;

    while (right < s.length()) {
      char c_r = s.charAt(right);
      right ++;
      if (needs.get(c_r) != null) {
        window.put(c_r, window.getOrDefault(c_r, 0) + 1);
        if (window.get(c_r).equals(needs.get(c_r))) {
          match ++;
        }
      }

      while (right - left >= p.length()) {
        if (match == needs.size()) {
          res.add(left);
        }
        char c_l = s.charAt(left);
        left ++;
        if (needs.get(c_l) != null) {
          if (window.get(c_l).equals(needs.get(c_l))) {
            match --;
          }
          window.put(c_l, window.get(c_l) - 1);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    String s = "cbaebabacd";
    String p = "abc";
    FindAnagrams438 findAnagrams438 = new FindAnagrams438();
    List<Integer> res = findAnagrams438.findAnagrams(s, p);
    System.out.println(res);
  }

}
