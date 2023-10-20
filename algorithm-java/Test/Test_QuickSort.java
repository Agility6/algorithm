import basic_algorithm.quickSort;
import util.commonUtil;

public class Test_QuickSort {
    public static void main(String[] args) {

        int[] arr1 = {9,8,7,6,5,4,3,2,1};
        int[] arr2 = {9,8,7,6,5,4,3,2};
        int[] arr3 = {1,1,1};
        int[] arr4 = {1,1,1,1};

        quickSort qs = new quickSort();

        qs.quick_sort(arr1, 0, arr1.length - 1);
        commonUtil.printArrays(arr1);

        qs.quick_sort(arr2, 0, arr2.length - 1);
        commonUtil.printArrays(arr2);

        qs.quick_sort(arr3, 0, arr3.length - 1);
        commonUtil.printArrays(arr3);

        qs.quick_sort(arr4, 0, arr4.length - 1);
        commonUtil.printArrays(arr4);
    }
}
