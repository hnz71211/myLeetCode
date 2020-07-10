package leetCode;

import java.util.Random;

/**
 * @ClassName: GetRandom382
 * @Description: 链表随机节点
 *
 * 第 i 个元素被选择的概率是 1/i，第 i+1 次不被替换的概率是 1 - 1/(i+1)，以此类推，相乘就是第 i 个元素最终被选中的概率，就是 1/n.
 * 如果要随机选择 k 个数，只要在第 i 个元素处以 k/i 的概率选择该元素，以 1 - k/i 的概率保持原有选择即可
 *
 * @Author: hexli
 * @Date: 2020/7/10
 **/
public class GetRandom382 {

  private ListNode head = null;

  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public GetRandom382(ListNode head) {
    this.head = head;
  }

  /** Returns a random node's value. */
  public int getRandom() {
    int k = 1;
    return getRandom(head, k)[0];
  }

  /* 返回链表中 k 个随机节点的值 */
  int[] getRandom(ListNode head, int k) {
    Random r = new Random();
    int[] res = new int[k];
    ListNode p = head;

    // 前 k 个元素先默认选上
    for (int j = 0; j < k && p != null; j++) {
      res[j] = p.val;
      p = p.next;
    }

    int i = k;
    // while 循环遍历链表
    while (p != null) {
      // 生成一个 [0, i) 之间的整数
      int j = r.nextInt(++i);
      // 这个整数小于 k 的概率就是 k/i
      if (j < k) {
        res[j] = p.val;
      }
      p = p.next;
    }
    return res;
  }

}
