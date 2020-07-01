package leetCode;

import java.util.Stack;

/**
 * @ClassName: IsValid20
 * @Description: 有效的括号
 * @Author: hexli
 * @Date: 2020/7/1
 **/
public class IsValid20 {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      }else {
        if (stack.isEmpty())
          return false;
        Character top = stack.pop();
        if (top != leftOf(ch))
          // 和最近的左括号不匹配
          return false;
      }
    }
    // 是否所有的左括号都被匹配了
    return stack.empty();
  }

  char leftOf(char c) {
    if (c == '}') return '{';
    if (c == ')') return '(';
    return '[';
  }



}
