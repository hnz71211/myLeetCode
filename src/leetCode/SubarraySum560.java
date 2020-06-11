package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SubarraySum560
 * @Description: 前缀和
 *    sum[i] 记录nums[0-i]个元素和
 *    preSum<sum, count> 记录和为sum的前缀出现的次数
 *    例如：
 *      nums:       3  5   2  -2   4   1
 *      sum:        3  8  10   8  12  13
 *      preSum:  (3, 1), (8, 2), (10, 1), (12, 1), (13, 1)
 *      当 k = 5, i遍历到（num[5]=1）时，需要找到前缀和为13-5=8，即preSum的key=8，res+=2.
 * @Author: hexli
 * @Date: 2020/6/10
 **/
public class SubarraySum560 {

  public int subarraySum(int[] nums, int k) {

    int n = nums.length;

    // 前缀和该前缀和出现的次数
    Map<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0, 1);

    // 前i个数的和
    int[] sum = new int[n];

    int ans = 0;

    for (int i = 0; i < n; i++) {
      // nums[0..i]的和
      sum[i] = i == 0 ? nums[0] : sum[i - 1] + nums[i];

      // nums[0..j]的和
      int sum_j = sum[i] - k;

      // 找到前缀和为sum_j的
      if (preSum.containsKey(sum_j))
        ans += preSum.get(sum_j);

      // nums[0..i]加入并记录次数
      preSum.put(sum[i], preSum.getOrDefault(sum[i], 0) + 1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1};
    int k = 1;
    SubarraySum560 subarraySum560 = new SubarraySum560();
    int ans = subarraySum560.subarraySum(nums, k);
    System.out.println(ans);
  }

}
