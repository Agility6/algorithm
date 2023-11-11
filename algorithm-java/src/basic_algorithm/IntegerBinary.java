package basic_algorithm;

import java.util.Scanner;

/**
 * ClassName: IntegerDichotomy
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class integerBinary {

    public static void main(String[] args) {

        /**
         * 给定一个按照升序排列的长度为n的整数数组，以及q个查询
         * 对于每个查询，返回一个元素k的起始位置和终止位置（从0开始）
         * 如果数组不存在该元素返回 -1 -1
         * 
         * 数据范围
         * 1 <= n <= 100000
         * 1 <= q <= 10000
         * 1 <= k <= 10000
         * 
         * 输入样例
         * 6 3
         * 1 2 2 3 3 4
         * 3
         * 4
         * 5
         * 
         * 输出样例
         * 3 4
         * 5 5
         * -1 -1
         */

         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
         int q = sc.nextInt();

         int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        

        while (q-- > 0) {
            int t = sc.nextInt();


            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                
                int mid = left + right >> 1;
                if (nums[mid] >= t) right = mid;
                else left = mid + 1;

            }

            System.out.print(left + " ");

            left = 0;
            right = nums.length - 1;

            while (left < right) {
                
                int mid = left + right + 1 >> 1;
                if (nums[mid] <= t) left = mid;
                else right = mid - 1;
            }

            System.out.println(left);
        }

    }

}
