package basic_algorithm;

import basic_algorithm.util.commonUtil;

import java.lang.reflect.Array;

import static basic_algorithm.QuickSort.quick_sort;

/**
 * ClassName: QuickSort
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class QuickSort {
  public static void quick_sort(int[] arr, int left, int right) {

    if (left >= right) return;

    int pivot = arr[(left + right) >> 1];
    int i = left - 1;
    int j = right + 1;

    while (i < j) {
      do { i++; } while (arr[i] < pivot);
      do { j--; } while (arr[j] > pivot);

      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    quick_sort(arr, left, j);
    quick_sort(arr, j + 1, right);
  }
}

class Test_QuickSort{
  public static void main(String[] args) {
    int[] arr1 = {9,8,7,6,5,4,3,2,1};
    int[] arr2 = {9,8,7,6,5,4,3,2};
    int[] arr3 = {1,1,1};
    int[] arr4 = {1,1,1,1};

    quick_sort(arr1, 0, arr1.length - 1);
    commonUtil.printArrays(arr1);

    quick_sort(arr2, 0, arr2.length - 1);
    commonUtil.printArrays(arr2);

    quick_sort(arr3, 0, arr3.length - 1);
    commonUtil.printArrays(arr3);

    quick_sort(arr4, 0, arr4.length - 1);
    commonUtil.printArrays(arr4);
  }
}
