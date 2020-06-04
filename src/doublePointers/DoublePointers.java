package doublePointers;

/**
 * @ClassName: DoublePointers
 * @Description: 双指针技巧总结
 * @Author: hexli
 * @Date: 2020/6/4
 **/
public class DoublePointers {

  /**
   * 判定链表中是否含有环
   * 两个指针，一个跑得快，一个跑得慢。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环
   * @param head
   * @return
   */
  boolean hasCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) return true;
    }
    return false;
  }

  /**
   * 已知链表中含有环，返回这个环的起始位置
   * @param head
   * @return
   */
  ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) break;
    }
    // 当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
    slow = head;
    while (slow != fast) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 寻找链表的中点
   * 快指针一次前进两步，慢指针一次前进一步，当快指针到达链表尽头时，慢指针就处于链表的中间位置
   * @param head
   * @return
   */
  ListNode midPoint(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // slow 就在中间位置
    return slow;
  }

  /**
   * 寻找链表的倒数第 k 个元素
   * 让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点
   * @param head
   * @return
   */
  ListNode lastK(ListNode head, int k) {
    ListNode slow, fast;
    slow = fast = head;
    while (k-- > 0)
      fast = fast.next;

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /**
   * 二分查找
   * @param nums
   * @param target
   * @return
   */
  int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
      int mid = (right + left) / 2;
      if(nums[mid] == target)
        return mid;
      else if (nums[mid] < target)
        left = mid + 1;
      else if (nums[mid] > target)
        right = mid - 1;
    }
    return -1;
  }

  /**
   * 两数之和
   *    给定一个升序数组，找到两个数，使它们相加之和等于目标数，返回两数的索引
   * @param nums
   * @param target
   * @return
   */
  int[] twoSum(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        return new int[]{left, right};
      } else if (sum < target) {
        left++; // 让 sum 大一点
      } else if (sum > target) {
        right--; // 让 sum 小一点
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * 反转数组
   * @param nums
   */
  void reverse(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      // swap(nums[left], nums[right])
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++; right--;
    }
  }

}


class ListNode {
  int val;
  ListNode next;
}
