package basic_algorithm;

import java.util.Scanner;

/**
 * ClassName: FloatBinary
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-19
 * @Version 1.0
 */
public class floatBinary {
  
   public static void main(String[] args) {
        
        /**
         * 给定一个浮点数n，求它的三次方根
         * 
         * 数据范围
         * -10000 <= n <= 10000
         * 
         * 输入样例
         * 1000.00
         * 
         * 输出样例
         * 10.000000
         */

        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();

        double i = -1000;
        double j = 1000;

        while (j - i > 1e-8) {
            
            double mid = (j + i) / 2;
            if (mid * mid * mid >= n) j = mid;
            else i = mid;
        }

        System.out.printf("%.6f\n", i);
    }
}
