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
  public void quick_sort(int[] arr, int left, int right) {

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
