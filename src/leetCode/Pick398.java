package leetCode;

import java.util.Random;

/**
 * @ClassName: Pick398
 * @Description: 随机数索引
 * @Author: hexli
 * @Date: 2020/7/13
 **/
public class Pick398 {

  private int[] nums;

  public Pick398(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {

    Random r = new Random();

    int targetCount = 0;
    int res = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != target) {
        continue;
      }

      targetCount ++;
      // 这个整数等于 0 的概率就是 1/count
      if (r.nextInt(targetCount) == 0) {
        res = i;
      }
    }

    return res;
  }

  public static void main(String[] args) {

    int[] nums = new int[] {1,2,3,3,3};
    Pick398 pick398 = new Pick398(nums);
    int res = pick398.pick(3);
    System.out.println(res);
  }

}
