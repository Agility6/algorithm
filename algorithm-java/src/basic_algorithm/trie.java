package basic_algorithm;

import java.util.Scanner;

public class trie {

    static int N = 100010;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];
    static int index = 0;

    public static void main(String[] args) {
        
        /**
         * 维护一个字符串集合，支持两种操作：
         * I x 向集合中插入一个字符串 x
         * Q x 询问一个字符串在集合中出现了多少次
         * 
         * 共有 N 个操作，所有输入的字符串总长度不超过 105 ，字符串仅包含小写英文字母。
         * 
         * 输入样例
         * 5
         * I abc
         * Q abc
         * Q ab
         * I ab
         * Q ab
         * 
         * 输入样例
         * 1
         * 0
         * 1
         */


        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        while (n-- > 0) {
            
            String s = sc.next();
            String str = sc.next();

            if (s.equals("I")) insert(str);
            else System.out.println(query(str));
        }

         
    }

    public static void insert(String str) {
        
        int p = 0;
        
        for (int i = 0; i < str.length(); i++) {
           
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++index;
            p = son[p][u];
        }
        
        cnt[p]++;
    }

    public static int query(String str) {

        int p = 0;

        for (int i = 0; i < str.length(); i++) {
            
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }

        return cnt[p];
    }
}
