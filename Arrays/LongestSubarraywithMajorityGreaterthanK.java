📄 Description
Given an integer array arr[] and an integer k, find the length of the longest subarray in which the number of elements greater than k is strictly more than the number of elements less than or equal to k.

🧠 Approach
Transform the array:

Replace each element with:

+1 if the element is greater than k

-1 if the element is less than or equal to k

The problem now reduces to:

Find the longest subarray with a positive sum

Use prefix sums and a HashMap to efficiently track subarray lengths.
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[n];

        // Step 1: Convert array
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i] > k ? 1 : -1;
        }

        // Step 2: Prefix sum + HashMap
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += temp[i];

            // Case 1: if sum > 0, then from 0 to i is valid
            if (sum > 0) {
                maxLen = i + 1;
            }
            // Case 2: store first occurrence of sum
            else {
                // If (sum - 1) is seen before, we found a subarray with sum > 0
                if (map.containsKey(sum - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(sum - 1));
                }
            }

            // Store first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
📈 Complexity
Time Complexity: O(n)
Space Complexity: O(n)
