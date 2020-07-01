package leetCode;

/**
 * @ClassName: ReverseKGroup25
 * @Description: k个一组反转链表
 * @Author: hexli
 * @Date: 2020/7/1
 **/
public class ReverseKGroup25 {

  public ListNode reverseKGroup(ListNode head, int k) {

    if (head == null)
      return null;

    // 区间 [a, b) 包含 k 个待反转元素
    ListNode a = head, b = head;
    for (int i = 0; i < k; i++) {
      // 不足 k 个，不需要反转，base case
      if (b == null)
        return head;
      b = b.next;
    }
    // 反转前 k 个元素
    ListNode newHead = reverse(a, b);
    // 递归反转后续链表并连接起来
    a.next = reverseKGroup(b, k);

    return newHead;

  }

  /**
   * 反转区间 [a, b) 的元素，注意是左闭右开
   * @param a
   * @return
   */
  private ListNode reverse(ListNode a, ListNode b) {
    ListNode pre, cur, next;
    pre = null;
    cur = a;
    next = a;

    while (cur != b) {
      next = cur.next;
      // 逐个结点反转
      cur.next = pre;
      // 更新指针位置
      pre = cur;
      cur = next;
    }

    // 返回反转后的头结点
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    head.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
    ListNode n = reverseKGroup25.reverseKGroup(head, 2);
    System.out.println(n);
  }
}
