package dynamic_programming.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: EraseOverlapIntervals
 * @Description: 贪心算法
 * @Author: hexli
 * @Date: 2020/5/29
 **/
public class EraseOverlapIntervals {

  /**
   * 算出最多几个不相交区间
   * @param intvs
   * @return
   */
  public static int intervalSchedule(int[][] intvs) {
    if (intvs.length == 0) {
      return 0;
    }
    // 按end升序排序
    Arrays.sort(intvs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    // 至少有1个区间不相交
    int count = 1;
    int x_end = intvs[0][1];
    for (int[] interval : intvs) {
      int start = interval[0];
      if (start >= x_end) {
        // 找到下一个区间
        count ++;
        x_end = interval[1];
      }
    }
    return count;
  }

  public static void main(String[] args) {

    int[][] intvs = {{1,2}, {2, 3}, {3, 4}, {1, 3}};

    int n = intvs.length;

    int res = n - intervalSchedule(intvs);

    System.out.println(res);
  }

}
