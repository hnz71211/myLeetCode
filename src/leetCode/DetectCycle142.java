package leetCode;

/**
 * @ClassName: DetectCycle142
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class DetectCycle142 {

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        hasCycle = true;
        break;
      }
    }
    if (!hasCycle) {
      return null;
    }
    // 让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
    slow = head;
    while (slow != fast) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    n1.next = n2;
    n2.next = n1;

    DetectCycle142 detectCycle142 = new DetectCycle142();
    ListNode p = detectCycle142.detectCycle(n1);
    System.out.println();
  }

}
