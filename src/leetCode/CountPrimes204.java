package leetCode;

import java.util.Arrays;

/**
 * @ClassName: CountPrimes204
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/19
 **/
public class CountPrimes204 {

  public int countPrimes(int n) {
    boolean[] isPrim = new boolean[n];
    Arrays.fill(isPrim, true);

    // 遍历[2,sqrt(n)]就可以
    for (int i = 2; i * i < n; i++)
      if (isPrim[i])
        // 若i是素数，则从i^2开始(避免重复计算)，n*j都不是素数
        for (int j = i * i; j < n; j += i)
          isPrim[j] = false;

    int count = 0;
    for (int i = 2; i < n; i++)
      if (isPrim[i]) count++;

    return count;
  }

}
