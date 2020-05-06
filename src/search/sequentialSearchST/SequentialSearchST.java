package search.sequentialSearchST;

/**
 * @ClassName: SequentialSearchST
 * @Description: 顺序查找（基于无序链表）
 * @Author: hexli
 * @Date: 2020/4/30
 **/
public class SequentialSearchST<Key, Value> {

  private Node first; // 链表首节点

  // 链表节点定义
  private class Node {
    Key key;
    Value val;
    Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  // 查找给定的键，返回相关联的值
  public Value get(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.val;
      }
    }
    return null;
  }

  // 查找给定的值，找到更新其值，否则在表中新建节点
  public void put(Key key, Value val) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        // 命中
        x.val = val;
        return;
      }
    }
    // 未命中，链首新建节点
    first = new Node(key, val, first);
  }

}
