package sort.merge;

/**
 * @ClassName: Merge
 * @Description: 归并排序
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 归并排序
 * 要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。
 * 归并排序能保证将任意长度N的数组排序所需时间和NlogN成正比；缺点是需要额外空间和N成正比。
 */
public class Merge {

  // 归并所需的辅助数组
  private int[] aux;

  public void sort(int[] a) {
    aux = new int[a.length];  // 一次性分配空间
    sort(a, 0, a.length - 1);
  }

  private void sort(int[] a, int lo, int hi) {
    // 将数组a[lo..hi]排序
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid); // 将左半边排序
    sort(a, mid + 1, hi); // 将右半边排序
    merge(a, lo, mid, hi);  // 归并结果
  }

  // 原地归并，将子数组a[lo..mid]和a[mid+1..hi]归并成一个有序的数组并将结果存放在a[lo..hi]中
  private void merge(int[] a, int lo, int mid, int hi) {
    //将a[lo..mid] 和 a[mid..hi]归并
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    // 归并回到a[lo..hi]
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      }else if (j > hi) {
        a[k] = aux[i++];
      }else if (aux[j] < aux[i]) {
        a[k] = aux[j++];
      }else {
        a[k] = aux[i++];
      }
    }
  }

}
