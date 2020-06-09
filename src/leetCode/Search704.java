package leetCode;

/**
 * @ClassName: Search704
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class Search704 {

  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }else if (nums[mid] > target) {
        right = mid - 1;
      }else if (nums[mid] < target) {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
    Search704 search704 = new Search704();
    System.out.println(search704.search(nums, 9));
  }

}
