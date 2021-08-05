package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: MaxDepth104
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/5
 **/
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth ++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }
}
