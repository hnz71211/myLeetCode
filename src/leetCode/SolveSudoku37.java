package leetCode;

/**
 * @ClassName: SolveSudoku37
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/8
 **/
public class SolveSudoku37 {

  public void solveSudoku(char[][] board) {

    backtrack(board, 0, 0);

  }

  private boolean backtrack(char[][] board, int i, int j) {
    int m = 9, n = 9;

    if (j == n) {
      // 穷举到最后一列的话就换到下一行重新开始。
      return backtrack(board, i + 1, 0);
    }
    if (i == m) {
      // 找到一个可行解
      return true;
    }

    // 如果该位置是预设的数字，跳过
    if (board[i][j] != '.') {
      return backtrack(board, i, j + 1);
    }

    for (char ch = '1'; ch <= '9'; ch++) {
      if (!isValid(board, i, j, ch))
        continue;

      board[i][j] = ch;
      if (backtrack(board, i, j + 1)) {
        return true;
      }
      board[i][j] = '.';
    }
    return false;
  }

  private boolean isValid(char[][] board, int row, int col, char ch) {
    for (int i = 0; i < 9; i++) {
      // 判断行是否存在重复
      if (board[row][i] == ch) return false;
      // 判断列是否存在重复
      if (board[i][col] == ch) return false;
      // 判断 3 x 3 方框是否存在重复
      if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == ch)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "53..7....6..195....98....6.8...6...34..8.3..17...2...6.6....28....419..5....8..79";
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = s.charAt(i * 9 + j);
      }
    }

    SolveSudoku37 solveSudoku37 = new SolveSudoku37();
    solveSudoku37.solveSudoku(board);
    System.out.println();
  }

}
