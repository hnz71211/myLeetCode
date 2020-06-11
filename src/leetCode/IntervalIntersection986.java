package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: IntervalIntersection986
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class IntervalIntersection986 {

  public int[][] intervalIntersection(int[][] A, int[][] B) {

    List<int[]> res = new ArrayList<>();

    int i = 0, j = 0;

    while (i < A.length && j < B.length) {
      int a1 = A[i][0];
      int a2 = A[i][1];
      int b1 = B[j][0];
      int b2 = B[j][1];

      // 两个区间存在交集
      if (b2 >= a1 && a2 >= b1) {
        int[] ist = new int[2];
        ist[0] = Math.max(a1, b1);
        ist[1] = Math.min(a2, b2);
        res.add(ist);
      }

      if (b2 < a2)
        j ++;
      else
        i ++;
    }

    return res.toArray(new int[res.size()][]);
  }

  public static void main(String[] args) {

    int[][] A = new int[][]{{0,2}, {5,10}, {13,23}, {24,25}};
    int[][] B = new int[][]{{1,5}, {8,12}, {15,24}, {25,26}};

    IntervalIntersection986 intervalIntersection986 = new IntervalIntersection986();
    int res[][] = intervalIntersection986.intervalIntersection(A, B);
    System.out.println(res);
  }

}
