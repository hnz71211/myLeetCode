package leetCode;

/**
 * @ClassName: ReverseList206
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/13
 **/
public class ReverseList206 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode prev = null;
    ListNode cur = head;
    ListNode tmp = null;
    while (cur != null) {
      tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    return prev;
  }
}
