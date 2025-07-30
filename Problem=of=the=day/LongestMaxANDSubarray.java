/*
 * Problem: Longest Subarray With Maximum Bitwise AND
 *
 * Given an integer array nums, find the maximum possible value of the bitwise AND
 * across all subarrays, and return the length of the longest subarray with that value.
 *
 * A subarray is a contiguous portion of the array.
 *
 * Example:
 * Input: nums = [1, 2, 3, 3, 2, 3, 3]
 * Output: 2
 * Explanation:
 * - Maximum bitwise AND value is 3 (from subarrays like [3], [3, 3]).
 * - The longest subarray with AND == 3 is of length 2 ([3, 3]).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LongestMaxANDSubarray {

    public static int longestSubarray(int[] nums) {
        int max = 0;

        // Step 1: Find the maximum element
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Step 2: Find the longest subarray where all elements == max
        int longest = 0, count = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 0;
            }
        }

        return longest;
    }

    // Sample driver code
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 3, 3};
        System.out.println("Longest Subarray Length = " + longestSubarray(nums));
    }
}
