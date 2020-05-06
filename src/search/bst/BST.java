package search.bst;

/**
 * @ClassName: BST
 * @Description: 基于二叉查找树的符号表
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 一颗二叉查找树（BST)是一个二叉树，每个节点的键都大于左子树中的任意节点的键而小于右子树的任意节点的键
 * @param <Key>
 * @param <Value>
 */

/**
 * 一棵二叉查找树中，所有操作在最坏的情况下所需的时间都和树的高度成正比
 * 最坏情况下运行时间的增长数量级：查找N 插入N， 平均情况：查找1.39lgN 插入1.39lgN
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

  private Node root;
  private class Node {
    private Key key;  // 键
    private Value val;  // 值
    private Node left, right; // 指向子树的链接
    private int N;  // 以该节点为根的子树中的节点总数

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.val = val;
      this.N = N;
    }
  }

  public int size() {
    return size(root);
  }
  private int size(Node x) {
    if (x == null) {
      return 0;
    }
    return x.N;
  }

  // 每个方法都对应一个私有方法，它接受一个额外的链接作为参数指向某个节点。

  public Value get(Key key) {
    return get(root, key);
  }
  private Value get(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    }else if (cmp > 0) {
      return get(x.right, key);
    }else {
      return x.val;
    }
  }

  public void put(Key key, Value val) {
    // 查找key，找到更新它的值，否则为它创建一个新的节点
    root = put(root, key, val);
  }
  private Node put(Node x, Key key, Value val) {
    // 如果key存在于以x为根节点的子树中则更新它的值；
    // 否则将以key和val为键值对的新节点插入到孩子树中
    if (x == null) {
      return new Node(key, val, 1);
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, val);
    }else if (cmp > 0) {
      x.right = put(x.right, key, val);
    }else {
      x.val = val;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    return min(root).key;
  }
  private Node min(Node x) {
    if (x.left == null) return x;
    return min(x.left);
  }

  // 返回排名为k的节点
  public Key select(int k) {
    return select(root, k).key;
  }
  private Node select(Node x, int k) {
    if (x == null) {
      return null;
    }
    int t = size(x.left);
    if (t > k) {
      return select(x.left, k);
    }else if (t < k) {
      return select(x.right, k - t - 1);
    }else {
      return x;
    }
  }

  // 返回小于x.key的键的数量
  public int rank(Key key) {
    return rank(key, root);
  }
  private int rank(Key key, Node x) {
    if (x == null) {
      return 0;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return rank(key, x.left);
    }else if (cmp > 0) {
      return 1 + size(x.left) + rank(key, x.right);
    }else {
      return size(x.left);
    }
  }

  // 删除最大元素
  // 不断深入根节点的右子树，直到遇到一个空链接，然后将指向该节点的链接指向该节点的左子树
  public void deleteMax() {
    root = deleteMax(root);
  }
  private Node deleteMax(Node x) {
    if (x.right == null) {
      return x.left;
    }
    x.right = deleteMax(x.right);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  // 删除最小元素
  // 不断深入根节点的左子树，直到遇到一个空链接，然后将指向该节点的链接指向该节点的右子树
  public void deleteMin() {
    root = deleteMin(root);
  }
  private Node deleteMin(Node x) {
    if (x.left == null) {
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  // 删除
  public void delete(Key key) {
    root = delete(root, key);
  }
  private Node delete(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = delete(x.left, key);
    } else if (cmp > 0) {
      x.right = delete(x.right, key);
    } else {
      if (x.right == null) {
        return x.left;
      }
      if (x.left == null) {
        return x.right;
      }
      // 在删除节点x后用它的后继节点填补它的位置。
      // 4个步骤完成将x替换为它的后继节点的任务
      // 1、将指向即将被删除的节点的链接保存为t
      // 2、将x指向它的后继节点min(t.right)
      // 3、将x的右链接指向deleteMin(t.right)，也就是在删除后所有节点仍然都大于x.key的子二叉查找树
      // 4、将x的左链接设为t.left。
      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

}
