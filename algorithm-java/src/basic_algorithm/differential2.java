package basic_algorithm;

import java.util.Scanner;

public class differential2 {
    /**
     * 输入一个 n 行 m 列的整数矩阵，再输入 q 个操作，每个操作包含五个整数 x1,y1,x2,y2,c
     * 其中 (x1,y1) 和 (x2,y2) 表示一个子矩阵的左上角坐标和右下角坐标。
     * 每个操作都要将选中的子矩阵中的每个元素的值加上 c
     * 
     * 输入
     * 3 4 3 
     * 1 2 2 1 
     * 3 2 2 1 
     * 1 1 1 1 
     * 1 1 2 2 1 
     * 1 3 2 3 2 
     * 3 1 3 4 1
     * 
     * 输出
     * 2 3 4 1
     * 4 3 4 1
     * 2 2 2 2
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] nums = new int[n + 2][m + 2];
        int[][] s = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(s, i, j, i, j, nums[i][j]);
            }
        }

        while (q-- > 0) {
            
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();

            insert(s, x1, y1, x2, y2, c);
        } 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i -1][j - 1];
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void insert(int[][] nums, int x1, int y1, int x2, int y2, int c) {

        nums[x1][y1] += c;
        nums[x2 + 1][y1] -= c;
        nums[x1][y2 + 1] -= c;
        nums[x2 + 1][y2 + 1] += c;
    }
}
