import java.util.Arrays;

public class Sprint_3_K_MergeSort {
// таки и не понял что надо сделать ))
    public static void main(String[] args) {
        int[] test = new int[]{4, 5, 3, 0, 1, 2};
        merge_sort(test, 0, 4);
        System.out.println(Arrays.toString(test));
        int[] testMerge = new int[]{4, 5, 3, 0, 2, 1};
        // {3,4,5,0,1,2}
        System.out.println(Arrays.toString(merge(testMerge, 0, 3, 5)));
    }

    public static int[] merge(int[] arr, int left, int mid, int right) {
        // массив отсортированный приходит ли нет ? из условия непонятно
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);
        return arr;
    }


    public static void merge_sort(int[] arr, int left, int right) {
        int length = right - left;
        int[] array = new int[length];
        int count = 0;
        // иди так
        // int[] left = mergeSort(Arrays.copyOfRange(array, left, right));
        for (int i = left; i < right; i++) {
            array[count] = arr[i];
            count++;
        }
        Arrays.sort(array);
        count = 0;
        for (int i = left; i < right; i++) {
            arr[i] = array[count];
            count++;
        }
    }
}
