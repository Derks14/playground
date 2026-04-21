package lc.twoPointers;

import java.util.concurrent.locks.Condition;

public class Engine {

    public static int[] twoSum(int[] array, int target) {
        // set up the two pointers { indexes with one moving from left and other moving from right }
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            // computing the array
            int sum = array[i] + array[j];

            if (sum == target) return new int[]{array[i], array[j]};

            else if (sum < target) i++;
            else j--;
        }
        return null;

    }


//    general template
    public static int fastSlow(int[] array) {
        int slow = 0;
        int fast = 0; // this can start at 1 - depends on the problem

        while ( fast < array.length) {
//            if (CONDITION(array[slow], array[fast])) {
//                // meaningful event - do work, then advance slow
//
//
//
//                // do something here with your three values, (array, slow, fast ) ( write, swap, record )
//                slow++;
//            }

            fast++;  // moves fast unconditionally every single iteration
        }

        return slow++; // slow is the boundary - valid region is [0....slow]
        // slow++ will return the actual size of the array, thats what we looking for;
    }
}
