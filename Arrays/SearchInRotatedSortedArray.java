/*
 🔹 Question: Search in Rotated Sorted Array
 🔹 LeetCode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

 🔹 Description:
    Given a sorted array that has been rotated at some pivot unknown to you beforehand,
    and a target value, return the index of the target if it is in the array, otherwise return -1.

    You must solve it in O(log n) time using binary search.

 🔹 Example:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

 🔹 Approach:
    - Perform binary search with modifications:
      1. Check if the left half is sorted.
         - If target lies within that half, adjust `high = mid - 1`
         - Else search right: `low = mid + 1`
      2. If right half is sorted:
         - If target lies within that half, adjust `low = mid + 1`
         - Else search left: `high = mid - 1`

 🔹 Time Complexity: O(log n)
 🔹 Space Complexity: O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // If left part is sorted
        if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) {
                high = mid - 1;  // Search in the left part
            } else {
                low = mid + 1;   // Search in the right part
            }
        }
        // If right part is sorted
        else {
            if (nums[mid] < target && target <= nums[high]) {
                low = mid + 1;  // Search in the right part
            } else {
                high = mid - 1; // Search in the left part
            }
        }
    }
    return -1;  // If the target is not found
}

}
