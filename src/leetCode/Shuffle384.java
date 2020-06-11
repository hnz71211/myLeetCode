package leetCode;

import java.util.Random;

/**
 * @ClassName: Shuffle384
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class Shuffle384 {

  private int[] nums = null;

  public Shuffle384(int[] nums) {
    this.nums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return this.nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int n = this.nums.length;
    int[] shuffle = new int[n];
    for (int i = 0; i < n; i++) {
      shuffle[i] = this.nums[i];
    }

    for (int i = 0; i < n; i++) {
      // 将shuffle分成两部分，左边为乱序数组，右边为未乱序数组
      // 在右边随机生成索引，与左边交换
      int rand = randInt(i, n - 1);
      int temp = shuffle[rand];
      shuffle[rand] = shuffle[i];
      shuffle[i] = temp;
    }

    return shuffle;
  }

  // 随机生成[min, max]范围数值
  int randInt(int min, int max) {
    return new Random().nextInt(max - min + 1) + min;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    Shuffle384 shuffle384 = new Shuffle384(nums);
    int[] s = shuffle384.shuffle();
    System.out.println(s);
    int[] s2 = shuffle384.reset();
    System.out.println(s2);
  }

}
