package basic_algorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class IntervalMerging {
    public static void main(String[] args) {
        
    }

    /**
     * 将所有存在交集的区间合并
     * 输出区间合并之后的总数
     * int[0]存左端点 int[1]存右端点 
     * @param list
     */
    public static void merge(ArrayList<int []> list) {

        // 1. 对列表中每个数组0位置元素升序排序
        list.sort(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        int r = Integer.MIN_VALUE;
        for (int a[] : list) {
            
            // 下一个区间的左端点大于当前区间的右端点，res++
            if (a[0] > r) res++;
            else r = Math.max(r, a[1]); // 否则更新右端点
        }

        System.out.println(res);
    }

    /**
     * 将每个合并区间添加到一个新列表中
     * @param list
     * @return
     */
    public static int merge2(ArrayList<int[]> list) {
        
        ArrayList<int []> res = new ArrayList<>();

        list.sort(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; 
            }
        });

        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;

        for (int[] a : list) {
            if (a[0] > r) {
                // 特判初始化情况
                if (l != Integer.MIN_VALUE) {
                    res.add(new int[] {l, r});
                }
                l = a[0];
                r = a[1];
            } else {
                r = Math.max(a[1], r);
            }
        }

        // 手动将最后一个区间添加到res中
        if (l != Integer.MIN_VALUE) {
            res.add(new int[] {l, r});
        }

        return res.size();
    }
}
