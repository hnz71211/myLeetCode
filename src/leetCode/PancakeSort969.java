package leetCode;


import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: PancakeSort969
 * @Description:
 *    1、找到 n 个饼中最大的那个。
 *    2、把这个最大的饼移到最底下。
 *    3、递归调用 pancakeSort(A, n - 1)。
 *     base case：n == 1 时，排序 1 个饼时不需要翻转。
 *
 * @Author: hexli
 * @Date: 2020/6/10
 **/
public class PancakeSort969 {

  LinkedList<Integer> res = new LinkedList<>();

  public List<Integer> pancakeSort(int[] A) {
    sort(A, A.length);
    return res;
  }

  void sort(int[] pancakes, int n) {
    // base case:
    if (n == 1)
      return;

    // 最大饼
    int maxPancake = 0;
    int maxPancakeIndex = 0;
    for (int i = 0; i < n; i++) {
      if (pancakes[i] > maxPancake) {
        maxPancakeIndex = i;
        maxPancake = pancakes[i];
      }
    }

    // 第一次翻转，将最大饼翻到最上面
    reverse(pancakes, 0, maxPancakeIndex);
    // 记录翻饼个数
    res.add(maxPancakeIndex + 1);
    // 第二次翻转，将最大饼翻到最下面
    reverse(pancakes, 0, n - 1);
    res.add(n);

    // 递归调用
    sort(pancakes, n - 1);
  }

  void reverse(int[] pancakes, int i, int j) {
    while (i < j) {
      int temp = pancakes[i];
      pancakes[i] = pancakes[j];
      pancakes[j] = temp;
      i ++;
      j --;
    }
  }

  public static void main(String[] args) {
    int[] A = new int[]{3, 2, 4, 1};
    PancakeSort969 pancakeSort969 = new PancakeSort969();
    pancakeSort969.pancakeSort(A);
    System.out.println();
  }

}
