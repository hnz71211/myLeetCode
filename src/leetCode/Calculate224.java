package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: Calculate224
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/10
 **/
public class Calculate224 {

  public int calculate(String s) {

    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      queue.offer(s.charAt(i));
    }

    return helper(queue);
  }

  int helper(Queue<Character> queue) {
    Stack<Integer> stk = new Stack<>();
    // 记录算式中的数字
    int num = 0;
    // 记录num前的符号，初始化为+
    char sign = '+';

    while (queue.size() > 0) {
      char c = queue.poll();
      // 如果是数字，连续读取到num
      if (Character.isDigit(c))
        num = 10 * num + (c - '0');

      // 左括号开始递归计算
      if (c == '(')
        num = helper(queue);

      // 如果不是数字，就是遇到了下一个符号，之前的数字和符号就要存进栈中
      if ((!Character.isDigit(c) && c != ' ') || queue.size() == 0) {
        switch (sign) {
        case '+':
          stk.push(num);
          break;
        case '-':
          stk.push(-num);
          break;
        case '*':
          stk.push(stk.pop() * num);
          break;
        case '/':
          stk.push(stk.pop() / num);
          break;
        }
        // 更新符号为当前符号，数字清零
        sign = c;
        num = 0;
      }

      // 右括号递归结束
      if (c == ')')
        break;
    }
    int res = 0;
    while (!stk.empty()) {
      res += stk.pop();
    }
    return res;
  }

  public static void main(String[] args) {
    Calculate224 calculate224 = new Calculate224();
    System.out.println(calculate224.calculate("3 + (5 + 2)"));
  }

}
