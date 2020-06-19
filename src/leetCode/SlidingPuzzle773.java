package leetCode;

import java.util.*;

/**
 * @ClassName: SlidingPuzzle773
 * @Description: 滑动谜题
 * @Author: hexli
 * @Date: 2020/6/19
 **/
public class SlidingPuzzle773 {

  public int slidingPuzzle(int[][] board) {

    int m = 2, n = 3;
    String start = "";
    String target = "123450";
    // 初始状态-字符串表示
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        start += board[i][j];

    // 记录一堆字符串的相邻索引
    int[][] neighbor = new int[][]{
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
    };

    // BFS算法
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    List<String> visited = new ArrayList<>();
    visited.add(start);

    int step = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();

      for (int i = 0; i < sz; i++) {
        String cur = queue.poll();

        // 达到目标
        if (target.equals(cur))
          return step;

        // 0的索引
        int idx = 0;
        for (; cur.charAt(idx) != '0'; idx ++);

        // 0和相邻的数字交换位置
        for (int adj : neighbor[idx]) {
          StringBuilder new_board = new StringBuilder(cur);
          char temp = new_board.charAt(adj);
          new_board.setCharAt(adj, new_board.charAt(idx));
          new_board.setCharAt(idx, temp);

          String new_board_str = new_board.toString();
          if (!visited.contains(new_board_str)) {
            queue.offer(new_board_str);
            visited.add(new_board_str);
          }
        }
      }
      step++;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};

    SlidingPuzzle773 slidingPuzzle773 = new SlidingPuzzle773();
    int anw = slidingPuzzle773.slidingPuzzle(board);
    System.out.println(anw);
  }
}
