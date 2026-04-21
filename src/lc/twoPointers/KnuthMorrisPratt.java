package lc.twoPointers;

import java.time.Instant;
import java.util.Arrays;

public class KnuthMorrisPratt {

    // method to compute the Longest prefix suffix

    public static int[] longestPrefixSuffix(String pattern) {

        int[] lps = new int[pattern.length()]; // the lps table we will return
        lps[0] = 0; // the first character of every lps is always 0

        int len = 0; // tracks the length of the previous longest prefix suffix
        int i = 1; // we start analyzing from the second character


        while (i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                // if theres a match we increment length(len++) and move forward (i++)

                lps[i++] = ++len;

            } else {
                // if there's a mismatch

                if (len > 0) {
                    len = lps[len - 1]; // this only runs, the while loop stays still
                } else {
                    lps[i++] = 0; // if no match is possible, the value is 0 (lps[i] = 0) and we move forward
                }
            }

        }
        return lps;
    }


    public static int findTheFirstOccurrence(String haystack, String needle) {
        if (haystack.isEmpty() || needle.isEmpty()) return 0;

        // first find the lps of the pattern
        int[] lps = longestPrefixSuffix(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) { // there was a match here
                i++; j++;

                if (j == needle.length()) {
                    // we have matched the full length of needle string

                    return i - j;
                }
            } else {                // we have arrived at a mismatch

                if (j > 0) { // but we were on a pattern match
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }


        return 0;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(longestPrefixSuffix("abcdabeabf")));
//        System.out.println(Arrays.toString(longestPrefixSuffix("abcdeabfabc")));
//        System.out.println(Arrays.toString(longestPrefixSuffix("aabcadaabe")));
//        System.out.println(Arrays.toString(longestPrefixSuffix("aaaabaacd")));

        System.out.println(Instant.now().plusSeconds(3600 - 60).isAfter(Instant.now()));
    }
}
