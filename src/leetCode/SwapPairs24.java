package leetCode;

/**
 * @ClassName: SwapPairs24
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/13
 **/
public class SwapPairs24 {

  public static ListNode swapPairs_recursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = head.next;
    head.next = swapPairs_recursion(newHead.next);
    newHead.next = head;
    return newHead;
  }

  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) {
      ListNode node1 = prev.next;
      ListNode node2 = prev.next.next;

      prev.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      prev = node1;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    ListNode res = swapPairs(node1);
    System.out.println(res);
  }
}
