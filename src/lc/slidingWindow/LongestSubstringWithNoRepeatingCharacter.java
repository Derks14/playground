package lc.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeatingCharacter {

    public int longestSubstringWithNoCharAppearingTwice(String s) {
        int i = 0;
        int best = 0;
        Map<Character, Integer> windowState = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            // absorb and move right
            char ch = s.charAt(j);
            windowState.put(ch, windowState.getOrDefault(ch, 0) + 1);

            while (windowState.get(ch) > 1) {
                // we taking one occurence out of the window and increment our i/left by 1.
                char out  = s.charAt(i);
                windowState.put(ch, windowState.get(ch) - 1);
                i++;
            }

            // keep comparing and saving the longest substring after every iteration
            best = Math.max(best, j - i + 1);
        }

        return best;
    }

    public int fixedMaximum(int[] array, int k) {
        int best = 0;
        int windowState = 0;

        //build your initial window
        for (int i = 0; i < k; i++) {
            windowState += array[i];
        }

        best = windowState;

        // slide through the array like a surfer
        for (int j = k; j < array.length; j++) {
            // in
            windowState += array[j];
            // out
            windowState -= array[j - k];

            // calculate best
            best = Math.max(best, windowState);
        }

        return best
    }

    public static void main(String[] args) {
    }
}
