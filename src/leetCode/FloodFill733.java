package leetCode;

/**
 * @ClassName: FloodFill733
 * @Description:
 * @Author: hexli
 * @Date: 2020/6/11
 **/
public class FloodFill733 {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int origColor = image[sr][sc];
    fill(image, sr, sc, origColor, newColor);
    return image;
  }

  void fill(int[][] image, int x, int y, int origColor, int newColor) {
    if (!inArea(image, x, y))
      return;
    // 判断image[x][y] == newColor，避免大量重复递归
    if (image[x][y] != origColor || image[x][y] == newColor)
      return;

    image[x][y] = newColor;
    fill(image, x - 1, y, origColor, newColor);
    fill(image, x + 1, y, origColor, newColor);
    fill(image, x, y - 1, origColor, newColor);
    fill(image, x, y + 1, origColor, newColor);
  }

  boolean inArea(int[][] image, int x, int y) {
    return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
  }

  public static void main(String[] args) {
    int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int sr = 1;
    int sc = 1;
    int newColor = 2;

    FloodFill733 floodFill733 = new FloodFill733();

    image = floodFill733.floodFill(image, sr, sc, newColor);

    System.out.println();
  }

}
