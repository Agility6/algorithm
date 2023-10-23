package basic_algorithm;

import java.util.Scanner;

public class hash_table2 {

    static int N = 200003;
    static int[] h = new int[N];
    static int nulls = 0x3f3f3f3f;
    
    public static void main(String[] args) {
        
        /**
         * 开放寻址法
         * 
         * 维护一个集合
         * I x 插入一个整数x
         * Q x 询问整数x是否在集合中出现过
         * 
         * 数据范围
         * 1 ≤ N ≤ 105
         * −109 ≤ x ≤ 109
         * 
         * 输入样例
         * 5
         * I 1
         * I 2
         * I 3
         * Q 2
         * Q 5
         * 
         * 输出样例
         * Yes
         * No
         */

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        for (int i = 0; i < N; i++) h[i] = nulls;
        
        while (n-- > 0) {
            
            String s = sc.next();
            int t = sc.nextInt();
            int k = find(t);

            if (s.equals("I")) h[k] = t;
            else {
                if (h[k] == t) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    public static int find(int x) {

        int k = (x % N + N) % N;
        
        while (h[k] != nulls & h[k] != x) {
            k++;
            if (k == N) k = 0;
        } 

        return k;
    }

}
