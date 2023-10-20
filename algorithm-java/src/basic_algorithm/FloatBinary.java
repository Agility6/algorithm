package basic_algorithm;

/**
 * ClassName: FloatBinary
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-19
 * @Version 1.0
 */
public class floatBinary {
  public static double binary(double l, double r) {

    // eps 表示精度
    double eps = 1e-6;

    while (r - l > eps) {
      double mid = (l + r) / 2;
      // check为判断条件
      if (check(mid)) r = mid;
      else l = mid;
    }

    return l;
  }

  private static boolean check(double arg) {
    return true;
  }

}
