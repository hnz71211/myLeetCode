package search.redBlackBST;

/**
 * @ClassName: RedBlackBST
 * @Description: 红黑二叉查找树
 * @Author: hexli
 * @Date: 2020/5/6
 **/

/**
 * 红黑树性质：
 * 1. 每个结点不是红色就是黑色；
 * 2. 不可能有连在一起的红色结点；
 * 3. 根结点都是黑色；
 * 4. 每个红色结点的两个子结点都是黑色。
 * 5. 该树是完美黑色平衡的，即任意空结点到根结点的路径上的黑结点数量相同。
 */

/**
 * 旋转和颜色变换规则：所有插入的点默认为红色
 * 1. 变颜色的情况：当前结点的父亲结点为红色，且他的祖父结点的另一个子结点（叔叔结点）也是红色
 *    a. 把父结点设为黑色
 *    b. 把叔叔结点设为黑色
 *    c. 把祖父结点设为红色
 *    d. 把指针定义到祖父结点，设为当前要操作的结点
 * 2. 左旋：当前父结点是红色，叔叔是黑色的时候，且当前结点是右子树。左旋以父结点作为左旋
 * 3. 右旋：当前父结点是红色，叔叔是黑色的时候，且当前结点是左子树。右旋
 *    a. 把父结点变为黑色
 *    b. 把祖父结点变成红色
 *    c. 已祖父结点旋转
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {
    Key key;
    Value val;
    Node left, right; // 左右子树
    int N;  // 这棵子树中的结点总数
    boolean color;  // 由其父结点指向它的链接的颜色

    Node(Key key, Value val, int N, boolean color) {
      this.key = key;
      this.val = val;
      this.N = N;
      this.color = color;
    }
  }

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    }
    return x.color == RED;
  }

  private int size(Node x) {
    if (x == null) {
      return 0;
    }
    return x.N;
  }

  /**
   * 左旋转h的右链接
   * 旋转操作返回一条链接。
   * 用rotateLeft()或rotateRight()的返回值重置父节点中对应的链接
   * */
  public Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  /** 右旋转h的左链接 */
  public Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  /** 颜色转换 */
  private void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }
  public Node put(Node h, Key key, Value val) {
    // 标准的插入操作
    if (h == null) {
      return new Node(key, val, 1, RED);
    }

    int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, val);
    }else if (cmp > 0) {
      h.right = put(h.right, key, val);
    }else {
      h.val = val;
    }

    if (isRed(h.right) && !isRed(h.left)) {
      h = rotateLeft(h);
    }
    if (isRed(h.left) && !isRed(h.left.left)) {
      h = rotateRight(h);
    }
    if (isRed(h.left) && !isRed(h.right)) {
      flipColors(h);
    }

    h.N = size(h.left) + size(h.right) + 1;
    return h;
  }

}
