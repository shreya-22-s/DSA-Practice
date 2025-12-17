import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> st = new HashSet<>();

        // Step 1: Add all numbers to set
        for (int num : nums) {
            st.add(num);
        }

        int maxStreak = 0;

        // Step 2: Traverse the set
        for (int n : st) {

            // Check if n is the start of a sequence
            if (!st.contains(n - 1)) {

                int currNum = n;
                int currStreak = 1;

                // Count consecutive numbers
                while (st.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                maxStreak = Math.max(maxStreak, currStreak);
            }
        }

        return maxStreak;
    }
}
