import java.util.HashMap;

public class SubarraySumEqualsK {

    /**
     * Given an unsorted array of integers, this method returns the count of subarrays
     * whose sum equals the given value k.
     * 
     * Approach:
     * - Use a HashMap to store prefix sums and their frequencies.
     * - For each element, compute the current prefix sum.
     * - Check if (prefixSum - k) exists in the map — this indicates a valid subarray.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Example:
     * Input: arr = [10, 2, -2, -20, 10], k = -10
     * Output: 3 (Subarrays: [10,2,-2,-20], [2,-2,-20,10], [-20,10])
     */
    public static int countSubarraysWithSum(int[] arr, int k) {
        // HashMap to store cumulative sum frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: empty subarray

        int count = 0;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            // Check if there is a prefix sum that, when removed, gives the desired sum
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Update the map with the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        int result = countSubarraysWithSum(arr, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
    }
}
