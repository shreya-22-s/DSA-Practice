class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;  // pointer for popped
        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            // pop while top matches popped[j]
            while (!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
