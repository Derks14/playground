package dsa;

import java.util.Arrays;

public class MergeSort {
    // time complexity - O(nlogn)
    // space complexity - o(n)
    public static void mergeSort(int[] array) {
        // cover the base case
        if (array == null || array.length <= 1) return;

        //recursive case - dividing the arrays
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);

    }

    public static void merge(int[] left, int[] right, int[] original) {
        int i = 0;  // left pointer
        int j = 0; // right pointer
        int k = 0; // original pointer

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                original[k++] = left[i++];
            else
                original[k++] = right[j++];

        }

        while(i < left.length) {
            original[k++] = left[i++];
        }

        while (j < right.length) {
            original[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 53, 3, 9, 81, 10, 42, 78};
        mergeSort(array);
        System.out.println("our array sorted using merge sort: " + Arrays.toString(array));
    }

}
