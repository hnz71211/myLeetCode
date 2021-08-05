package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: LevelOrder102
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/3
 **/
public class LevelOrder102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> resList = new ArrayList<>();

    if (root == null) {
      return resList;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> itemList = new ArrayList<>();
      int len = queue.size();
      while (len > 0) {
        TreeNode node = queue.poll();
        itemList.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        len --;
      }
      resList.add(itemList);
    }
    return resList;
  }
}
