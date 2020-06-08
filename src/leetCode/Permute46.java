package leetCode;

import backtrack.Permute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Permute46
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/5
 **/
public class Permute46 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {

    LinkedList<Integer> track = new LinkedList<>();

    backtrack(nums, new boolean[nums.length], track);

    return res;
  }

  void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> track) {
    if (track.size() == nums.length) {
      res.add(new LinkedList(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i] == true) continue;
      // 选择
      track.add(nums[i]);
      visited[i] = true;
      // 决策
      backtrack(nums, visited, track);
      // 取消选择
      track.removeLast();
      visited[i] = false;

    }
  }

  public static void main(String[] args) {
    Permute46 permute46 = new Permute46();

    int[] nums = new int[]{1, 2, 3};

    permute46.permute(nums).stream().forEach(item -> {
      item.stream().forEach(i -> System.out.print(i));
      System.out.println();
    });

  }

}
