package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Combine77
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/8
 **/
public class Combine77 {

  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {

    if (n <= 0 || k <= 0)
      return res;

    LinkedList<Integer> track = new LinkedList<>();

    backtrack(track, n, k, 1);

    return res;

  }

  private void backtrack(LinkedList<Integer> track, int n, int k, int start) {

    if (track.size() == k) {
      res.add(new LinkedList<>(track));
      return;
    }

    for (int i = start; i < n; i++) {
      track.add(i);
      backtrack(track, n, k, i + 1);
      track.removeLast();
    }

  }

}
