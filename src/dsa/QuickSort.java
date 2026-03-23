package dsa;

import java.util.Arrays;

public class QuickSort {

//    quick sort = moves smaller elements to left of a pivot
//    recursively divide array in 2 partitions

//    run-time complexity = Best case O(nlog(n))
//                          average case O(nlog(n))
//                          works case O(nlog(n))
///
//     space complexity = O(log(n)) due to recursion

    public static void quickSort(int[] array, int start, int end) {
        // base case
        if (end <= start) return;

        int pivot = partition(array, start, end);

        quickSort(array, 0, pivot -1);
        quickSort(array, pivot+ 1,  end);
    }

    public static int partition(int[] array,int start, int end) {
        int i = start - 1;
        int j = start;
        int pivot = array[end];


        while (j <= end) {
            if (array[j] < pivot) {

                i++;
                int temp = array[i];

                array[i] = array[j];
                array[j] = temp;
            }
            j++;
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;

//        returning the final resting place of the pivot
    }


    public static void main(String[] args) {
        int[] array = {38, 27, 53, 3, 9, 81, 10, 42, 78};

        quickSort(array, 0, array.length - 1);

        System.out.println("our sorted array: " + Arrays.toString(array));
    }
}


// partition
// quick sort ( left  )
// quick sort ( right )

//partition
// pivot, start, j
// while j < end
// swap i and j of j less than pivot and increment i
// increment j
// increment i
//and swap original pivot position and return i

