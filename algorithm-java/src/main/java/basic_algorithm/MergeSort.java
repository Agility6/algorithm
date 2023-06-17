package basic_algorithm;

import basic_algorithm.util.commonUtil;

import static basic_algorithm.MergeSort.merge_sort;
import static basic_algorithm.QuickSort.quick_sort;

/**
 * ClassName: MergeSort
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class MergeSort {
  public static void merge_sort(int[] arr, int left, int right) {
    if (left >= right) return;

    int mid = (left + right) >> 1;
    merge_sort(arr, left, mid);
    merge_sort(arr, mid + 1, right);

    int i = left;
    int j = mid + 1;
    int k = 0;
    int [] temp = new int[right - left + 1];

    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) temp[k++] = arr[i++];
      else temp[k++] = arr[j++];
    }

    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    for (i = left, j = 0; i <= right; i++, j++) {
      arr[i] = temp[j];
    }
  }
}

class Test_MergeSort{
  public static void main(String[] args) {
    int[] arr1 = {9,8,7,6,5,4,3,2,1};
    int[] arr2 = {9,8,7,6,5,4,3,2};
    int[] arr3 = {1,1,1};
    int[] arr4 = {1,1,1,1};

    merge_sort(arr1, 0, arr1.length - 1);
    commonUtil.printArrays(arr1);

    merge_sort(arr2, 0, arr2.length - 1);
    commonUtil.printArrays(arr2);

    merge_sort(arr3, 0, arr3.length - 1);
    commonUtil.printArrays(arr3);

    merge_sort(arr4, 0, arr4.length - 1);
    commonUtil.printArrays(arr4);
  }
}
