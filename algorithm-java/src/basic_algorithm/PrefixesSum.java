package basic_algorithm;

import java.util.Scanner;

public class PrefixesSum {
    /**
     * 输入一个长度为 n 的整数序列。接下来再输入 m 个询问，每个询问输入一对 l,r。
     * 对于每个询问，输出原序列中从第 l 个数到第 r 个数的和。
     * 数据范围 1≤l≤r≤n,1≤n,m≤100000,−1000≤数列中元素的值≤1000
     * 
     * 输入
     * 5 3
     * 2 1 3 6 4
     * 1 2
     * 1 3
     * 2 4
     * 
     * 输出
     * 3
     * 6
     * 10
     */

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n + 1];
        int[] s = new int[n + 1]; // 前缀和数组

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + nums[i];
        }

        while (m-- > 0) {

            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(s[r] - s[l - 1]);
        } 
    }
}
