package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Subsets78
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/8
 **/
public class Subsets78 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {

    LinkedList<Integer> track = new LinkedList<>();

    backtrack(nums, 0, track);

    return res;
  }


  void backtrack(int[] nums, int start, LinkedList<Integer> track) {
    res.add(new LinkedList<>(track));

    for (int i = start; i < nums.length; i++) {

      track.add(nums[i]);
      backtrack(nums, i + 1, track);
      track.removeLast();

    }
  }

  public static void main(String[] args) {
    Subsets78 subsets78 = new Subsets78();
    int[] nums = new int[]{1, 2, 3};
    subsets78.subsets(nums);
    System.out.println();
  }

}
