package leetCode;

/**
 * @ClassName: SearchRange34
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class SearchRange34 {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = left_bound(nums, target);
    res[1] = right_bound(nums, target);
    return res;
  }

  int left_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    // 搜索区间为[left, right]
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] < target) {
        left = mid + 1;
      }else if (nums[mid] > target) {
        right = mid - 1;
      }else if (nums[mid] == target) {
        // 所以当 nums[mid] == target 时不要立即返回，而要收紧右侧边界以锁定左侧边界
        right = mid - 1;
      }
    }
    // 检查出界情况
    if (left >= nums.length || nums[left] != target)
      return -1;
    return left;
  }

  int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] < target) {
        left = mid + 1;
      }else if (nums[mid] > target) {
        right = mid - 1;
      }else if (nums[mid] == target) {
        // 当 nums[mid] == target 时不要立即返回，而要收紧左侧边界以锁定右侧边界
        left = mid + 1;
      }
    }
    // 检查出界情况
    if (right < 0 || nums[right] != target)
      return -1;
    return right;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5, 7, 7, 8, 8, 10};
    int target = 8;
    SearchRange34 searchRange34 = new SearchRange34();
    int[] res = searchRange34.searchRange(nums, target);
    System.out.println();
  }

}
