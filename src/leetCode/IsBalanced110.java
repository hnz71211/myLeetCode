package leetCode;

/**
 * @ClassName: IsBalanced110
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/6
 **/
public class IsBalanced110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    // 返回以该节点为根节点的二叉树的高度，如果不是二叉平衡树了则返回-1
    private int getDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = getDepth(node.left);
        if (leftDepth == -1) return -1; // 左子树不是二叉平衡树
        int rightDepth = getDepth(node.right);
        if (rightDepth == -1) return -1; // 右子树不是二叉平衡树

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
