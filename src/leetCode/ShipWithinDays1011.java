package leetCode;

/**
 * @ClassName: ShipWithinDays1011
 * @Description: 在D天内送达包裹的能力
 * @Author: hexli
 * @Date: 2020/6/22
 **/
public class ShipWithinDays1011 {

  public int shipWithinDays(int[] weights, int D) {
    // 载重可能的最小值
    int left = getMax(weights);
    // 载重可能的最大值 + 1
    int right = getSum(weights) + 1;
    // 二分查找
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (canFinish(weights, D, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  // 返回最大包裹
  int getMax(int[] weights) {
    int max = 0;
    for (int w : weights)
      max = Math.max(w, max);
    return max;
  }

  // 总重量
  int getSum(int[] weights) {
    int sum = 0;
    for (int w : weights)
      sum += w;
    return sum;
  }

  // 如果载重为 cap，是否能在 D 天内运完货物？
  boolean canFinish(int[] w, int D, int cap) {
    int i = 0;
    for (int day = 0; day < D; day++) {
      int maxCap = cap;
      while ((maxCap -= w[i]) >= 0) {
        i++;
        if (i == w.length)
          return true;
      }
    }
    return false;
  }

}
