/*
 * Problem: Candy Store Minimum and Maximum Cost
 *
 * You are given an array prices[] where prices[i] is the price of the i-th candy in the store.
 * The store offers a promotion:
 *   For every candy you buy, you can take up to k other different candies for free.
 *
 * Your task:
 *   - Find the minimum amount of money needed to buy all candies.
 *   - Find the maximum amount of money needed to buy all candies.
 *
 * In both cases, you must take the maximum possible number of free candies each time you buy one.
 *
 * Example:
 * Input: prices = [3, 2, 1, 4], k = 2
 * Output: [3, 7]
 * Explanation:
 * - Minimum cost: Buy candy worth 1, take 4 and 3 for free. Then buy candy worth 2. Total = 3.
 * - Maximum cost: Buy candy worth 4, take 1 and 2 for free. Then buy candy worth 3. Total = 7.
 *
 * Constraints:
 * 1 ≤ prices.length ≤ 10^5
 * 0 ≤ k ≤ prices.length
 * 1 ≤ prices[i] ≤ 10^4
 *
 * Time Complexity: O(n log n) (due to sorting)
 * Space Complexity: O(1) (excluding input storage)
 */
import java.util.*;

public class CandyStore {

    public static ArrayList<Integer> candyStore(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;

        int minCost = 0;
        int left = 0, right = n - 1;

        // Minimum cost calculation
        while (left <= right) {
            minCost += prices[left];
            left++;
            right -= k; // take k most expensive for free
        }

        int maxCost = 0;
        left = 0;
        right = n - 1;

        // Maximum cost calculation
        while (left <= right) {
            maxCost += prices[right];
            right--;
            left += k; // take k cheapest for free
        }

        // Return as an ArrayList
        return new ArrayList<>(Arrays.asList(minCost, maxCost));
    }

    public static void main(String[] args) {
        int[] prices1 = {3, 2, 1, 4};
        int k1 = 2;
        System.out.println(candyStore(prices1, k1)); // [3, 7]

        int[] prices2 = {3, 2, 1, 4, 5};
        int k2 = 4;
        System.out.println(candyStore(prices2, k2)); // [1, 5]
    }
}
