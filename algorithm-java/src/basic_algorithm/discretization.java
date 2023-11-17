package basic_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class discretization {

    static int N = 300010; // 因为有n个和2m个数字 一共300000
    static List<Integer> alls = new ArrayList<>(); // 离散化数组
    static int[] a = new int[N]; // 记录添加c

    public static void main(String[] args) {
        
        /**
         * 假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。
         * 现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。
         * 接下来，进行 m 次询问，每个询问包含两个整数 l 和 r ，你需要求出在区间 [l,r]之间的所有数的和。
         * 
         * 数据范围 −10^9 ≤ x ≤ 10^9,
         * 1 ≤ n, m ≤ 105,
         * −10^9 ≤ l ≤ r ≤ 10^9,
         * −10000 ≤ c ≤ 10000
         * 
         * 输入样例
         * 3 3
         * 1 2
         * 3 6
         * 7 5
         * 1 3
         * 4 6
         * 7 8
         * 
         * 输出样例
         * 8
         * 0
         * 5
         */

         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
         int m = sc.nextInt();

         List<Node> add = new ArrayList<>(); // 记录n次添加
         List<Node> query = new ArrayList<>(); // 记录m次查询

         while (n-- > 0) {
            
            int k = sc.nextInt();
            int c = sc.nextInt();

            add.add(new Node(k, c));
            alls.add(k);

         }

         while (m-- > 0) {
            
            int l = sc.nextInt();
            int r = sc.nextInt();

            query.add(new Node(l, r));
            alls.add(l);
            alls.add(r);

         }

         Collections.sort(alls);
         int unique = unique();
         alls.subList(0, unique);

         for (Node node : add) {

            int k = find(node.first);
            a[k] += node.second;
         }

         for (int i = 1; i <= alls.size(); i++) {
            a[i] += a[i - 1];
         }

         for (Node node : query) {

            int l = find(node.first);
            int r = find(node.second);

            System.out.println(a[r] - a[l - 1]);
         }


    }

    public static int find(int t) {

        int l = 0;
        int r = alls.size() - 1;

        while (l < r) {

            int mid = (l + r) >> 1;

            if (alls.get(mid) >= t) r = mid;
            else l = mid + 1;
        }

        return l + 1;
    }

    public static int unique() {

        int j = 0;
        for (int i = 0; i < alls.size(); i++) {
            
            if (i == 0 || !alls.get(i).equals(alls.get(j - 1))) {
                alls.set(j, alls.get(i));
                j++;
            }
        }

        return j;
    }
}

class Node {

    public int first;
    public int second;

    public Node(int first, int second) {
        
        this.first = first;
        this.second = second;
    }
}
