package sort.quick;

/**
 * @ClassName: Quick
 * @Description: 快速排序
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 快速排序是一种分治算法。
 * 快速排序递归地将子数组a[lo..hi]排序，先用partition()方法将a[j]放到一个合适位置，然后再用递归调用将其他位置的元素排序。
 * 该方法的关键在于切分，这个过程使得数组满足下面3个条件：
 * 1）对于某个j，a[j]已经排定
 * 2）a[lo]到a[j-1]中所有元素都不大于a[j]
 * 3）a[j+1]到a[hi]中的所有元素都不小于a[j]
 */
public class Quick {

  public void sort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  private void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private int partition(int[] a, int lo, int hi) {
    // 左右扫描指针
    int i = lo;
    int j = hi + 1;
    // 切分元素
    int v = a[lo];
    while (true) {
      // 扫描左右，找到小于v和大于v的元素交换
      while (a[++i] < v) {
        if (i == hi) {
          break;
        }
      }
      while (v < a[--j]) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  private void exch(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
