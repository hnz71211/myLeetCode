package leetCode;

/**
 * @ClassName: MySqrt69
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/6
 **/
public class MySqrt69 {
  public static int mySqrt(int x) {
    int left = 1, right = x / 2 + 1, ans = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (((long)mid * mid) <= x) {
        ans = mid;
        left = ans + 1;
      }else {
        right = mid - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    for (int i = 1; i < 120; i++) {
      System.out.println(i + ", " + mySqrt(i));
    }
    System.out.println(0 + ", " + mySqrt(0));
  }
}
