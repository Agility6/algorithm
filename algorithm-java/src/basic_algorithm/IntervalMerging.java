package basic_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class intervalMerging {
    public static void main(String[] args) {
        
        /**
         * 给定 n 个区间 [li,ri] ，要求合并所有有交集的区间。
         * 注意如果在端点处相交，也算有交集。输出合并完成后的区间个数。
         * 例如：[1,3] 和 [2,6] 可以合并为一个区间 [1,6]。
         * 
         * 数据范围
         * 1 ≤ n ≤ 100000,
         * −10^9 ≤ li ≤ ri ≤ 10^9
         * 
         * 输入样例
         * 5
         * 1 2
         * 2 4
         * 5 6
         * 7 8
         * 7 9
         * 
         * 输出样例
         * 3
         */

         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();

         List<int[]> nums = new ArrayList<>();

         while (n-- > 0) {

            int l = sc.nextInt();
            int r = sc.nextInt();

            nums.add(new int[] {l, r});
         }

         System.out.println(merge(nums));
    }

    public static int merge(List<int[]> nums) {

        nums.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;

        List<int[]> res = new ArrayList<>();

        for (int[] arr : nums) {

            if (arr[0] > r) {

                if (l != Integer.MIN_VALUE) res.add(new int[] {l, r});
                l = arr[0];
                r = arr[1];

            } else {
                r = Math.max(r, arr[1]);
            }
        }

        if (l != Integer.MIN_VALUE) res.add(new int[] {r, l});

        return res.size();
    }

}
