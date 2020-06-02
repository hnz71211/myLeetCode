package dataStructure.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LRUCache
 *
 * @Description:
 *  LRU 算法实际上是让你设计数据结构：首先要接收一个 capacity 参数作为缓存的最大容量，
 *    然后实现两个 API，一个是 put(key, val) 方法存入键值对，另一个是 get(key) 方法获取 key 对应的 val，如果 key 不存在则返回 -1。
 *      get 和 put 方法必须都是 O(1) 的时间复杂度
 *
 * 实现方式：哈希链表，双向链表和哈希表的结合体, 借助哈希表赋予了链表快速查找的特性
 *
 * 为什么必须要用双向链表?
 *        因为我们需要删除操作。删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针，而双向链表才能支持直接查找前驱，保证操作的时间复杂度 O(1)
 *
 * @Author: hexli
 * @Date: 2020/6/1
 **/
public class LRUCache {

  private Map<Integer, Node> map;

  private DoubleList cache;

  private int capacity = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    int val = map.get(key).val;
    // 利用 put 方法把该数据提前
    put(key, val);
    return val;
  }

  public void put(int key, int val) {
    // 先把新节点 x 做出来
    Node x = new Node(key, val);

    if (map.containsKey(key)) {
      // 删除旧的节点，新的插到头部
      cache.remove(map.get(key));
    } else {
      if (capacity == cache.size()) {
        // 删除链表最后一个数据
        Node last = cache.removeLast();
        map.remove(last.key);
      }
    }
    // 添加到头部
    cache.addFirst(x);
    map.put(key, x);
  }
}

/**
 * 双向链表API
 */
class DoubleList {

  // 头结点
  private Node head;

  // 尾结点
  private Node tail;

  // 链表长度
  private int N = 0;

  // 在链表头部添加节点 x，时间 O(1)
  public void addFirst(Node x) {
    N++;
    if (head == null) {
      tail = x;
    }else {
      head.prev = x;
      //把first节点往下移动
      x.next = head;
    }
    //把插入的节点作为新的节点
    head = x;
  }

  // 删除链表中的 x 节点（x 一定存在）
  // 由于是双链表且给的是目标 Node 节点，时间 O(1)
  public void remove(Node x) {
    Node prev = x.prev;
    Node next = x.next;
    if (prev == null) {
      this.head = next;
    } else {
      prev.next = next;
      x.prev = null;
    }
    if (next == null) {
      this.tail = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }
    N--;
  }

  // 删除链表中最后一个节点，并返回该节点，时间 O(1)
  public Node removeLast() {
    Node temp = tail;
    if (head.next == null) {
      tail = null;
      //把第一个删除
      head = null;
    }else {
      tail.prev.next = null;
    }
    tail = temp.prev;
    N--;
    return temp;
  }

  // 返回链表长度，时间 O(1)
  public int size() {
    return N;
  }
}

class Node {
  public int key, val;
  public Node next, prev;
  public Node(int k, int v) {
    this.key = k;
    this.val = v;
  }
}
