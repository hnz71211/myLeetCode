package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: InvertTree226
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/5
 **/
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 依次交换每个节点的左右分支
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}
