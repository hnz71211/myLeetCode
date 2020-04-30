package sort;

import sort.insertion.Insertion;
import sort.merge.Merge;
import sort.quick.Quick;
import sort.selection.Selection;
import sort.shell.Shell;

import java.util.Arrays;

/**
 * @ClassName: TestMain
 * @Description:
 * @Author: hexli
 * @Date: 2020/4/30
 **/
public class TestMain {

  public static void main(String[] args) {

    int[] a = new int[]{36, 20, 17, 13, 28, 14, 23, 15, 16, 21, 29, 30, 12, 41, 35};

    Insertion insertion = new Insertion();
//    insertion.sort(a);

    Selection selection = new Selection();
//    selection.sort(a);

    Shell shell = new Shell();
//    shell.sort(a);

    Merge merge = new Merge();
//    merge.sort(a);

    Quick quick = new Quick();
    quick.sort(a);

    print(a);
  }

  private static void print(int[] array) {
    System.out.println(Arrays.toString(array));
  }

}
