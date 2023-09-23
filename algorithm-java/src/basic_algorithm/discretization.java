package basic_algorithm;

import java.util.List;

public class discretization {
    public static void main(String[] args) {
        
    }

    /**
     * 数组去重
     * @param list
     * @return 
     */
    public static int unique(List<Integer> list) {

        for (int i = 1, j = 0; i < list.size(); i++) {
            
            while (j < list.size() && (j == 0 || list.get(i) == list.get(i - 1))) {
                j++;
            }

            if (j >= list.size()) {
                return j;
            }

            list.set(i, list.get(j));
            j++;
        }

        return -1;
    }

    /**
     * 二分求出x对应的离散化的值
     * @param x
     * @param list
     * @return
     */
    public static int find(int x, List<Integer> list) {

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }

        return r + 1; // 映射1, 2
    }

}

class Node {

    int first;
    int second;
    public Node(int x, int c) {
        this.first = x;
        this.second = c;
    }
}
