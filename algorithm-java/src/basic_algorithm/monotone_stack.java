package basic_algorithm;

import java.util.Scanner;

public class monotone_stack {

    static int N = 1000010;
    static int tt = 0;
    static int[] stk = new int[N];
    
    public static void main(String[] args) {
        
        /**
         * 给定一个长度为 N的整数数列
         * 输出每个数左边第一个比它小的数，如果不存在则输出 −1。
         * 
         * 输入样例
         * 5
         * 3 4 2 7 5
         * 
         * 输出样例
         * -1 3 -1 2 2
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();

            while (tt != 0 && stk[tt] >= nums[i]) tt--;
            
            if (tt != 0) System.out.print(stk[tt] + " ");
            else System.out.print("-1 ");

            stk[++tt] = nums[i];
        }
        
    }

}
