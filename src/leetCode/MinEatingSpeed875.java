package leetCode;

/**
 * @ClassName: MinEatingSpeed875
 * @Description: 爱吃香蕉的珂珂
 * @Author: hexli
 * @Date: 2020/6/22
 **/
public class MinEatingSpeed875 {

  public int minEatingSpeed(int[] piles, int H) {

//    int max = getMax(piles);  // piles 数组的最大值
//    for (int speed = 1; speed < max; speed++) {
//      // 以 speed 是否能在 H 小时内吃完香蕉
//      if (canFinish(piles, speed, H))
//        return speed;
//    }
//    return max;

    // 以上暴力求解过程可以改为二分查找
    // 套用搜索左侧边界的算法框架
    int left = 1, right = getMax(piles) + 1;
    while (left < right) {
      // 防止溢出
      int mid = left + (right - left) / 2;
      if (canFinish(piles, mid, H)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  // 返回最大堆
  int getMax(int[] piles) {
    int max = 0;
    for (int n : piles)
      max = Math.max(n, max);
    return max;
  }

  // 以 speed 是否能在 H 小时内吃完香蕉，时间复杂度 O(N)
  boolean canFinish(int[] piles, int speed, int H) {
    int time = 0;
    for (int n : piles) {
      time += timeOf(n, speed);
    }
    return time <= H;
  }

  // 返回几个小时能吃完n个香蕉
  int timeOf(int n, int speed) {
    return (n / speed) + ((n % speed > 0) ? 1 : 0);
  }

}
