package leetCode;

/**
 * @ClassName: IsAnagram242
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/18
 **/
public class IsAnagram242 {
  public boolean isAnagram(String s, String t) {
    int[] record = new int[26];

    for (Character c : s.toCharArray()) {
      record[c - 'a'] += 1;
    }
    for (Character c : t.toCharArray()) {
      record[c - 'a'] -= 1;
    }

    for (int i = 0; i < record.length; i++) {
      if (record[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
