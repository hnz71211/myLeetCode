package dataStructure.lru;

/**
 * @ClassName: TestLRU
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/2
 **/
public class TestLRU {


  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(3);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    lruCache.put(3, 3);
    lruCache.get(2);
    lruCache.put(3, 33);
    lruCache.put(4, 4);
  }



}
