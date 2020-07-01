package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindDisappearedNumbers448
 * @Description:
 * @Author: hexli
 * @Date: 2020/7/1
 **/
public class FindDisappearedNumbers448 {

  public List<Integer> findDisappearedNumbers(int[] nums) {

    // 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为消失（未出现过）的数字。
    for (int i = 0; i < nums.length; ++i)
      nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i){
      if (nums[i] > 0)
        res.add(i+1);
    }
    return res;

  }

}
