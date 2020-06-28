package leetCode;

/**
 * @ClassName: DeleteDuplicates83
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/28
 **/
public class DeleteDuplicates83 {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return null;

    ListNode slow = head, fast = head.next;

    // 让慢指针 slow 走左后面，快指针 fast 走在前面探路，找到一个不重复的元素就告诉 slow 并让 slow 前进一步。
    // 这样当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是不重复元素，之后的所有元素都是重复元素
    while (fast != null) {
      if (slow.val != fast.val) {
        // nums[slow] = nums[fast];
        slow.next = fast;
        // slow++
        slow = slow.next;
      }
      fast = fast.next;
    }
    // 断开与后面重复元素的连接
    slow.next = null;

    return head;
  }

}
