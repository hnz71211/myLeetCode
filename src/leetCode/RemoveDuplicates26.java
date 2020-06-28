package leetCode;

/**
 * @ClassName: RemoveDuplicates26
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/28
 **/
public class RemoveDuplicates26 {

  public int removeDuplicates(int[] nums) {

    int n = nums.length;
    if (n == 0)
      return 0;

    int slow = 0, fast = 1;

    // 让慢指针 slow 走左后面，快指针 fast 走在前面探路，找到一个不重复的元素就告诉 slow 并让 slow 前进一步。
    // 这样当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是不重复元素，之后的所有元素都是重复元素
    while (fast < n) {
      if (nums[slow] != nums[fast]) {
        slow ++;
        // 维护[0..slow]不重复
        nums[slow] = nums[fast];
      }
      fast ++;
    }

    return slow + 1;
  }

}
