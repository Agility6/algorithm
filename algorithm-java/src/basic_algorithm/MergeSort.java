package basic_algorithm;

/**
 * ClassName: MergeSort
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-17
 * @Version 1.0
 */
public class MergeSort {
  public void merge_sort(int[] arr, int left, int right) {
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

