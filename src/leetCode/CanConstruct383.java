package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CanConstruct383
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/24
 **/
public class CanConstruct383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] arr = new int[26];

    for (Character ch : magazine.toCharArray()) {
      arr[ch - 'a'] ++;
    }

    for (Character ch : ransomNote.toCharArray()) {
      int idx = ch - 'a';
      if (arr[idx] > 0) {
        arr[idx] --;
      }else {
        return false;
      }
    }
    return true;
  }
}
