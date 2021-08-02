package leetCode;

/**
 * @ClassName: ReverseWords151
 * @Description:
 * @Author: hexli
 * @Date: 2021/8/2
 **/
public class ReverseWords151 {

  public static String reverseWords(String s) {
    // remove space
    StringBuilder sb = removeSpace(s);
    // reverse the whole string
    reverseString(sb, 0, sb.length() - 1);
    // reverse each word
    reverseEachWord(sb);
    return sb.toString();
  }

  private static StringBuilder removeSpace(String s) {
    int start = 0, end = s.length() - 1;
    while (s.charAt(start) == ' ') {
      start ++;
    }
    while (s.charAt(end) == ' ') {
      end --;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      char c = s.charAt(i);
      if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
        sb.append(s.charAt(i));
      }
    }
    return sb;
  }

  private static void reverseString(StringBuilder sb, int start, int end) {
    while (start < end) {
      char temp = sb.charAt(start);
      sb.setCharAt(start, sb.charAt(end));
      sb.setCharAt(end, temp);
      start ++;
      end --;
    }
  }

  private static void reverseEachWord(StringBuilder sb) {
    int start = 0, end = 1;
    int n = sb.length();
    while (start < n) {
      while (end < n && sb.charAt(end) != ' ') {
        end ++;
      }
      reverseString(sb, start, end - 1);
      start = end + 1;
      end = start + 1;
    }
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("a good   example"));
  }
}
