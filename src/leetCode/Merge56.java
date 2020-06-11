package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Merge56
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class Merge56 {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0)
      return new int[][]{};

    // 按区间的start升序排列
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

    List<int[]> res = new ArrayList<>();

    res.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] curr = intervals[i];

      // 结果中最后一个区间
      int[] last = res.get(res.size() - 1);

      // 比较区间结尾是否落在结果区间中
      if (curr[0] <= last[1]) {
        last[1] = Math.max(last[1], curr[1]);
      }else {
        res.add(curr);
      }
    }

    return res.toArray(new int[res.size()][]);
  }

  public static void main(String[] args) {

    int[][] intervals = new int[][]{};

    Merge56 merge56 = new Merge56();

    int[][] res = merge56.merge(intervals);
    System.out.println(res);
  }

}
