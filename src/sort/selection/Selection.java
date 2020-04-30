package sort.selection;

/**
 * @ClassName: Selection
 * @Description: 选择排序
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 选择排序：
 * 在数组中找到最小的元素，和第一个元素交换；
 * 剩下数组中找到最小元素，和第二个元素交换；...
 *
 * 排序内循环只是比较当前元素与目前已知的最小元素（以及将当前索引加1和检查是否代码越界）;
 * 外层循环完成交换元素，每次交换都能排定一个元素。
 * 所以，算法的时间效率取决于比较的次数，运行时间和输入无关，每次交换都会改变两个元素。
 */
public class Selection {

  public void sort(int[] a) {
    int length = a.length;

    for (int i = 0; i < length; i++) {
      int min = i;
      for (int j = i; j < length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      int temp = a[i];
      a[i] = a[min];
      a[min] = temp;
    }
  }

}
