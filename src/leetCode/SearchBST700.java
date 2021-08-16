package leetCode;

/**
 * @ClassName: SearchBST700
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/16
 **/
public class SearchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (root.val < val) return searchBST(root.right, val);
        if (root.val > val) return searchBST(root.left, val);

        return null;
    }
}
