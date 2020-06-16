package leetCode;

/**
 * @ClassName: StrStr28
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/16
 **/
public class StrStr28 {

  public int strStr(String haystack, String needle) {
    return kmpMatch(haystack, needle);
  }

  /**
   * 对主串s和模式串t进行KMP模式匹配
   * @param txt 主串
   * @param pat 模式串
   * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
   */
  private int kmpMatch(String txt, String pat){
    char[] t_arr = txt.toCharArray();
    char[] p_arr = pat.toCharArray();
    int[] next = getNextArray(p_arr);
    int i = 0, j = 0;
    while (i < t_arr.length && j < p_arr.length) {
      if(j == -1 || t_arr[i] == p_arr[j]){
        i++;
        j++;
      }else
        j = next[j];
    }
    if(j == p_arr.length)
      return i - j;
    else
      return -1;
  }

  /**
   * 求出Pattern字符数组的next数组
   * @param p 字符数组
   * @return next数组
   */
  private int[] getNextArray(char[] p) {
    if (p.length == 0) {
      return new int[0];
    }
    int[] next = new int[p.length];
    next[0] = -1;
    int k;
    for (int j = 2; j < p.length; j ++) {
      k = next[j - 1];
      while (k != -1) {
        if (p[j - 1] == p[k]) {
          next[j] = k + 1;
          break;
        }else {
          k = next[k];
        }
        next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
      }
    }
    return next;
  }

}
