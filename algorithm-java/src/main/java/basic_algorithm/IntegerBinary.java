package basic_algorithm;

/**
 * ClassName: IntegerDichotomy
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class IntegerBinary {

  // 伪代码
  public static int binary_1(int left, int right) {
    while (left < right) {
      int mid = (right + left) >> 1;
      // check为判断条件
      if (check(mid)) right = mid;
      else left = mid + 1;
    }
    return left;
  }

  public static int binary_2(int left, int right) {
    while(left < right) {
      int mid = (left + right + 1) >> 1;
      // check为判断条件
      if (check(mid)) left = mid;
      else right = mid - 1;
    }
    return left;
  }

}
