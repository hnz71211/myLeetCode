package dataStructure.completeBinaryTree;

/**
 * @ClassName: CompleteBinaryTreeCount
 * @Description: 完全二叉树计算树结点数
 *
 *  完全二叉树每一层都是紧凑靠左排列的
 *  满二叉树是一种特殊的完全二叉树，每层都是是满的
 *
 * @Author: hexli
 * @Date: 2020/6/2
 **/
public class CompleteBinaryTreeCount {

  public int countNodes(TreeNode root) {
    TreeNode l = root, r = root;
    // 记录左、右子树的高度
    int hl = 0, hr = 0;
    while (l != null) {
      l = l.left;
      hl++;
    }
    while (r != null) {
      r = r.right;
      hr++;
    }
    // 因为是紧凑向左排列的，所有如果左右子树的高度相同，则是一棵满二叉树
    if (hl == hr) {
      return (int)Math.pow(2, hl) - 1;
    }
    // 如果左右高度不同，则按照普通二叉树的逻辑计算
    return 1 + countNodes(root.left) + countNodes(root.right);
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
