package leetCode;

/**
 * @ClassName: ReverseString344
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/24
 **/
public class ReverseString344 {
  public void reverseString(char[] s) {
    int l = 0, r = s.length - 1;
    while (l < r) {
      s[l] ^= s[r];
      s[r] ^= s[l];
      s[l] ^= s[r];
      l ++;
      r ++;
    }
  }
}
