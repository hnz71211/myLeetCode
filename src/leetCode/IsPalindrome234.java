package leetCode;

/**
 * @ClassName: IsPalindrome234
 * @Description:
 * @Author: hexli
 * @Date: 2020/7/6
 **/
public class IsPalindrome234 {

  public boolean isPalindrome(ListNode head) {

    if (head == null)
      return true;

    ListNode left = head, right = head;

    // 快慢指针寻找中间结点
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      // 偶数个结点，慢指针再向前一步
      slow = slow.next;
    }

    // 反转中间后面的链表
    right = reverse(slow);

    // 比较
    while (right != null) {
      if (left.val != right.val)
        return false;
      left = left.next;
      right = right.next;
    }
    return true;
  }

  // 单链表反转
  private ListNode reverse(ListNode head) {
    ListNode pre = null, cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(2);
    ListNode n5 = new ListNode(1);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    IsPalindrome234 isPalindrome234 = new IsPalindrome234();
    boolean res = isPalindrome234.isPalindrome(n1);
    System.out.println(res);

  }

}
