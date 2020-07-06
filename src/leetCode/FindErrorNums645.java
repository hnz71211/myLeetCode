package leetCode;

/**
 * @ClassName: FindErrorNums645
 * @Description: 错误的集合
 * @Author: hexli
 * @Date: 2020/7/2
 **/
public class FindErrorNums645 {

  /*
  有一个元素重复了，同时导致一个元素缺失
  会导致有两个元素对应到了同一个索引，而且会有一个索引没有元素对应过去。
   */
  public int[] findErrorNums(int[] nums) {

    int n = nums.length;

    int dup = -1;
    for (int i = 0; i < n; i++) {
      // 现在的元素是从 1 开始的
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0)
        dup = Math.abs(nums[i]);
      else
        nums[index] = -nums[index];
    }

    int missing = -1;
    for (int i = 0; i < n; i++) {
      // nums[i] 大于 0 则说明没有访问
      if (nums[i] > 0)
        missing = i + 1;
    }

    return new int[]{dup, missing};
  }

}
