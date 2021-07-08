package leetCode;

/**
 * @ClassName: SortedSquares977
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/8
 **/
public class SortedSquares977 {
  public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int s = 0, e = n - 1;
    int[] ans = new int[n];

    int pos = n - 1;
    while (s <= e) {
      if (nums[s] * nums[s] > nums[e] * nums[e]) {
        ans[pos--] = nums[s] * nums[s];
        s ++;
      }else {
        ans[pos--] = nums[e] * nums[e];
        e --;
      }
    }
    return ans;
  }
}
