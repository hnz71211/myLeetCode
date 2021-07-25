package leetCode;

/**
 * @ClassName: ReverseStr541
 * @Description:
 * @Author: hexli
 * @Date: 2021/7/24
 **/
public class ReverseStr541 {
  public String reverseStr(String s, int k) {
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length; i += 2 * k) {
      int start = i;
      //这里是判断尾数够不够k个来取决end指针的位置
      int end = Math.min(ch.length - 1, start + k - 1);
      //用异或运算反转
      while(start < end){
        ch[start] ^= ch[end];
        ch[end] ^= ch[start];
        ch[start] ^= ch[end];
        start++;
        end--;
      }
    }
    return new String(ch);
  }
}
