class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        // Push all values into stack
        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }

        // half length
        int n = st.size();
        int half = n / 2;
        
        curr = head;
        int result = 0;

        // compare front values with reversed back values
        for (int i = 0; i < half; i++) {
            result = Math.max(result, curr.val + st.pop());
            curr = curr.next;
        }

        return result;
    }
}
