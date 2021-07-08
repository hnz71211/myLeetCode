package leetCode;

/**
 * @ClassName: SearchInsert35
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/4
 **/
public class SearchInsert35 {
  public int searchInsert(int[] nums, int target) {
    int len = nums.length;
    if (len == 0)
      return 0;
    if (target > nums[len - 1])
      return len;

    int left = 0, right = len - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (target > nums[mid]) {
        left = mid + 1;
      }else {
        right = mid;
      }
    }
    return left;
  }
}
