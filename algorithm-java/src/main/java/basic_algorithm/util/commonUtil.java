package basic_algorithm.util;

/**
 * ClassName: commonUtil
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class commonUtil {
  public static void printArrays(int [] arr) {
    if (arr.length <= 0) {
      System.out.println("Arrays length <= 0");
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
