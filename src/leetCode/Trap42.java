package leetCode;

/**
 * @ClassName: Trap42
 * @Description: 接雨水
 * @Author: hexli
 * @Date: 2020/6/22
 **/
public class Trap42 {

  public int trap(int[] height) {
    int n = height.length;
    if (n == 0)
      return 0;

    int left = 0, right = n - 1;
    int ans = 0;

    // 双指针
    int l_max = height[0];
    int r_max = height[n - 1];

    while (left <= right) {
      // l_max 是 height[0..left] 中最高柱子的高度
      l_max = Math.max(l_max, height[left]);
      // r_max 是 height[right..end] 的最高柱子的高度。
      r_max = Math.max(r_max, height[right]);

      // ans += min(l_max, r_max) - height[i]
      if (l_max < r_max) {
        ans += l_max - height[left];
        left++;
      } else {
        ans += r_max - height[right];
        right--;
      }
    }
    return ans;
  }

}
