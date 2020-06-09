package leetCode;

/**
 * @ClassName: HasCycle141
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class HasCycle141 {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow)
        return true;
    }
    return false;
  }

}
