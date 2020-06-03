package backtrack;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Bracket
 * @Description:
 *    输入是一个正整数 n，输出是 n 对儿括号的所有合法组合.
 *    比如说，输入 n=3，输出为如下 5 个字符串：
 *    "((()))", "(()())", "(())()", "()(())", "()()()"
 *    问题可以有另一个问法：
 *    现在有 2n 个位置，每个位置可以放置字符 ( 或者 )，组成的所有括号组合中，有多少个是合法的？
 *
 *    关于括号问题的性质：
 *      1、一个「合法」括号组合的左括号数量一定等于右括号数量；
 *      2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
 *
 *    回溯思路：
 *      result = []
 *      def backtrack(路径, 选择列表):
 *        if 满足结束条件:
 *          result.add(路径)
 *          return
 *      for 选择 in 选择列表:
 *        做选择
 *        backtrack(路径, 选择列表)
 *        撤销选择
 *
 * @Author: hexli
 * @Date: 2020/6/3
 **/
public class Bracket {

  List<String> generateParenthesis(int n) {
    if (n == 0) return Collections.emptyList();

    List<String> res = new ArrayList<>();
    // 回溯过程中的路径
    List<String> track = new ArrayList<>();
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, track, res);
    return res;
  }

  // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
  void backtrack(int left, int right, List<String> track, List<String> res) {
    if (right < left) return;
    if (left < 0 || right < 0)  return;
    if (left == 0 && right == 0) {
      // 符合条件加入结果集
      res.add(StringUtils.join(track, ""));
    }

    // 尝试放一个左括号
    track.add("(");
    backtrack(left - 1, right, track, res);
    track.remove(track.size() - 1);

    // 尝试放一个右括号
    track.add(")");
    backtrack(left, right - 1, track, res);
    track.remove(track.size() - 1);
  }

  public static void main(String[] args) {
    Bracket bracket = new Bracket();
    List<String> res = bracket.generateParenthesis(3);
    System.out.println();
  }
}
