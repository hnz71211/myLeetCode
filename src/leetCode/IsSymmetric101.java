package leetCode;

/**
 * @ClassName: IsSymmetric101
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/5
 **/
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return compare(root.left, root.right);
    }

    /**
     * 这里的左右，是指外层的左边右边，里层的左边右边
     * @param left
     * @param right
     * @return
     */
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
