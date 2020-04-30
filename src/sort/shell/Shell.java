package sort.shell;

/**
 * @ClassName: Shell
 * @Description: 希尔排序
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 希尔排序：
 * 基于插入排序的排序算法，为了加快速度简单地改进了插入排序，交换不相邻的元素以对数组的局部进行排序，
 * 并最终用插入排序将局部有序的数组排序。
 *
 * 1、希尔排序的思想是使数组中间隔为h的元素分成一组（不是真的分组，逻辑上分组），h称为增量。
 * 2、每个分组进行插入排序，各个分组变成了有序的了（整体不一定有序）
 * 3、然后缩小增量，继续划分分组，插入排序。此时，每个分组元素个数多了，但是数组变的部分有序了，插入排序效率更高
 * 4、持续缩小增量，最后设置增量为1，，则整个数组被分为1组，因为此时数组已接近有序，插入排序效率高
 */
public class Shell {

  public void sort(int[] a) {
    int length = a.length;

    int h = 1;
    while (h < length / 3) {
      h = h * 3 + 1;
    }
    while (h >= 1) {
      for (int i = h; i < length; i++) {
        for (int j = i; j > h - 1; j = j - h) {
          if (a[j] < a[j - h]) {
            int temp = a[j];
            a[j] = a[j - h];
            a[j - h] = temp;
          }
        }
      }
      h = h / 3;
    }
  }

}
