package basic_algorithm;

import java.util.Scanner;

public class differential {
    /**
     * 输入一个长度为 n 的整数序列。
     * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c ，表示将序列中 [l,r]之间的每个数加上 c
     * 
     * 输入
     * 6 3 
     * 1 2 2 1 2 1
     * 1 3 1
     * 3 5 1
     * 1 6 1
     * 
     * 输出
     * 3 4 5 3 4 2
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        /**
         * 需要对差分数组进行构造
         * nums[r + 1] -= c; 需要扩容数组
         */
        int[] nums = new int[n + 2];
        int[] b = new int[n + 2]; // 差分数组

        for (int i = 1; i <= n; i++) {
           nums[i] = sc.nextInt(); 
        }

        for (int i = 1; i <= n; i++) {
            intset(b, i, i, nums[i]); // 构造差分数组
        }

        while (m-- > 0 ) {

            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            intset(b, l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            /**
             * 答案应该是b数组的前缀和
             * 因为nums[l] = b[1] + b[2] + ... + b[l] nums[l + 1] = b[1] + b[2] + ... + b[l + 1]
             * 求前缀和
             * a[1] = b[1] 
             * a[2] = b[1] + b[2] = a[1] + b[2]
             * 得 a[i] = a[i - 1] + b[i]
             */
            nums[i] = nums[i - 1] + b[i];
            System.out.print(nums[i] + " ");
        }
    }

    public static void intset(int[] nums, int l, int r, int c) {
        nums[l] += c;
        nums[r + 1] -= c;
    }
}
