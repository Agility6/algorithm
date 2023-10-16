package basic_algorithm;

import java.util.Scanner;

public class KMP {
    public static void main(String[] args) {
        
        /**
         * 第一行输入整数 N，表示字符串 P 的长度。
         * 第二行输入字符串 P。
         * 第三行输入整数 M，表示字符串 S的长度。
         * 第四行输入字符串 S。
         * 
         * 输入样例
         * 3
         * aba
         * 5
         * ababa
         * 
         * 输出样例
         * 0 2
         */

        Scanner sc = new Scanner(System.in);

        /** 从1开始 */
        int n = sc.nextInt();
        String s1 = " " + sc.next();

        int m = sc.nextInt();
        String s2 = " " + sc.next();

        char[] p = s1.toCharArray();
        char[] s = s2.toCharArray();

        int[] ne = new int[n + 1];

        for (int i = 2, j = 0; i <= n; i++) {
            
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];

            if (p[i] == p[j + 1]) j++;

            ne[i] = j;
        }

        String res = "";

        for (int i = 1, j = 0; i <= m; i++) {
           
            while (j > 0 && s[i] != p[j + 1]) j = ne[j];

            if (s[i] == p[j + 1]) j++;

            if (j == n) {
                j = ne[j];
                res += i - n + " ";
            }
        }

        System.out.println(res.substring(0, res.length() - 1));
        
    }
}
