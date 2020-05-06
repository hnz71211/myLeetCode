package search.binarySearchST;

/**
 * @ClassName: BinarySearchST
 * @Description: 二分查找
 * @Author: hexli
 * @Date: 2020/4/30
 **/

/**
 * 在N个键的有序数组中进行二次查找最多需要 lgN+1 次比较
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

  private Key[] keys;
  private Value[] vals;
  private int N;

  public BinarySearchST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Object[capacity];
  }

  public int size() {
    return N;
  }

  public Value get(Key key) {
    if (isEmpty()) {
      return null;
    }
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) {
      return vals[i];
    }
    return null;
  }

  /**
   * 基于有序数组的二分查找（迭代）
   * @param key
   * @return
   */
  public int rank(Key key) {
    int lo = 0, hi = N - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp < 0) {
        hi = mid - 1;
      }else if (cmp > 0) {
        lo = mid + 1;
      }else {
        return mid;
      }
    }
    return lo;
  }

  public void put(Key key, Value val) {
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) {
      vals[i] = val;
      return;
    }
    for (int j = N; j > i; j--) {
      keys[j] = keys[j - 1];
      vals[j] = vals[j - 1];
    }
    keys[i] = key;
    vals[i] = val;
    N++;
  }

  public void delete(Key key) {
    if (isEmpty()) {
      return;
    }
    int i = rank(key);
    if (keys[i].compareTo(key) == 0) {
      for (int j = i; j < N; j++) {
        keys[j] = keys[j + 1];
        vals[j] = vals[j + 1];
      }
      N--;
    }
  }

  public boolean isEmpty() {
    return N == 0 ? true : false;
  }

}
