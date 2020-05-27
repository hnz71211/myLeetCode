package dynamic_programming.patternMatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PatternMatch
 * @Description: 正则表达
 * @Author: hexli
 * @Date: 2020/5/27
 **/
public class PatternMatch {

  static boolean isMatch(String text, String pattern) {

    Map<String, Boolean> memo = new HashMap<>();

    return dp(text, pattern, 0, 0, memo);

  }

  static boolean dp(String text, String patter, int i, int j, Map<String, Boolean> memo) {

    if (memo.get(i + "," + j) != null) {
      return memo.get(i + "," + j);
    }

    if (j == patter.length()) {
      return i == text.length();
    }

    boolean first = i < text.length() &&
            (patter.charAt(j) == text.charAt(i) || patter.charAt(j) == '.');

    boolean ans;
    if (j <= patter.length() - 2 && patter.charAt(j + 1) == '*') {
      // 如果发现有字符和 '*' 结合，
      // 或者匹配该字符 0 次，然后跳过该字符和 '*'
      // 或者当 pattern[0] 和 text[0] 匹配后，移动 text
      ans = dp(text, patter, i, j + 2, memo) ||
              (first && dp(text, patter, i + 1, j, memo));
    }else {
      ans = first && dp(text, patter, i + 1, j + 1, memo);
    }

    memo.put(i + "," + j, ans);
    return ans;
  }

  public static void main(String[] args) {
    String text = "ab";
    String pattern = ".*";
    System.out.println(isMatch(text, pattern));
  }

}
