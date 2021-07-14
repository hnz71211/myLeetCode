package leetCode;

/**
 * @ClassName: RemoveNthFromEnd19
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/14
 **/
public class RemoveNthFromEnd19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;
    // 让fast移动n+1步，然后让fast和slow同时移动，直到fast指向链表末尾。
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }
}
