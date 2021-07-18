package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: IsHappy202
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/18
 **/
public class IsHappy202 {
  public boolean isHappy(int n) {
    Set<Integer> history = new HashSet<>();
    while (n != 1 && !history.contains(n)) {
      history.add(n);
      n = opt(n);
    }
    return n == 1;
  }

  private int opt(int n) {
    int res = 0;
    while (n > 0) {
      int temp = n % 10;
      res += temp * temp;
      n = n / 10;
    }
    return res;
  }
}

