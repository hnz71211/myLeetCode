package leetCode;

import java.util.*;

/**
 * @ClassName: PermuteUnique47
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/5
 **/
public class PermuteUnique47 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {

    LinkedList<Integer> track = new LinkedList<>();

    Arrays.sort(nums);

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

      // 如果当前节点与他的前一个节点一样，并且前一个节点已经被遍历过了，那我们也就不需要了。
      // 例如【1,1,2,3,4,5】，当你找到所有以第一个点为头结点的排列的时候，那再到第二个的时候，发现它和之前的那个节点是一样的。就不用找了，因为都已经找完了，不然就重复了
      if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])
        break;

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
    PermuteUnique47 permuteUnique47 = new PermuteUnique47();

    int[] nums = new int[]{3, 1, 3, 1};

    permuteUnique47.permuteUnique(nums).stream().forEach(item -> {
      item.stream().forEach(i -> System.out.print(i));
      System.out.println();
    });

  }

}
