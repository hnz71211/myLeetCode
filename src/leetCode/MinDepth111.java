package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: MinDepth111
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/6
 **/
public class MinDepth111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
            }
        }
        return depth;
    }
}
