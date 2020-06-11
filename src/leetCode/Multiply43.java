package leetCode;

import java.util.List;

/**
 * @ClassName: Multiply43
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class Multiply43 {

  public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] res = new int[m + n]; // 结果最多为 m + n 位数

    // 逐位相乘
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        // 乘积在 res 对应的索引位置
        int p1 = i + j, p2 = i + j + 1;
        // 叠加到res上
        int sum = mul + res[p2];
        res[p2] = sum % 10;
        res[p1] += sum / 10;
      }
    }

    // 去前置零
    int i = 0;
    while (i < res.length && res[i] == 0)
      i++;
    StringBuffer sb = new StringBuffer();
    for (int j = i; j < res.length; j++) {
      sb.append(res[j]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

  public static void main(String[] args) {
    Multiply43 multiply43 = new Multiply43();
    System.out.println(multiply43.multiply("123", "456"));
  }

}
