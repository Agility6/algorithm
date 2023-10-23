package basic_algorithm;

import java.util.Scanner;

public class hash_table {

    static int N = 100003;
    static int index = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    
    public static void main(String[] args) {
        
        /**
         * 拉链法
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

        for (int i = 0; i < N; i++) h[i] = -1; 
        
        while (n-- > 0) {

            String x = sc.next();
            int t = sc.nextInt();

            if (x.equals("I")) insert(t);
            else {
                if (find(t)) System.out.println("Yes");
                else System.out.println("No");
            }
                
        }
    }

    public static void insert(int x) {

        int k = (x % N + N) % N;
        
        e[index] = x;
        ne[index] = h[k];
        h[k] = index++;
    }

    public static boolean find(int x) {

        int k = (x % N + N) % N;

        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) return true;
        }

        return false;
    }

}
