package basic_algorithm;

import java.util.Scanner;

public class prefixesSum2 {
    /**
     * 输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。
     * 
     * 数据范围
     * 1≤n,m≤1000
     * 1≤q≤200000
     * 1≤x1≤x2≤n
     * 1≤y1≤y2≤m
     * −1000≤矩阵内元素的值≤1000
     * 
     * 输入
     * 3 4 3
     * 1 7 2 4
     * 3 6 2 8
     * 2 1 2 3
     * 1 1 2 2
     * 2 1 3 4
     * 1 3 3 4
     * 
     * 输出
     * 17
     * 27
     * 21
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] nums = new int[n +1][m + 1];
        int[][] s = new int[n + 1][m + 1]; // 二位前缀数组

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + nums[i][j];
            }
        }

        while (q-- > 0) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]);
        }
    }
}
