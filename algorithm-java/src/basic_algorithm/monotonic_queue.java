package basic_algorithm;

import java.util.Scanner;

public class monotonic_queue {
    
    static int N = 1000010;
    static int[] q = new int[N];

    public static void main(String[] args) {
        
        /**
         * 给定一个大小为 n ≤ 106的数组。有一个大小为 k的滑动窗口
         * 它从数组的最左边移动到最右边。你只能在窗口中看到 k 个数字。
         * 每次滑动窗口向右移动一个位置。
         * 
         * 输入样例
         * 8 3
         * 1 3 -1 -3 5 3 6 7
         * 
         * 输出样例
         * -1 -3 -3 -3 3 3
         * 3 3 5 5 6 7
         */

         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        int hh = 0;
        int tt = -1;

        for (int i = 0; i < nums.length; i++) {

            nums[i] = sc.nextInt();
            
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] >= nums[i]) tt--;

            q[++tt] = i;
            
            if (i + 1 >= k) System.out.print(nums[q[hh]] + " ");
        }

        System.out.println();

        hh = 0;
        tt = -1;
        for (int i = 0; i < nums.length; i++) {

            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;

            q[++tt] = i;
            
            if (i + 1 >= k) System.out.print(nums[q[hh]] + " ");
        }

    }
}
