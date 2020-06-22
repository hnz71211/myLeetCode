package leetCode;

/**
 * @ClassName: SuperPow372
 * @Description: 超级次方
 * @Author: hexli
 * @Date: 2020/6/22
 **/
public class SuperPow372 {

  public int superPow(int a, int[] b) {

    int n = b.length;
    if (n == 0)
      return 1;

    // 关于模运算的技巧，避免a*b导致溢出，模运算在算法中比较常见：
    // (a * b) % k = (a % k)(b % k) % k
    int base = 1337;

    int last = b[n - 1];
    int[] desc = new int[n - 1];
    System.arraycopy(b, 0, desc, 0, n - 1);

    // 递归次方运算
    int part1 = pow(a, last);
    int part2 = pow(superPow(a, desc), 10);

    return (part1 * part2) % base;
  }

  // 次方运算技巧：k分奇偶数
  public int pow(int a, int k) {

    int base = 1337;

    if (k == 0)
      return 1;

    a %= base;

    if (k % 2 == 1) {
      return a * pow(a, k - 1) % base;
    }else {
      int sub = pow(a, k / 2);
      return sub * sub % base;
    }

  }

  public static void main(String[] args) {
    int a = 2;
    int[] b = new int[]{1, 0};

    SuperPow372 superPow372 = new SuperPow372();
    int anw = superPow372.superPow(a, b);
    System.out.println(anw);
  }

}
