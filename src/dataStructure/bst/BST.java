package dataStructure.bst;

/**
 * @ClassName: BST
 * @Description: 二叉搜索树
 * @Author: hexli
 * @Date: 2020/6/2
 **/
public class BST {

  /* 结点是否存在 */
  boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target)
      return true;
    if (root.val < target)
      return isInBST(root.right, target);
    if (root.val > target)
      return isInBST(root.left, target);
    return false;
  }

  /* 插入一个元素 */
  TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);
    // if (root.val == val)
    //     BST 中一般不会插入已存在元素
    if (root.val < val)
      root.right = insertIntoBST(root.right, val);
    if (root.val > val)
      root.left = insertIntoBST(root.left, val);
    return root;
  }

  /* 删除一个元素 */
  TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
      // 没有子结点或只有一个子结点的情况
      if (root.left == null) return root.right;
      if (root.right == null) return root.left;
      // 有两个子结点，找到右子树最小值接替位置
      TreeNode minNode = getMin(root.right);
      root.val = minNode.val;
      root.right = deleteNode(root.right, minNode.val);
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }
    return root;
  }

  TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }
}
