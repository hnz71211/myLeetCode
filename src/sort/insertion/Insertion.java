package sort.insertion;

/**
 * @ClassName: Insertion
 * @Description: 插入排序
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 索引左边的所有元素是有序的，但最终位置还不确定，为了给更小的元素腾出空间，它们随时会被移动。当所以达到数组右端时，数组排序就完成了。
 *
 * 插入排序所需时间取决于输入中元素的初始顺序。大规模乱序数组插入排序很慢，因为塔只会交换相邻的元素，元素只能一点一点地从数组的一端移动到另一端。
 * 对一个接近有序的数组进行排序效果更好。
 */
public class Insertion {

  public void sort(int[] a) {
    int length = a.length;
    for (int i = 0; i < length; i++) {
      for (int j = i; j > 0; j--) {
        if (a[j] < a[j - 1]) {
          int temp = a[j];
          a[j] = a[j - 1];
          a[j - 1] = temp;
        }
      }
    }
  }


}
