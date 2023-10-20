package basic_algorithm;

import java.util.Scanner;

public class disjoint_set {

    static int N = 100010;
    static int[] p = new int[N];

    
    public static void main(String[] args) {
        
        /**
         * 一共有 n 个数，编号是 1∼n ，最开始每个数各自在一个集合中。
         * 现在要进行 m 个操作，操作共有两种：
         * M a b，将编号为 a 和 b 的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
         * Q a b，询问编号为 a 和 b 的两个数是否在同一个集合中；
         * 
         * 
         * 输入样例
         * 4 5
         * M 1 2
         * M 3 4
         * Q 1 2
         * Q 1 3
         * Q 3 4
         * 
         * 输出样例
         * Yes
         * No
         * Yes
         * 
         */

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) p[i] = i; 

        while (m-- > 0) {

            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (s.equals("M")) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int find(int x) {
        
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
