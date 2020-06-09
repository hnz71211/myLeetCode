package leetCode;

/**
 * @ClassName: TwoSum167
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/9
 **/
public class TwoSum167 {

  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    int[] res = new int[2];
    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        res[0] = i + 1;
        res[1] = j + 1;
        return res;
      }else if (numbers[i] + numbers[j] < target) {
        i ++;
      }else {
        j --;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TwoSum167 twoSum167 = new TwoSum167();
    int[] nums = new int[]{2, 7, 11, 15};
    int[] res = twoSum167.twoSum(nums, 9);
    System.out.println();
  }

}
