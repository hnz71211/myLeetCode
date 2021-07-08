package leetCode;

/**
 * @ClassName: BackspaceCompare844
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/8
 **/
public class BackspaceCompare844 {
  public static boolean backspaceCompare(String s, String t) {
    int slow_s = 0, slow_t = 0;

    char[] arrs = s.toCharArray();
    char[] arrt = t.toCharArray();

    for (int fast = 0; fast < arrs.length; fast++) {
      if (s.charAt(fast) == '#') {
        slow_s = slow_s == 0 ? 0 : slow_s - 1;
      }else {
        arrs[slow_s++] = arrs[fast];
      }
    }

    for (int fast = 0; fast < arrt.length; fast++) {
      if (t.charAt(fast) == '#') {
        slow_t = slow_t == 0 ? 0 : slow_t - 1;
      }else {
        arrt[slow_t++] = arrt[fast];
      }
    }

    if (slow_s == slow_t) {
      for (int i = 0; i < slow_s; i++) {
        if (arrs[i] != arrt[i]) {
          return false;
        }
      }
    }else {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "#c#";
    String t = "#";
    System.out.println(backspaceCompare(s, t));
  }
}
