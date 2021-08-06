package leetCode;

/**
 * @ClassName: CountNodes222
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/6
 **/
public class CountNodes222 {
//    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // 如果左子树高度和右子树相等，说明左子树是完全二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // 如果不等，则右子树是完全二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth ++;
            node = node.left;
        }
        return depth;
    }
}
